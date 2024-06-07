package ec.com.kgr.util;

import ec.com.kruger.keycloak.util.KeycloakAuthorization;
import ec.com.kruger.security.sso.springboot2.util.SecurityKeycloakUtil;
import ec.com.kgr.common.KodexRootConstants;
import ec.com.kgr.util.AuthorizationUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpHeaders;

@RunWith(MockitoJUnitRunner.class)
public class AuthorizationUtilsTest {


    @Test
    public void buildHeaderWithKeycloakAuthTest() throws Exception {
        HttpHeaders headers = new HttpHeaders();
        try (MockedStatic<KeycloakAuthorization> utilities = Mockito.mockStatic(
            KeycloakAuthorization.class)) {
            utilities.when(() -> KeycloakAuthorization.getAuthorization(KodexRootConstants.CLIENT_ID,
                    KodexRootConstants.SECRET))
                .thenReturn(headers);
            HttpHeaders headers2 = AuthorizationUtils.getHeaderBySecret();
            Assert.assertNotNull(headers2);
        }
    }


    @Test(expected = Exception.class)
    public void keycloakAuthTestFail() {
        HttpHeaders headers = new HttpHeaders();
        try (MockedStatic<KeycloakAuthorization> utilities = Mockito.mockStatic(
            KeycloakAuthorization.class)) {
            utilities.when(() -> KeycloakAuthorization.getAuthorization(KodexRootConstants.CLIENT_ID,
                    KodexRootConstants.SECRET))
                .thenThrow(new Exception());
            HttpHeaders headers2 = AuthorizationUtils.getHeaderBySecret();
            Assert.assertNotNull(headers2);
        }
    }


    @Test
    public void getHeadersRefreshTokenTest() throws Exception {
        HttpHeaders headers = new HttpHeaders();
        try (MockedStatic<SecurityKeycloakUtil> utilities = Mockito.mockStatic(
            SecurityKeycloakUtil.class)) {
            utilities.when(() -> SecurityKeycloakUtil.getHeadersRefreshToken())
                .thenReturn(headers);
            HttpHeaders headers3 = AuthorizationUtils.getHeadersRefreshToken();
            Assert.assertNotNull(headers3);
        }
    }
}
