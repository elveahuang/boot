package cc.elvea.boot.system.core.service;

import cc.elvea.boot.commons.service.EntityService;
import cc.elvea.boot.system.core.model.entity.UserEntity;
import cc.elvea.boot.system.core.model.form.UserForm;
import cc.elvea.boot.system.core.model.request.UserCheckRequest;
import cc.elvea.boot.system.core.repository.UserRepository;

/**
 * @author elvea
 * @since 24.1.0
 */
public interface UserService extends EntityService<UserEntity, Long, UserRepository> {

    /**
     * 检查用户名是否可用
     */
    boolean check(UserCheckRequest request);

    /**
     * 根据用户名查找用户
     */
    UserEntity findByUsername(String username);

    /**
     * 根据邮箱查找用户
     */
    UserEntity findByEmail(String email);

    /**
     * 根据手机查找用户
     */
    UserEntity findByMobile(String mobileCountryCode, String mobileNumber);

    /**
     * 获取系统管理员
     */
    UserEntity getSystemAdministrator();

    /**
     * 保存用户
     */
    void saveUser(UserForm form);

}
