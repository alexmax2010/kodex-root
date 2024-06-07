package ec.com.kgr.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Class VO for catalog external process.
 *
 * @author components on 2021/08/23.
 * @version 1.0
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CatalogVo {

    private String catalogId;
    private String group;
    private String value;
    private String description;

}
