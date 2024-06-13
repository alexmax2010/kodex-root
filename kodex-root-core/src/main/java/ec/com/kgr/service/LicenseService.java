package ec.com.kgr.service;

import java.util.List;
import java.util.Locale;
import java.util.UUID;
import ec.com.kgr.common.KodexRootConstants;
import ec.com.kgr.entity.LicenseEntity;
import ec.com.kgr.repository.ILicenseRepository;
import ec.com.kgr.util.ProjectUtil;
import ec.com.kgr.vo.LicenseVo;
import ec.com.kgr.vo.ValidateLicenseVo;
import ec.com.kgr.vo.common.FilterVo;
import ec.com.kruger.spring.service.jpa.BaseService;
import ec.com.kruger.spring.vo.common.BaseResponseVo;
import org.apache.commons.collections4.CollectionUtils;
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
        licenseEntity.setStateCatalogId(KodexRootConstants.PEN);
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
    public BaseResponseVo validate(ValidateLicenseVo request) {
        String device = request.getDevice().toUpperCase(Locale.ROOT);
        request.setDevice(null);
        List<LicenseVo> licenses = this.repository.findByUser(request);
        if (CollectionUtils.isEmpty(licenses)) {
            return BaseResponseVo.builder().code(1).message("No tiene una licencia asignada.")
                .build();
        }
        LicenseVo license = this.validateDevice(licenses, device);
        if (null != license) {
            return BaseResponseVo.builder().data(license).build();
        }
        license = licenses.stream()
            .filter(lic -> KodexRootConstants.PEN.equals(lic.getStateCatalogId())).findFirst()
            .orElse(null);
        if (null == license) {
            return BaseResponseVo.builder().code(1).message("No tiene una licencia asignada.")
                .build();
        }
        license.setStateCatalogId(KodexRootConstants.ACT);
        license.setLicense(UUID.randomUUID().toString());
        license.setDevice(device);
        this.repository.updateValues(license);
        return BaseResponseVo.builder().data(license).build();
    }


    private LicenseVo validateDevice(List<LicenseVo> licenses, String device) {
        LicenseVo license = licenses.stream()
            .filter(lic -> device.equals(lic.getDevice())).findFirst().orElse(null);
        if (null != license) {
            return license;
        }
        license = licenses.stream()
            .filter(lic -> device.contains(lic.getDevice())).findFirst().orElse(null);
        if (null == license) {
            license = licenses.stream()
                .filter(lic -> null != lic.getDevice() && lic.getDevice().contains(device))
                .findFirst().orElse(null);
        }
        return license;
    }
}
