package ec.com.kgr.repository;

import static com.querydsl.core.types.Projections.bean;
import static ec.com.kgr.entity.QEventEntity.eventEntity;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.JPQLQuery;
import ec.com.kgr.entity.EventEntity;
import ec.com.kgr.util.DateUtil;
import ec.com.kgr.vo.EventVo;
import ec.com.kgr.vo.common.FilterVo;
import ec.com.kruger.spring.orm.jpa.repository.JPAQueryDslBaseRepository;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Repository;

/**
 * EventRepository.
 *
 * @author Kruger on 9/6/2024.
 * @version 1.0
 */
@Lazy
@Repository
public class EventRepository extends JPAQueryDslBaseRepository<EventEntity> implements
    IEventRepository {

    /**
     * Constructor.
     */
    public EventRepository() {
        super(EventEntity.class);
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
    public EventVo findByUser(EventVo event) {
        JPQLQuery<EventVo> query = from(eventEntity).select(bean(EventVo.class,
            eventEntity.eventId,
            eventEntity.userId,
            eventEntity.licenseId,
            eventEntity.eventType,
            eventEntity.total));
        BooleanBuilder where = new BooleanBuilder();
        where.and(eventEntity.licenseId.eq(event.getLicenseId()));
        where.and(eventEntity.userId.eq(event.getUserId()));
        where.and(eventEntity.eventType.eq(event.getEventType()));
        where.and(eventEntity.status.isTrue());
        where.and(eventEntity.createdDate.between(DateUtil.startDate(), DateUtil.endDate()));
        query.where(where);
        return query.fetchFirst();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void updateValues(EventVo event) {
        BooleanBuilder where = new BooleanBuilder();
        where.and(eventEntity.eventId.eq(event.getEventId()));
        where.and(eventEntity.licenseId.eq(event.getLicenseId()));
        where.and(eventEntity.userId.eq(event.getUserId()));
        where.and(eventEntity.eventType.eq(event.getEventType().toUpperCase()));
        where.and(eventEntity.status.isTrue());
        Integer total = event.getTotal() + 1;
        updateSimpleAuth(eventEntity).where(where)
            .set(eventEntity.total, total).execute();
    }
}
