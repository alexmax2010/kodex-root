package ec.com.kgr.controller;

import javax.validation.Valid;
import ec.com.kgr.service.IEventService;
import ec.com.kgr.vo.EventVo;
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
 * EventController.
 *
 * @author Kruger on 9/6/2024.
 * @version 1.0
 */
@Validated
@RestController
@RequestMapping("/api/v1/event")
@Lazy
@Slf4j
@Tag(name = "Event", description = "The Event API")
public class EventController extends BaseController {

    @Lazy
    @Autowired
    private transient IEventService service;

    /**
     * Save event.
     *
     * @param request EventVo
     * @return BaseResponseVo
     * @author components on 5/6/2024.
     */
    @PostMapping(path = "")
    @Operation(summary = "Save Event")
    public ResponseEntity<BaseResponseVo> save(@Valid @RequestBody EventVo request) {
        KeycloakUserVo user = SimpleSecurityKeycloakUtil.getCurrentUserLogin();
        request.setUserId(user.getUserId());
        this.service.save(request);
        return ResponseEntity.ok(BaseResponseVo.builder().data(request).build());
    }

}
