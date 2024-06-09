package ec.com.kgr.repository;

import static com.querydsl.core.types.Projections.bean;
import static ec.com.kgr.entity.QLicenseEntity.licenseEntity;
import java.util.List;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.JPQLQuery;
import ec.com.kgr.entity.LicenseEntity;
import ec.com.kgr.entity.QAppEntity;
import ec.com.kgr.entity.QCatalogEntity;
import ec.com.kgr.entity.QWorkTeamEntity;
import ec.com.kgr.vo.AppVo;
import ec.com.kgr.vo.CatalogVo;
import ec.com.kgr.vo.LicenseVo;
import ec.com.kgr.vo.ValidateLicenseVo;
import ec.com.kgr.vo.WorkTeamVo;
import ec.com.kgr.vo.common.FilterVo;
import ec.com.kruger.spring.orm.jpa.repository.JPAQueryDslBaseRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;


/**
 * LicenseRepository.
 *
 * @author Kruger on 5/6/2024.
 * @version 1.0
 */
@Lazy
@Repository
public class LicenseRepository extends JPAQueryDslBaseRepository<LicenseEntity> implements
    ILicenseRepository {

    /**
     * Constructor.
     */
    public LicenseRepository() {
        super(LicenseEntity.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Page<LicenseVo> findByFilter(FilterVo request) {
        QAppEntity qAppEntity = QAppEntity.appEntity;
        QWorkTeamEntity qWorkTeamEntity = QWorkTeamEntity.workTeamEntity;
        QCatalogEntity qCatalogEntity = QCatalogEntity.catalogEntity;
        JPQLQuery<LicenseVo> query = from(licenseEntity)
            .select(bean(LicenseVo.class,
                licenseEntity.licenseId,
                licenseEntity.userId,
                licenseEntity.createdDate,
                licenseEntity.status,
                bean(AppVo.class,
                    qAppEntity.appId,
                    qAppEntity.name).as("app"),
                bean(WorkTeamVo.class,
                    qWorkTeamEntity.workTeamId,
                    qWorkTeamEntity.name).as("workTeam"),
                bean(CatalogVo.class,
                    qCatalogEntity.catalogId,
                    qCatalogEntity.value).as("catalog")));
        query.innerJoin(licenseEntity.appEntity, qAppEntity);
        query.innerJoin(licenseEntity.workTeamEntity, qWorkTeamEntity);
        query.innerJoin(licenseEntity.catalogEntity, qCatalogEntity);
        BooleanBuilder where = new BooleanBuilder();
        where.and(licenseEntity.status.isTrue());
        query.where(where);
        Pageable pageable = PageRequest.of(request.getPage(), request.getSize());
        return this.findPaged(query, pageable, request.getFilters());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean exist(LicenseVo request) {
        BooleanBuilder where = new BooleanBuilder();
        where.and(licenseEntity.userId.eq(request.getUserId()));
        where.and(licenseEntity.appId.eq(request.getAppId()));
        where.and(licenseEntity.workTeamId.eq(request.getWorkTeamId()));
        where.and(licenseEntity.license.eq(request.getLicense()));
        where.and(licenseEntity.status.isTrue());
        JPQLQuery<String> query = from(licenseEntity).select(licenseEntity.licenseId).where(where);
        String response = query.fetchFirst();
        return StringUtils.isNotBlank(response);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean validate(ValidateLicenseVo request) {
        BooleanBuilder where = new BooleanBuilder();
        where.and(licenseEntity.userId.eq(request.getUserId()));
        where.and(licenseEntity.appId.eq(request.getAppId()));
        where.and(licenseEntity.workTeamId.eq(request.getWorkTeamId()));
        where.and(licenseEntity.stateCatalogId.eq("PEN"));
        where.and(licenseEntity.license.eq(request.getLicense()));
        where.and(licenseEntity.status.isTrue());
        JPQLQuery<String> query = from(licenseEntity).select(licenseEntity.licenseId).where(where);
        String response = query.fetchFirst();
        return StringUtils.isNotBlank(response);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<LicenseVo> findByUser(ValidateLicenseVo request) {
        BooleanBuilder where = new BooleanBuilder();
        where.and(licenseEntity.userId.eq(request.getUserId()));
        where.and(licenseEntity.appId.eq(request.getAppId()));
        if (StringUtils.isNotBlank(request.getWorkTeamId())) {
            where.and(licenseEntity.workTeamId.eq(request.getWorkTeamId()));
        }
        if (StringUtils.isNotBlank(request.getStateCatalogId())) {
            where.and(licenseEntity.stateCatalogId.eq(request.getStateCatalogId()));
        }
        where.and(licenseEntity.status.isTrue());
        JPQLQuery<LicenseVo> query = from(licenseEntity).select(bean(LicenseVo.class,
            licenseEntity.licenseId,
            licenseEntity.workTeamId,
            licenseEntity.appId,
            licenseEntity.userId,
            licenseEntity.license,
            licenseEntity.stateCatalogId)).where(where);
        return query.fetch();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void updateValues(LicenseVo license) {
        BooleanBuilder where = new BooleanBuilder();
        where.and(licenseEntity.licenseId.eq(license.getLicenseId()));
        where.and(licenseEntity.workTeamId.eq(license.getWorkTeamId()));
        where.and(licenseEntity.appId.eq(license.getAppId()));
        where.and(licenseEntity.userId.eq(license.getUserId()));
        updateSimpleAuth(licenseEntity).where(where)
            .set(licenseEntity.stateCatalogId, license.getStateCatalogId())
            .set(licenseEntity.license, license.getLicense()).execute();
    }

}
