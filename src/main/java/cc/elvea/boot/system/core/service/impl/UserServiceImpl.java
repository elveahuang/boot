package cc.elvea.boot.system.core.service.impl;

import cc.elvea.boot.commons.service.BaseEntityService;
import cc.elvea.boot.commons.utils.ObjectUtils;
import cc.elvea.boot.commons.utils.StringUtils;
import cc.elvea.boot.system.core.model.converter.UserConverter;
import cc.elvea.boot.system.core.model.entity.UserEntity;
import cc.elvea.boot.system.core.model.entity.UserEntity_;
import cc.elvea.boot.system.core.model.form.UserForm;
import cc.elvea.boot.system.core.model.request.UserCheckRequest;
import cc.elvea.boot.system.core.repository.UserRepository;
import cc.elvea.boot.system.core.service.UserService;
import jakarta.persistence.criteria.Predicate;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Example;
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
public class UserServiceImpl extends BaseEntityService<UserEntity, Long, UserRepository> implements UserService {

    private final UserConverter userConverter;

    @Override
    public boolean check(UserCheckRequest request) {
        if (StringUtils.isNotEmpty(request.getUsername())) {
            Specification<UserEntity> specification = (root, query, builder) -> {
                List<Predicate> predicates = new ArrayList<>();
                if (StringUtils.isNotEmpty(request.getUsername())) {
                    predicates.add(builder.equal(root.get(UserEntity_.USERNAME), request.getUsername()));
                }
                if (request.getId() != null && request.getId() > 0) {
                    predicates.add(builder.equal(root.get(UserEntity_.ID), request.getId()));
                }
                return builder.and(predicates.toArray(new Predicate[0]));
            };
            return this.repository.count(specification) <= 0;
        } else if (StringUtils.isNotEmpty(request.getMobileNumber())) {
            Specification<UserEntity> specification = (root, query, builder) -> {
                List<Predicate> predicates = new ArrayList<>();
                if (StringUtils.isNotEmpty(request.getEmail())) {
                    predicates.add(builder.equal(root.get(UserEntity_.MOBILE_NUMBER), request.getMobileNumber()));
                }
                if (request.getId() != null && request.getId() > 0) {
                    predicates.add(builder.equal(root.get(UserEntity_.ID), request.getId()));
                }
                return builder.and(predicates.toArray(new Predicate[0]));
            };
            return this.repository.count(specification) <= 0;
        } else if (StringUtils.isNotEmpty(request.getEmail())) {
            Specification<UserEntity> specification = (root, query, builder) -> {
                List<Predicate> predicates = new ArrayList<>();
                if (StringUtils.isNotEmpty(request.getUsername())) {
                    predicates.add(builder.equal(root.get(UserEntity_.EMAIL), request.getEmail()));
                }
                if (request.getId() != null && request.getId() > 0) {
                    predicates.add(builder.equal(root.get(UserEntity_.ID), request.getId()));
                }
                return builder.and(predicates.toArray(new Predicate[0]));
            };
            return this.repository.count(specification) <= 0;
        }
        return false;
    }

    @Override
    public UserEntity findByUsername(String username) {
        UserEntity condition = UserEntity.builder().username(username).build();
        Example<UserEntity> example = Example.of(condition);
        return this.repository.findOne(example).orElse(null);
    }

    @Override
    public UserEntity findByEmail(String email) {
        UserEntity condition = UserEntity.builder().email(email).build();
        Example<UserEntity> example = Example.of(condition);
        return this.repository.findOne(example).orElse(null);
    }

    @Override
    public UserEntity findByMobile(String mobileCountryCode, String mobile) {
        UserEntity condition = UserEntity.builder().mobileCountryCode(mobileCountryCode).mobileNumber(mobile).build();
        Example<UserEntity> example = Example.of(condition);
        return this.repository.findOne(example).orElse(null);
    }

    @Override
    public UserEntity getSystemAdministrator() {
        return this.findById(1L);
    }

    @Override
    public void saveUser(UserForm form) {
        UserEntity entity;
        if (form.getId() != null && form.getId() > 0) {
            entity = this.findById(form.getId());
            ObjectUtils.copyNotNullProperties(form, entity);
        } else {
            entity = this.userConverter.formToEntity(form);
        }
        entity.setActive(Boolean.TRUE);
        this.save(entity);
    }

}
