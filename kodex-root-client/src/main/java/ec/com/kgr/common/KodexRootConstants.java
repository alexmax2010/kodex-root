package ec.com.kgr.common;

/**
 * Global Constants specification.
 *
 * @author components on 2021/08/23.
 * @version 1.0
 */
public final class KodexRootConstants {
    public static final String URL_GET_CATALOG_LIST = "/datosCorporativo/server/getCatalogList/";
    public static final String URL_GET_COMPANY = "/admCorporateData/api/v1/functionary/findUniqueCompania";
    public static final String CLIENT_ID = "BASE-WS";
    public static final String SECRET = KodexRootMessages.getString("base.ws.client.secret");
    public static final String ACT = "ACT";
    public static final String INA = "INA";
    public static final String PEN = "PEN";

    private KodexRootConstants() {
        super();
    }

}
