package ec.com.kgr.common;

import org.junit.Assert;
import org.junit.Test;

public class KodexRootConstantsTest {

    @Test
    public void concatTest() {
        Assert.assertEquals("/datosCorporativo/server/getCatalogList/",
            KodexRootConstants.URL_GET_CATALOG_LIST);
    }

}
