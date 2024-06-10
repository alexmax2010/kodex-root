package ec.com.kgr.service;

import java.util.Date;
import ec.com.kgr.entity.EventEntity;
import ec.com.kgr.repository.IEventRepository;
import ec.com.kgr.util.ProjectUtil;
import ec.com.kgr.vo.EventVo;
import ec.com.kgr.vo.common.FilterVo;
import ec.com.kruger.spring.service.jpa.BaseService;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

/**
 * EventService.
 *
 * @author Kruger on 9/6/2024.
 * @version 1.0
 */
@Lazy
@Service
public class EventService extends BaseService<EventEntity, IEventRepository> implements
    IEventService {

    /**
     * Constructor with dependencies.
     *
     * @param repository The repository to inject
     */
    public EventService(IEventRepository repository) {
        super(repository);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Page<EventVo> findByFilter(FilterVo request) {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void save(EventVo event) {
        EventVo response = this.repository.findByUser(event);
        if (null == response) {
            EventEntity eventEntity = ProjectUtil.convert(event, EventEntity.class);
            eventEntity.setTotal(1);
            eventEntity.setCreatedByUser(eventEntity.getUserId());
            eventEntity.setCreatedDate(new Date());
            eventEntity.setStatus(true);
            eventEntity.setCreatedFromIp("0.0.0.0");
            this.repository.save(eventEntity);
        } else {
            this.repository.updateValues(response);
        }
    }
}
