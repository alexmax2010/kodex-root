package ec.com.kgr.common;

import org.junit.Assert;
import org.junit.Test;

public class KodexRootMessagesTest {

    @Test
    public void initBaseMessages() {
        Assert.assertNotNull(KodexRootMessages.MESSAGE_RESOLVER);
    }

    @Test
    public void getUrlFindUniqueCompany() {
        Assert.assertEquals(
            "/admCorporateData/api/v1/functionary/findUniqueCompania",
            KodexRootConstants.URL_GET_COMPANY);
    }

}
