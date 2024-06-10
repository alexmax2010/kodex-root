package ec.com.kgr.repository;

import ec.com.kgr.entity.EventEntity;
import ec.com.kgr.vo.EventVo;
import ec.com.kgr.vo.common.FilterVo;
import ec.com.kruger.spring.orm.repository.IQueryDslBaseRepository;
import org.springframework.data.domain.Page;

/**
 * IEventRepository.
 *
 * @author Kruger on 9/6/2024.
 * @version 1.0
 */
public interface IEventRepository extends IQueryDslBaseRepository<EventEntity> {

    /**
     * Get list of license by filter and paginated.
     *
     * @param request FilterVo
     * @return Page EventVo
     */
    Page<EventVo> findByFilter(FilterVo request);

    /**
     * Find by user.
     *
     * @param event EventVo
     * @return EventVo
     */
    EventVo findByUser(EventVo event);


    /**
     * Update values.
     *
     * @param event EventVo
     */
    void updateValues(EventVo event);

}
