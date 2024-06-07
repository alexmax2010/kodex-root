package ec.com.kgr.repository;

import ec.com.kgr.entity.LicenseEntity;
import ec.com.kgr.vo.LicenseVo;
import ec.com.kgr.vo.ValidateLicenseVo;
import ec.com.kgr.vo.common.FilterVo;
import ec.com.kruger.spring.orm.repository.IQueryDslBaseRepository;
import org.springframework.data.domain.Page;

/**
 * ILicenseRepository.
 *
 * @author Kruger on 5/6/2024.
 * @version 1.0
 */
public interface ILicenseRepository extends IQueryDslBaseRepository<LicenseEntity> {


    /**
     * Get list of license by filter and paginated.
     *
     * @param request FilterVo
     * @return Page FilterVo
     */
    Page<LicenseVo> findByFilter(FilterVo request);

    /**
     * Exist license.
     *
     * @param request LicenseVo
     * @return Boolean
     */
    boolean exist(LicenseVo request);

    /**
     * Validate.
     *
     * @param request ValidateLicenseVo
     * @return boolean
     */
    boolean validate(ValidateLicenseVo request);
}
