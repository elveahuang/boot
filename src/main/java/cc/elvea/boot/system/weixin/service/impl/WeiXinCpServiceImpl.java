package cc.elvea.boot.system.weixin.service.impl;

import cc.elvea.boot.commons.utils.StringUtils;
import cc.elvea.boot.system.cache.CacheService;
import cc.elvea.boot.system.weixin.config.AppCpConfig;
import cc.elvea.boot.system.weixin.service.WeiXinCpService;
import cc.elvea.boot.system.weixin.storage.WxCpCacheConfigStorage;
import lombok.Getter;
import lombok.Setter;
import me.chanjar.weixin.cp.api.WxCpMessageService;
import me.chanjar.weixin.cp.api.WxCpService;
import me.chanjar.weixin.cp.api.WxCpUserService;
import me.chanjar.weixin.cp.api.impl.WxCpServiceImpl;
import me.chanjar.weixin.cp.config.WxCpConfigStorage;
import org.springframework.stereotype.Service;

/**
 * @author elvea
 * @since 24.1.0
 */
@Getter
@Setter
@Service
public class WeiXinCpServiceImpl implements WeiXinCpService {

    private final CacheService cacheService;

    private String cacheKeyPrefix = "cp";

    private AppCpConfig appConfig;

    public WeiXinCpServiceImpl(CacheService cacheService) {
        this.cacheService = cacheService;
    }

    /**
     * @see WeiXinCpService#getConfigStorage()
     */
    @Override
    public WxCpConfigStorage getConfigStorage() {
        return this.getConfigStorage(this.appConfig);
    }

    /**
     * @see WeiXinCpService#getConfigStorage(AppCpConfig)
     */
    @Override
    public WxCpConfigStorage getConfigStorage(AppCpConfig appCpConfig) {
        WxCpCacheConfigStorage config = new WxCpCacheConfigStorage(cacheService, cacheKeyPrefix);
        config.setCorpId(appCpConfig.getCorpId());
        config.setCorpSecret(appCpConfig.getCorpSecret());
        config.setAgentId(appCpConfig.getAgentId());
        if (StringUtils.isNotEmpty(appCpConfig.getToken())) {
            config.setToken(appCpConfig.getToken());
        }
        return config;
    }

    /**
     * @see WeiXinCpService#getService()
     */
    @Override
    public WxCpService getService() {
        return this.getService(this.appConfig);
    }

    /**
     * @see WeiXinCpService#getService(AppCpConfig)
     */
    @Override
    public WxCpService getService(AppCpConfig appCpConfig) {
        WxCpService wxCpService = new WxCpServiceImpl();
        wxCpService.setWxCpConfigStorage(getConfigStorage(appCpConfig));
        return wxCpService;
    }

    /**
     * @see WeiXinCpService#getMessageService(AppCpConfig)
     */
    @Override
    public WxCpMessageService getMessageService() {
        return this.getMessageService(this.getAppConfig());
    }

    /**
     * @see WeiXinCpService#getMessageService(AppCpConfig)
     */
    @Override
    public WxCpMessageService getMessageService(AppCpConfig appConfig) {
        return this.getService(appConfig).getMessageService();
    }

    /**
     * @see WeiXinCpService#getUserService(AppCpConfig)
     */
    @Override
    public WxCpUserService getUserService() {
        return this.getUserService(this.getAppConfig());
    }

    /**
     * @see WeiXinCpService#getUserService(AppCpConfig)
     */
    @Override
    public WxCpUserService getUserService(AppCpConfig appConfig) {
        return this.getService(appConfig).getUserService();
    }

}
