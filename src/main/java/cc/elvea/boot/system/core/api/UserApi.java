package cc.elvea.boot.system.core.api;

import cc.elvea.boot.commons.web.response.Response;
import cc.elvea.boot.system.core.model.dto.UserForgotPasswordDto;
import cc.elvea.boot.system.core.model.dto.UserInfoDto;
import cc.elvea.boot.system.core.model.dto.UserLoginInfoDto;
import cc.elvea.boot.system.core.model.form.*;
import cc.elvea.boot.system.core.model.request.UserCheckRequest;

/**
 * @author elvea
 * @since 24.1.0
 */
public interface UserApi {

    /**
     * 检查用户名，邮箱或者手机号码是否可用
     */
    boolean check(UserCheckRequest request);

    /**
     * 用户注册
     */
    Response<?> register(UserRegisterForm form);

    /**
     * 获取登录用户信息
     */
    UserInfoDto getUserInfo(String username);

    /**
     * 根据用户名查找用户
     */
    UserLoginInfoDto findByUsername(String username);

    /**
     * 根据手机号码查找用户
     */
    UserLoginInfoDto findByMobile(String mobileCountryCode, String mobileNumber);

    /**
     * 根据邮箱查找用户
     */
    UserLoginInfoDto findByEmail(String email);

    /**
     * 修改用户个人信息
     */
    Response<?> updateAccount(UserBaseForm userAccountForm);

    /**
     * 忘记密码
     */
    Response<UserForgotPasswordDto> forgotPassword(UserForgotPasswordForm form);

    /**
     * 重置个人密码
     */
    Response<?> resetPassword(UserResetPasswordForm form);

    /**
     * 修改个人密码
     */
    Response<?> changePassword(UserChangePasswordForm form);

    /**
     * 修改个人邮箱
     */
    Response<?> changeEmail(UserChangeEmailForm form);

    /**
     * 退出登录
     */
    Response<?> logout();

}
