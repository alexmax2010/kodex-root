package ec.com.kgr.vo;

import ec.com.kruger.validation.javax.constraint.NotBlankConstraint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ValidateLicenseVo.
 *
 * @author Kruger on 6/6/2024.
 * @version 1.0
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ValidateLicenseVo {

    @NotBlankConstraint
    private String appId;
    @NotBlankConstraint
    private String workTeamId;
    @NotBlankConstraint
    private String userId;
    @NotBlankConstraint
    private String license;
}
