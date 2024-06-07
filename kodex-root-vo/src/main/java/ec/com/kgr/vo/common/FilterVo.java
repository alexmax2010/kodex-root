package ec.com.kgr.vo.common;

import java.util.Collection;
import ec.com.kruger.spring.orm.dto.SearchModelDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Class Vo for SearchModelDTO.
 *
 * @author components on 2022/01/31.
 * @version 1.0
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FilterVo {

    private Collection<SearchModelDTO<?>> filters;
    private Integer page;
    private Integer size;
}
