package cc.elvea.boot.system.core.api.impl;

import cc.elvea.boot.commons.enums.ActionTypeEnum;
import cc.elvea.boot.commons.enums.CaptchaTypeEnum;
import cc.elvea.boot.commons.enums.ResponseCodeEnum;
import cc.elvea.boot.commons.utils.ObjectUtils;
import cc.elvea.boot.commons.utils.SecurityUtils;
import cc.elvea.boot.commons.utils.StringUtils;
import cc.elvea.boot.commons.web.response.Response;
import cc.elvea.boot.system.captcha.request.CaptchaCheckRequest;
import cc.elvea.boot.system.captcha.service.CaptchaService;
import cc.elvea.boot.system.core.api.AccountApi;
import cc.elvea.boot.system.core.model.converter.AccountConverter;
import cc.elvea.boot.system.core.model.dto.AccountForgotPasswordDto;
import cc.elvea.boot.system.core.model.dto.AccountInfoDto;
import cc.elvea.boot.system.core.model.dto.AccountLoginInfoDto;
import cc.elvea.boot.system.core.model.dto.UserSessionDto;
import cc.elvea.boot.system.core.model.entity.AccountEntity;
import cc.elvea.boot.system.core.model.form.*;
import cc.elvea.boot.system.core.model.request.AccountCheckRequest;
import cc.elvea.boot.system.core.service.AccountService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author elvea
 * @since 24.1.0
 */
@Slf4j
@Service
@AllArgsConstructor
public class AccountApiImpl implements AccountApi {

    private final AccountConverter accountConverter;

    private final AccountService accountService;

    private final PasswordEncoder passwordEncoder;

    private final CaptchaService captchaService;

    /**
     * @see AccountApi#check(AccountCheckRequest)
     */
    @Override
    public boolean check(AccountCheckRequest request) {
        return this.accountService.check(request);
    }

    /**
     * @see AccountApi#register(AccountRegisterForm)
     */
    @Override
    public Response<?> register(AccountRegisterForm form) {
        // 检测验证码
        CaptchaCheckRequest captchaCheckRequest = CaptchaCheckRequest.builder()
                .type(CaptchaTypeEnum.MAIL)
                .email(form.getEmail())
                .key(form.getCaptchaKey())
                .value(form.getCaptchaValue())
                .build();
        if (!captchaService.validate(captchaCheckRequest)) {
            return Response.error();
        }
        // 检测用户名是否可用
        AccountCheckRequest usernameCheckRequest = AccountCheckRequest.builder().username(form.getUsername()).build();
        if (!accountService.check(usernameCheckRequest)) {
            return Response.fail(ResponseCodeEnum.USER__USERNAME_NOT_AVAILABLE);
        }
        // 检测邮箱是否可用
        AccountCheckRequest emailCheckRequest = AccountCheckRequest.builder().email(form.getEmail()).build();
        if (!accountService.check(emailCheckRequest)) {
            return Response.fail(ResponseCodeEnum.USER__EMAIL_NOT_AVAILABLE);
        }
        // 保存账号
        AccountEntity entity = AccountEntity.builder()
                .username(form.getUsername())
                .displayName(form.getUsername())
                .name(form.getUsername())
                .password(passwordEncoder.encode(form.getPassword()))
                .email(form.getEmail())
                .build();
        accountService.save(entity);
        return Response.success();
    }

    /**
     * @see AccountApi#getUserInfo(String)
     */
    @Override
    public AccountInfoDto getUserInfo(String username) {
        AccountEntity entity = accountService.findByUsername(username);
        return getInfoDto(entity);
    }

    /**
     * @see AccountApi#findByUsername(String)
     */
    @Override
    public AccountLoginInfoDto findByUsername(String username) {
        AccountEntity entity = accountService.findByUsername(username);
        return getLoginInfoDto(entity);
    }

    /**
     * @see AccountApi#findByMobile(String, String)
     */
    @Override
    public AccountLoginInfoDto findByMobile(String mobileCountryCode, String mobileNumber) {
        AccountEntity entity = accountService.findByMobile(mobileCountryCode, mobileNumber);
        return getLoginInfoDto(entity);
    }

    /**
     * @see AccountApi#findByEmail(String)
     */
    @Override
    public AccountLoginInfoDto findByEmail(String email) {
        AccountEntity entity = accountService.findByEmail(email);
        return getLoginInfoDto(entity);
    }

    /**
     * @see AccountApi#updateAccount(AccountBaseForm)
     */
    @Override
    public Response<?> updateAccount(AccountBaseForm form) {
        AccountEntity entity = accountService.findByUsername(SecurityUtils.getUsername());
        if (ObjectUtils.isEmpty(entity)) {
            return Response.error();
        }
        entity.setDisplayName(form.getDisplayName());
        entity.setSex(form.getSex());
        entity.setBirthday(form.getBirthday());
        accountService.updateById(entity);
        return Response.success();
    }

    /**
     * @see AccountApi#forgotPassword(AccountForgotPasswordForm)
     */
    @Override
    public Response<AccountForgotPasswordDto> forgotPassword(AccountForgotPasswordForm form) {
        // 检测验证码
        CaptchaCheckRequest captchaCheckRequest = CaptchaCheckRequest.builder()
                .type(CaptchaTypeEnum.MAIL)
                .email(form.getEmail())
                .key(form.getCaptchaKey())
                .value(form.getCaptchaValue())
                .build();
        if (!captchaService.check(captchaCheckRequest)) {
            return Response.error();
        }
        // 检测邮箱和用户名是否存在
        AccountEntity entity = accountService.findByEmail(form.getEmail());
        if (entity != null) {
            return Response.success(AccountForgotPasswordDto.builder().email(entity.getEmail()).username(entity.getUsername()).build());
        }
        return Response.error();
    }

    /**
     * @see AccountApi#resetPassword(AccountResetPasswordForm)
     */
    @Override
    public Response<?> resetPassword(AccountResetPasswordForm form) {
        // 校验并删除验证码
        CaptchaCheckRequest captchaCheckRequest = CaptchaCheckRequest.builder()
                .type(CaptchaTypeEnum.MAIL)
                .email(form.getEmail())
                .key(form.getCaptchaKey())
                .value(form.getCaptchaValue())
                .build();
        if (!captchaService.validate(captchaCheckRequest)) {
            return Response.error();
        }
        // 检测邮箱和用户名是否存在
        AccountEntity entity = accountService.findByEmail(form.getEmail());
        if (entity != null) {
            entity.setPassword(passwordEncoder.encode(form.getPassword()));
            accountService.updateById(entity);
            return Response.success();
        }
        return Response.error();
    }

    /**
     * @see AccountApi#changePassword(AccountChangePasswordForm)
     */
    @Override
    public Response<?> changePassword(AccountChangePasswordForm form) {
        AccountEntity entity = accountService.findByUsername(SecurityUtils.getUsername());
        if (ObjectUtils.isEmpty(entity) || !passwordEncoder.matches(form.getOriginalPassword(), entity.getPassword())) {
            return Response.error();
        }
        entity.setPassword(passwordEncoder.encode(form.getNewPassword()));
        accountService.updateById(entity);
        return Response.success();
    }

    /**
     * @see AccountApi#changeEmail(AccountChangeEmailForm)
     */
    @Override
    public Response<?> changeEmail(AccountChangeEmailForm form) {
        // 检验就邮箱是否是当前登陆用户的邮箱
        AccountEntity entity = accountService.findByUsername(SecurityUtils.getUsername());
        if (!entity.getEmail().equals(form.getEmail())) {
            return Response.error();
        }
        // 检验登陆密码是否正确
        if (!passwordEncoder.matches(form.getPassword(), entity.getPassword())) {
            return Response.error();
        }
        // 校验验证码
        CaptchaCheckRequest captchaCheckRequest = CaptchaCheckRequest.builder()
                .type(CaptchaTypeEnum.MAIL)
                .email(form.getEmail())
                .key(form.getCaptchaKey())
                .value(form.getCaptchaValue())
                .build();
        if (!captchaService.check(captchaCheckRequest)) {
            return Response.error();
        }
        // 修改邮箱
        entity.setEmail(form.getNewEmail());
        accountService.updateById(entity);
        return Response.success();
    }

    /**
     * @see AccountApi#logout()
     */
    @Override
    public Response<?> logout() {
        if (SecurityUtils.isAnonymous()) {
            return Response.success();
        }
        try {
            Long uid = SecurityUtils.getUid();
            String sid = SecurityUtils.getSid();
            String userName = SecurityUtils.getUsername();
            log.info("Account logout username - [{}}] - uid - [{}]. - sid - [{}].", userName, uid, sid);

            if (StringUtils.isNotEmpty(sid)) {
                UserSessionDto userSession = UserSessionDto.builder()
                        .actionType(ActionTypeEnum.DELETE)
                        .sessionId(sid)
                        .userId(uid)
                        .username(userName)
                        .build();
//                this.userSessionAmqpService.send(userSession);
            }
        } catch (Exception e) {
            log.error("Failed to save UserSession.", e);
        }
        return Response.success();
    }

    //
    // 辅助方法
    //

    private AccountInfoDto getInfoDto(AccountEntity entity) {
        if (ObjectUtils.isEmpty(entity)) {
            return null;
        }
        return this.accountConverter.entity2InfoDto(entity);
    }

    private AccountLoginInfoDto getLoginInfoDto(AccountEntity entity) {
        if (ObjectUtils.isEmpty(entity)) {
            return null;
        }
        return this.accountConverter.entity2LoginInfoDto(entity);
    }

}
