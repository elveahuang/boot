package cc.elvea.boot.system.core.service.impl;

import cc.elvea.boot.commons.service.BaseEntityService;
import cc.elvea.boot.commons.utils.ObjectUtils;
import cc.elvea.boot.commons.utils.StringUtils;
import cc.elvea.boot.system.core.model.converter.AccountConverter;
import cc.elvea.boot.system.core.model.dto.AccountDto;
import cc.elvea.boot.system.core.model.entity.AccountEntity;
import cc.elvea.boot.system.core.model.entity.AccountEntity_;
import cc.elvea.boot.system.core.model.form.AccountForm;
import cc.elvea.boot.system.core.model.request.AccountCheckRequest;
import cc.elvea.boot.system.core.model.request.AccountSearchRequest;
import cc.elvea.boot.system.core.repository.AccountRepository;
import cc.elvea.boot.system.core.service.AccountService;
import jakarta.persistence.criteria.Predicate;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author elvea
 * @since 24.1.0
 */
@Slf4j
@Service
@AllArgsConstructor
public class AccountServiceImpl extends BaseEntityService<AccountEntity, Long, AccountRepository> implements AccountService {

    private final AccountConverter accountConverter;

    @Override
    public boolean check(AccountCheckRequest request) {
        if (StringUtils.isNotEmpty(request.getUsername())) {
            Specification<AccountEntity> specification = (root, query, builder) -> {
                List<Predicate> predicates = new ArrayList<>();
                if (StringUtils.isNotEmpty(request.getUsername())) {
                    predicates.add(builder.equal(root.get(AccountEntity_.USERNAME), request.getUsername()));
                }
                if (request.getId() != null && request.getId() > 0) {
                    predicates.add(builder.equal(root.get(AccountEntity_.ID), request.getId()));
                }
                return builder.and(predicates.toArray(new Predicate[0]));
            };
            return this.repository.count(specification) <= 0;
        } else if (StringUtils.isNotEmpty(request.getMobileNumber())) {
            Specification<AccountEntity> specification = (root, query, builder) -> {
                List<Predicate> predicates = new ArrayList<>();
                if (StringUtils.isNotEmpty(request.getEmail())) {
                    predicates.add(builder.equal(root.get(AccountEntity_.MOBILE_NUMBER), request.getMobileNumber()));
                }
                if (request.getId() != null && request.getId() > 0) {
                    predicates.add(builder.equal(root.get(AccountEntity_.ID), request.getId()));
                }
                return builder.and(predicates.toArray(new Predicate[0]));
            };
            return this.repository.count(specification) <= 0;
        } else if (StringUtils.isNotEmpty(request.getEmail())) {
            Specification<AccountEntity> specification = (root, query, builder) -> {
                List<Predicate> predicates = new ArrayList<>();
                if (StringUtils.isNotEmpty(request.getUsername())) {
                    predicates.add(builder.equal(root.get(AccountEntity_.EMAIL), request.getEmail()));
                }
                if (request.getId() != null && request.getId() > 0) {
                    predicates.add(builder.equal(root.get(AccountEntity_.ID), request.getId()));
                }
                return builder.and(predicates.toArray(new Predicate[0]));
            };
            return this.repository.count(specification) <= 0;
        }
        return false;
    }

    @Override
    public Page<AccountDto> search(AccountSearchRequest request) {
        return null;
    }

    @Override
    public AccountEntity findByUsername(String username) {
        AccountEntity condition = AccountEntity.builder().username(username).build();
        Example<AccountEntity> example = Example.of(condition);
        return this.repository.findOne(example).orElse(null);
    }

    @Override
    public AccountEntity findById(Long id) {
        return this.repository.findById(id).orElse(null);
    }

    @Override
    public AccountEntity findByEmail(String email) {
        AccountEntity condition = AccountEntity.builder().email(email).build();
        Example<AccountEntity> example = Example.of(condition);
        return this.repository.findOne(example).orElse(null);
    }

    @Override
    public AccountEntity findByMobile(String mobileCountryCode, String mobileNumber) {
        AccountEntity condition = AccountEntity.builder().mobileCountryCode(mobileCountryCode).mobileNumber(mobileNumber).build();
        Example<AccountEntity> example = Example.of(condition);
        return this.repository.findOne(example).orElse(null);
    }

    @Override
    public void saveAccount(AccountForm form) {
        AccountEntity entity;
        if (form.getId() != null && form.getId() > 0) {
            entity = this.findById(form.getId());
            ObjectUtils.copyNotNullProperties(form, entity);
        } else {
            entity = this.accountConverter.formToEntity(form);
        }
        entity.setActive(Boolean.TRUE);
        this.save(entity);
    }

}
