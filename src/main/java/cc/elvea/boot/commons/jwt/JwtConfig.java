package cc.elvea.boot.commons.jwt;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.security.oauth2.jose.jws.JwsAlgorithms;

import java.time.Duration;

/**
 * @author elvea
 * @since 24.1.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ConfigurationProperties(JwtConfig.PREFIX)
public class JwtConfig {
    public static final String PREFIX = "platform.jwt";

    @Builder.Default
    private JwtStrategy strategy = JwtStrategy.AUTO;

    @Builder.Default
    private String algorithm = JwsAlgorithms.RS256;

    private String publicKeyValue;

    private String privateKeyValue;

    @Builder.Default
    private Duration authorizationCodeTimeToLive = Duration.ofMinutes(5);

    @Builder.Default
    private Duration deviceCodeTimeToLive = Duration.ofMinutes(5);

    @Builder.Default
    private Duration accessTokenTimeToLive = Duration.ofMinutes(60);

    @Builder.Default
    private Duration refreshTokenTimeToLive = Duration.ofDays(14);

}
