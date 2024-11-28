package cc.elvea.boot.system.weixin.service.impl;

import cc.elvea.boot.system.cache.CacheService;
import cc.elvea.boot.system.weixin.config.AppMpConfig;
import cc.elvea.boot.system.weixin.service.WeiXinMpService;
import cc.elvea.boot.system.weixin.storage.WxMpCacheConfigStorage;
import lombok.Getter;
import lombok.Setter;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;
import me.chanjar.weixin.mp.config.WxMpConfigStorage;
import org.springframework.stereotype.Service;

/**
 * @author elvea
 * @since 24.1.0
 */
@Getter
@Setter
@Service
public class WeiXinMpServiceImpl implements WeiXinMpService {

    private CacheService cacheService;

    private final String cacheKeyPrefix = "mp";

    private AppMpConfig appConfig;

    public WeiXinMpServiceImpl(CacheService cacheService) {
        this.cacheService = cacheService;
    }

    /**
     * @see WeiXinMpService#getConfigStorage()
     */
    @Override
    public WxMpConfigStorage getConfigStorage() {
        return this.getConfigStorage(this.appConfig);
    }

    /**
     * @see WeiXinMpService#getConfigStorage(AppMpConfig)
     */
    @Override
    public WxMpConfigStorage getConfigStorage(AppMpConfig appMpConfig) {
        WxMpCacheConfigStorage config = new WxMpCacheConfigStorage(cacheService, cacheKeyPrefix);
        config.setAppId(appMpConfig.getAppId());
        config.setSecret(appMpConfig.getAppSecret());
        return config;
    }

    /**
     * @see WeiXinMpService#getService()
     */
    @Override
    public WxMpService getService() {
        return this.getService(this.appConfig);
    }

    /**
     * @see WeiXinMpService#getService(AppMpConfig)
     */
    @Override
    public WxMpService getService(AppMpConfig appMpConfig) {
        WxMpService wxMpService = new WxMpServiceImpl();
        wxMpService.setWxMpConfigStorage(getConfigStorage(appMpConfig));
        return wxMpService;
    }

}
