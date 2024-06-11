package ec.com.kgr.vo;

import ec.com.kgr.vo.common.BaseAuditableVo;
import ec.com.kruger.validation.javax.constraint.NotBlankConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * EventVo.
 *
 * @author Kruger on 9/6/2024.
 * @version 1.0
 */
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class EventVo extends BaseAuditableVo {
    private String eventId;
    @NotBlankConstraint
    private String licenseId;
    private String userId;
    @NotBlankConstraint
    private String eventType;
    private Integer total;
}
