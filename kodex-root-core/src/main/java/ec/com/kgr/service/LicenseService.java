package ec.com.kgr.service;

import ec.com.kgr.entity.LicenseEntity;
import ec.com.kgr.repository.ILicenseRepository;
import ec.com.kgr.util.ProjectUtil;
import ec.com.kgr.vo.LicenseVo;
import ec.com.kgr.vo.ValidateLicenseVo;
import ec.com.kgr.vo.common.FilterVo;
import ec.com.kruger.spring.service.jpa.BaseService;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * LicenseService.
 *
 * @author Kruger on 5/6/2024.
 * @version 1.0
 */
@Lazy
@Service
public class LicenseService extends BaseService<LicenseEntity, ILicenseRepository> implements
    ILicenseService {

    /**
     * Constructor with dependencies.
     *
     * @param repository The repository to inject
     */
    public LicenseService(ILicenseRepository repository) {
        super(repository);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = true)
    public Page<LicenseVo> findByFilter(FilterVo request) {
        return this.repository.findByFilter(request);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void save(LicenseVo license) {
        LicenseEntity licenseEntity = ProjectUtil.convert(license, LicenseEntity.class);
        licenseEntity.setStateCatalogId("PEN");
        this.repository.save(licenseEntity);
        license.setLicenseId(licenseEntity.getLicenseId());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = true)
    public boolean exist(LicenseVo request) {
        return this.repository.exist(request);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = true)
    public boolean validate(ValidateLicenseVo request) {
        return this.repository.validate(request);
    }
}
