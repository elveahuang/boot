package cc.elvea.boot.system.weixin.service;

import cc.elvea.boot.system.weixin.config.AppCpConfig;
import me.chanjar.weixin.cp.api.WxCpMessageService;
import me.chanjar.weixin.cp.api.WxCpService;
import me.chanjar.weixin.cp.api.WxCpUserService;
import me.chanjar.weixin.cp.config.WxCpConfigStorage;

/**
 * @author elvea
 * @since 24.1.0
 */
public interface WeiXinCpService {

    WxCpConfigStorage getConfigStorage();

    WxCpConfigStorage getConfigStorage(AppCpConfig appConfig);

    WxCpService getService();

    WxCpService getService(AppCpConfig appConfig);

    WxCpMessageService getMessageService();

    WxCpMessageService getMessageService(AppCpConfig appConfig);

    WxCpUserService getUserService();

    WxCpUserService getUserService(AppCpConfig appConfig);

}
