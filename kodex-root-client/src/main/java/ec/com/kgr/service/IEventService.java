package ec.com.kgr.service;

import ec.com.kgr.entity.EventEntity;
import ec.com.kgr.vo.EventVo;
import ec.com.kgr.vo.common.FilterVo;
import ec.com.kruger.spring.service.IBaseService;
import org.springframework.data.domain.Page;

/**
 * IEventService.
 *
 * @author Kruger on 9/6/2024.
 * @version 1.0
 */
public interface IEventService extends IBaseService<EventEntity> {

    /**
     * Get list of license by filter and paginated.
     *
     * @param request FilterVo
     * @return Page EventVo
     */
    Page<EventVo> findByFilter(FilterVo request);

    /**
     * Save event.
     *
     * @param event EventVo
     */
    void save(EventVo event);

}
