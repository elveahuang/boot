package cc.elvea.boot.configuration;

import cc.elvea.boot.commons.data.UserAuditorAware;
import cc.elvea.boot.commons.utils.JacksonUtils;
import lombok.extern.slf4j.Slf4j;
import org.redisson.codec.JsonJacksonCodec;
import org.redisson.spring.starter.RedissonAutoConfigurationCustomizer;
import org.springframework.boot.autoconfigure.orm.jpa.HibernatePropertiesCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author elvea
 * @since 24.1.0
 */
@Slf4j
@Configuration(proxyBeanMethods = false)
public class DataConfiguration {

    // ------------------------------------------------------------------------
    // Hibernate
    // ------------------------------------------------------------------------

    @Bean
    public HibernatePropertiesCustomizer hibernatePropertiesCustomizer() {
        return properties -> {
            properties.put("hibernate.show_sql", "true");
            properties.put("hibernate.format_sql", "true");
        };
    }

    // ------------------------------------------------------------------------
    // Spring Data
    // ------------------------------------------------------------------------

    @Bean
    public UserAuditorAware userAuditorAware() {
        return new UserAuditorAware();
    }

    // ------------------------------------------------------------------------
    // Redisson
    // ------------------------------------------------------------------------

    @Bean
    public RedissonAutoConfigurationCustomizer redissonAutoConfigurationCustomizer() {
        return configuration -> configuration.setCodec(new JsonJacksonCodec(JacksonUtils.getCacheObjectMapper()));
    }

}
