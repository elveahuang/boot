package cc.elvea.boot.system.weixin.service;

import cc.elvea.boot.system.weixin.config.AppMaConfig;
import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.config.WxMaConfig;

/**
 * @author elvea
 * @since 24.1.0
 */
public interface WeiXinMaService {

    WxMaConfig getConfigStorage();

    WxMaConfig getConfigStorage(AppMaConfig appConfig);

    WxMaService getService();

    WxMaService getService(AppMaConfig appConfig);

}
