package cc.elvea.boot.system.core.api;

import cc.elvea.boot.commons.web.response.Response;
import cc.elvea.boot.system.core.model.dto.AccountForgotPasswordDto;
import cc.elvea.boot.system.core.model.dto.AccountInfoDto;
import cc.elvea.boot.system.core.model.dto.AccountLoginInfoDto;
import cc.elvea.boot.system.core.model.form.*;
import cc.elvea.boot.system.core.model.request.AccountCheckRequest;

/**
 * @author elvea
 * @since 24.1.0
 */
public interface AccountApi {

    /**
     * 检查用户名，邮箱或者手机号码是否可用
     */
    boolean check(AccountCheckRequest request);

    /**
     * 账号注册
     */
    Response<?> register(AccountRegisterForm form);

    /**
     * 获取登录账号信息
     */
    AccountInfoDto getUserInfo(String username);

    /**
     * 根据用户名查找账号
     */
    AccountLoginInfoDto findByUsername(String username);

    /**
     * 根据手机号码查找账号
     */
    AccountLoginInfoDto findByMobile(String mobileCountryCode, String mobileNumber);

    /**
     * 根据邮箱查找账号
     */
    AccountLoginInfoDto findByEmail(String email);

    /**
     * 修改用户个人信息
     */
    Response<?> updateAccount(AccountBaseForm form);

    /**
     * 忘记密码
     */
    Response<AccountForgotPasswordDto> forgotPassword(AccountForgotPasswordForm form);

    /**
     * 重置个人密码
     */
    Response<?> resetPassword(AccountResetPasswordForm form);

    /**
     * 修改个人密码
     */
    Response<?> changePassword(AccountChangePasswordForm form);

    /**
     * 修改个人邮箱
     */
    Response<?> changeEmail(AccountChangeEmailForm form);

    /**
     * 退出登录
     */
    Response<?> logout();

}
