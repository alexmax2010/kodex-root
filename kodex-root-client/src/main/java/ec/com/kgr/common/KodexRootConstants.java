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
    public static final String CONTEXT = "baseapp";
    public static final String FOLDER = "DOCUMENTOS";
    public static final String STATUS_ACT = "ACT";
    public static final String STATUS_INA = "INA";
    public static final String SYSTEM_ID = "KODEX";
    public static final String SECRET = KodexRootMessages.getString("base.ws.client.secret");

    private KodexRootConstants() {
        super();
    }

}
