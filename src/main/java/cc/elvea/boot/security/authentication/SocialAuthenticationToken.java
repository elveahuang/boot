package cc.elvea.boot.security.authentication;

import cc.elvea.boot.commons.utils.CollectionUtils;
import cc.elvea.boot.security.CustomAuthorizationGrantType;
import lombok.Getter;
import org.springframework.lang.Nullable;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.server.authorization.authentication.OAuth2AuthorizationGrantAuthenticationToken;
import org.springframework.util.Assert;

import java.util.*;

/**
 * @author elvea
 * @since 24.1.0
 */
@Getter
public class SocialAuthenticationToken extends OAuth2AuthorizationGrantAuthenticationToken {

    private final Set<String> scopes;

    public SocialAuthenticationToken(Authentication clientPrincipal, @Nullable Set<String> scopes, @Nullable Map<String, Object> additionalParameters) {
        super(CustomAuthorizationGrantType.PASSWORD, clientPrincipal, additionalParameters);
        Assert.notNull(clientPrincipal, "clientPrincipal cannot be null");
        this.scopes = Collections.unmodifiableSet(CollectionUtils.isNotEmpty(scopes) ? new HashSet<>(Objects.requireNonNull(scopes)) : Collections.emptySet());
    }

}
