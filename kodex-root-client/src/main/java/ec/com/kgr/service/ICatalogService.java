package ec.com.kgr.service;

import java.util.List;
import ec.com.kgr.vo.CatalogVo;

/**
 * Catalog Service specification.
 *
 * @author components on 2021/09/15.
 * @version 1.0
 */
public interface ICatalogService {

    /**
     * Find list catalog by Type.
     *
     * @return An array of CatalogVo
     */
    List<CatalogVo> getCatalogs(String catalogType);

}
