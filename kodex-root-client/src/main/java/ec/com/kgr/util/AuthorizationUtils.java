package ec.com.kgr.util;

import ec.com.kgr.common.KodexRootConstants;
import ec.com.kgr.exception.KodexRootRuntimeException;
import ec.com.kruger.keycloak.util.KeycloakAuthorization;
import ec.com.kruger.security.sso.springboot2.util.simple.SimpleSecurityKeycloakUtil;
import org.springframework.http.HttpHeaders;

/**
 * Authorization utils.
 *
 * @author components on 2022/09/01.
 * @version 1.0.0
 */
public final class AuthorizationUtils {

    private AuthorizationUtils() {
        super();
    }

    /**
     * Get current keycloak token.
     *
     * @return HttpHeaders
     * @author components on 2023/05/19
     */
    public static HttpHeaders getHeadersRefreshToken() {
        return SimpleSecurityKeycloakUtil.getHeadersRefreshToken();
    }

    /**
     * Get the token for client secret.
     *
     * @return HttpHeaders instance
     * @author components on 2022/09/01
     */
    public static HttpHeaders getHeaderBySecret() {
        try {
            return KeycloakAuthorization.getAuthorization(KodexRootConstants.CLIENT_ID,
                KodexRootConstants.SECRET);
        } catch (Exception e) {
            throw new KodexRootRuntimeException("Error to get token authorization", e);
        }
    }

}
