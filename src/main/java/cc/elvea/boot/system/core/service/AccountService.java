package cc.elvea.boot.system.core.service;

import cc.elvea.boot.commons.service.EntityService;
import cc.elvea.boot.system.core.model.dto.AccountDto;
import cc.elvea.boot.system.core.model.entity.AccountEntity;
import cc.elvea.boot.system.core.model.form.AccountForm;
import cc.elvea.boot.system.core.model.request.AccountCheckRequest;
import cc.elvea.boot.system.core.model.request.AccountSearchRequest;
import cc.elvea.boot.system.core.repository.AccountRepository;
import org.springframework.data.domain.Page;

/**
 * @author elvea
 * @since 24.1.0
 */
public interface AccountService extends EntityService<AccountEntity, Long, AccountRepository> {

    /**
     * 检查用户名是否可用
     */
    boolean check(AccountCheckRequest request);

    /**
     * 搜索用户
     */
    Page<AccountDto> search(AccountSearchRequest request);

    /**
     * 根据用户名查找用户
     */
    AccountEntity findByUsername(String username);

    /**
     * 根据ID查找用户
     */
    AccountEntity findById(Long id);

    /**
     * 根据邮箱查找用户
     */
    AccountEntity findByEmail(String email);

    /**
     * 根据手机查找用户
     */
    AccountEntity findByMobile(String mobileCountryCode, String mobileNumber);

    /**
     * 保存用户
     */
    void saveAccount(AccountForm form);

}
