package cc.elvea.boot.commons.jwt;

import org.springframework.security.oauth2.jwt.*;

/**
 * @author elvea
 * @since 24.1.0
 */
public record JwtHelper(JwtConfig config, JwtEncoder encoder, JwtDecoder decoder) {

    /**
     * @param claimsSet 1 {@link JwtClaimsSet}
     * @return {@link Jwt}
     */
    public Jwt generateJwtToken(JwtClaimsSet claimsSet) {
        return this.encoder.encode(JwtEncoderParameters.from(claimsSet));
    }

    /**
     * @param token String
     * @return {@link Jwt}
     */
    public Jwt parseJwtToken(String token) {
        return this.decoder.decode(token);
    }

}
