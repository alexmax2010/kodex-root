package ec.com.kgr.controller;

import javax.validation.Valid;
import ec.com.kgr.service.ILicenseService;
import ec.com.kgr.vo.LicenseVo;
import ec.com.kgr.vo.ValidateLicenseVo;
import ec.com.kgr.vo.common.FilterVo;
import ec.com.kruger.security.sso.springboot2.util.simple.KeycloakUserVo;
import ec.com.kruger.security.sso.springboot2.util.simple.SimpleSecurityKeycloakUtil;
import ec.com.kruger.spring.vo.common.BaseResponseVo;
import ec.com.kruger.spring.ws.controller.BaseController;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * LicenseController.
 *
 * @author Kruger on 5/6/2024.
 * @version 1.0
 */

@Validated
@RestController
@RequestMapping("/api/v1/license")
@Lazy
@Slf4j
@Tag(name = "License", description = "The License API")
public class LicenseController extends BaseController {

    @Lazy
    @Autowired
    private transient ILicenseService service;

    /**
     * Get list of license by filter and paginated.
     *
     * @param request FilterVo
     * @return BaseResponseVo
     * @author components on 5/6/2024.
     */
    @PostMapping(path = "/findByFilter")
    @Operation(summary = "Get list of license by filter and paginated")
    public ResponseEntity<BaseResponseVo> findByFilter(
        @RequestBody FilterVo request) {
        return ResponseEntity.ok(BaseResponseVo.builder()
            .data(this.service.findByFilter(request)).build());
    }

    /**
     * Save License.
     *
     * @param request LicenseVo
     * @return BaseResponseVo
     * @author components on 5/6/2024.
     */
    @PostMapping(path = "")
    @Operation(summary = "Save License")
    public ResponseEntity<BaseResponseVo> save(@Valid @RequestBody LicenseVo request) {
        if (this.service.exist(request)) {
            return ResponseEntity.ok()
                .body(BaseResponseVo.builder().code(1).build());
        }
        this.service.save(request);
        return ResponseEntity.ok(BaseResponseVo.builder().data(request).build());
    }

    /**
     * Validate license.
     *
     * @param request ValidateLicenseVo
     * @return BaseResponseVo
     * @author components on 5/6/2024.
     */
    @PostMapping(path = "/validate")
    @Operation(summary = "Validate License")
    public ResponseEntity<BaseResponseVo> validate(@Valid @RequestBody ValidateLicenseVo request) {
        KeycloakUserVo user = SimpleSecurityKeycloakUtil.getCurrentUserLogin();
        request.setUserId(user.getUserId());
        return ResponseEntity.ok(this.service.validate(request));
    }


}
