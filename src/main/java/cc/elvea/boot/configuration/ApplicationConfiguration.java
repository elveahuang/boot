package cc.elvea.boot.configuration;

import cc.elvea.boot.commons.jwt.JwtConfig;
import cc.elvea.boot.commons.jwt.JwtHelper;
import cc.elvea.boot.commons.jwt.JwtStrategy;
import cc.elvea.boot.commons.sequence.HutoolSnowflakeSequence;
import cc.elvea.boot.commons.sequence.Sequence;
import cc.elvea.boot.commons.sequence.SequenceManager;
import cc.elvea.boot.commons.utils.EncryptUtils;
import cc.elvea.boot.commons.utils.SpringUtils;
import cc.elvea.boot.configuration.properties.ArthasProperties;
import cc.elvea.boot.configuration.properties.SequenceProperties;
import com.nimbusds.jose.jwk.JWK;
import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jose.jwk.source.ImmutableJWKSet;
import com.nimbusds.jose.jwk.source.JWKSource;
import com.nimbusds.jose.proc.SecurityContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.security.oauth2.jose.jws.SignatureAlgorithm;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtEncoder;

import java.security.KeyPair;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.UUID;

/**
 * @author elvea
 * @since 24.1.0
 */
@Slf4j
@EnableAsync
@EnableAspectJAutoProxy
@Configuration(proxyBeanMethods = false)
@EnableConfigurationProperties({JwtConfig.class, SequenceProperties.class, ArthasProperties.class})
public class ApplicationConfiguration {

    @Bean
    public SpringUtils springUtils() {
        return new SpringUtils();
    }

    // ------------------------------------------------------------------------
    // 序列
    // ------------------------------------------------------------------------

    @Bean
    public Sequence sequence(SequenceProperties properties) {
        Sequence sequence = new HutoolSnowflakeSequence(properties.getEpoch(), properties.getWorkerId(), properties.getDataCenterId());
        SequenceManager.setSequence(sequence);
        return sequence;
    }

    // ------------------------------------------------------------------------
    // JWT
    // ------------------------------------------------------------------------

    @Bean
    public JWK jwk(JwtConfig config) {
        if (JwtStrategy.MANUEL.equals(config.getStrategy())) {
            RSAPublicKey publicKey = (RSAPublicKey) EncryptUtils.toPublicKey(config.getPublicKeyValue());
            RSAPrivateKey privateKey = (RSAPrivateKey) EncryptUtils.toPrivateKey(config.getPrivateKeyValue());
            return new RSAKey.Builder(publicKey).privateKey(privateKey).keyID(UUID.randomUUID().toString()).build();
        } else {
            KeyPair keyPair = EncryptUtils.generateKeyPair();
            RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
            RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();
            return new RSAKey.Builder(publicKey).privateKey(privateKey).keyID(UUID.randomUUID().toString()).build();
        }
    }

    @Bean
    public JWKSource<SecurityContext> jwkSource(JWK jwk) {
        return new ImmutableJWKSet<>(new JWKSet(jwk));
    }

    @Bean
    public JwtEncoder jwtEncoder(JWKSource<SecurityContext> jwkSource) {
        return new NimbusJwtEncoder(jwkSource);
    }

    @Bean
    public JwtDecoder jwtDecoder(JWK jwk, JwtConfig config) throws Exception {
        return NimbusJwtDecoder.withPublicKey(jwk.toRSAKey().toRSAPublicKey())
                .signatureAlgorithm(SignatureAlgorithm.from(config.getAlgorithm()))
                .build();
    }

    @Bean
    public JwtHelper jwtHelper(JwtConfig config, JwtEncoder encoder, JwtDecoder decoder) {
        return new JwtHelper(config, encoder, decoder);
    }

}
