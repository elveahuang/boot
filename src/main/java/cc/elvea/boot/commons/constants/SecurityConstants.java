package cc.elvea.boot.commons.constants;

/**
 * @author elvea
 * @since 24.1.0
 */
public interface SecurityConstants {
    String API_REQUEST_PATH = "/api/**";
    String JWT_KEY_UID = "uid";

    String JWT_KEY_USERNAME = "username";

    String JWT_KEY_AUTHORITIES = "authorities";

    /**
     * =================================================================================================================
     * OAuth2 Endpoint
     * =================================================================================================================
     */

    String OAUTH_AUTHORIZATION_ENDPOINT = "/oauth/authorize";

    String OAUTH_DEVICE_AUTHORIZATION_ENDPOINT = "/oauth/device_authorization";

    String OAUTH_DEVICE_VERIFICATION_ENDPOINT = "/oauth/device_verification";

    String OAUTH_TOKEN_ENDPOINT = "/oauth/token";

    String OAUTH_TOKEN_INTROSPECTION_ENDPOINT = "/oauth/introspect";

    String OAUTH_TOKEN_REVOCATION_ENDPOINT = "/oauth/revoke";

    String OAUTH_JWK_SET_ENDPOINT = "/oauth/jwks";

    String OAUTH_OIDC_USER_INFO_ENDPOINT = "/userinfo";

    String OAUTH_OIDC_LOGOUT_ENDPOINT = "/connect/logout";

    String OAUTH_OIDC_CLIENT_REGISTRATION_ENDPOINT = "/connect/register";

}
