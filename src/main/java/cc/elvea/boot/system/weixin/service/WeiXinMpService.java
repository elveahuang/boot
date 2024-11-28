package cc.elvea.boot.system.weixin.service;

import cc.elvea.boot.system.weixin.config.AppMpConfig;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.config.WxMpConfigStorage;

/**
 * @author elvea
 * @since 24.1.0
 */
public interface WeiXinMpService {

    WxMpConfigStorage getConfigStorage();

    WxMpConfigStorage getConfigStorage(AppMpConfig appConfig);

    WxMpService getService();

    WxMpService getService(AppMpConfig appConfig);

}
