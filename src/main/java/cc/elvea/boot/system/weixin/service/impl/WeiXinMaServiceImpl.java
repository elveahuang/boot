package cc.elvea.boot.system.weixin.service.impl;

import cc.elvea.boot.system.cache.CacheService;
import cc.elvea.boot.system.weixin.config.AppMaConfig;
import cc.elvea.boot.system.weixin.service.WeiXinMaService;
import cc.elvea.boot.system.weixin.storage.WxMaCacheConfigStorage;
import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.api.impl.WxMaServiceImpl;
import cn.binarywang.wx.miniapp.config.WxMaConfig;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

/**
 * @author elvea
 * @since 24.1.0
 */
@Setter
@Getter
@Service
public class WeiXinMaServiceImpl implements WeiXinMaService {

    private final CacheService cacheService;

    private String cacheKeyPrefix = "ma";

    private AppMaConfig appConfig;

    public WeiXinMaServiceImpl(CacheService cacheService) {
        this.cacheService = cacheService;
    }

    /**
     * @see WeiXinMaService#getConfigStorage()
     */
    @Override
    public WxMaConfig getConfigStorage() {
        return this.getConfigStorage(this.appConfig);
    }

    /**
     * @see WeiXinMaService#getConfigStorage(AppMaConfig)
     */
    @Override
    public WxMaConfig getConfigStorage(AppMaConfig appMaConfig) {
        WxMaCacheConfigStorage config = new WxMaCacheConfigStorage(cacheService, cacheKeyPrefix);
        config.setAppid(appMaConfig.getAppId());
        config.setSecret(appMaConfig.getAppSecret());
        return config;
    }

    /**
     * @see WeiXinMaService#getService()
     */
    @Override
    public WxMaService getService() {
        return this.getService(this.appConfig);
    }

    /**
     * @see WeiXinMaService#getService(AppMaConfig)
     */
    @Override
    public WxMaService getService(AppMaConfig appMaConfig) {
        WxMaService wxMaService = new WxMaServiceImpl();
        wxMaService.setWxMaConfig(getConfigStorage(appMaConfig));
        return wxMaService;
    }

}
