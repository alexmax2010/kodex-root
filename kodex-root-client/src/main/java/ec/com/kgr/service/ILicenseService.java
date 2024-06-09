package ec.com.kgr.service;

import ec.com.kgr.entity.LicenseEntity;
import ec.com.kgr.vo.LicenseVo;
import ec.com.kgr.vo.ValidateLicenseVo;
import ec.com.kgr.vo.common.FilterVo;
import ec.com.kruger.spring.service.IBaseService;
import ec.com.kruger.spring.vo.common.BaseResponseVo;
import org.springframework.data.domain.Page;

/**
 * ILicenseService.
 *
 * @author Kruger on 5/6/2024.
 * @version 1.0
 */
public interface ILicenseService extends IBaseService<LicenseEntity> {


    /**
     * Get list of license by filter and paginated.
     *
     * @param request FilterVo
     * @return Page LicenseVo
     */
    Page<LicenseVo> findByFilter(FilterVo request);

    /**
     * Save license.
     *
     * @param license License Vo
     */
    void save(LicenseVo license);

    /**
     * Exist license.
     *
     * @param request LicenseVo
     * @return boolean
     */
    boolean exist(LicenseVo request);

    /**
     * Validate.
     *
     * @param request ValidateLicenseVo
     * @return BaseResponseVo
     */
    BaseResponseVo validate(ValidateLicenseVo request);

}
