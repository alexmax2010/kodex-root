package ec.com.kgr.vo;

import java.util.Date;
import ec.com.kruger.validation.javax.constraint.NotBlankConstraint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * LicenseVo.
 *
 * @author Kruger on 5/6/2024.
 * @version 1.0
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LicenseVo {

    private String licenseId;
    @NotBlankConstraint
    private String appId;
    @NotBlankConstraint
    private String workTeamId;
    private String stateCatalogId;
    private String userId;
    private String license;
    private Date starDate;
    private Date endDate;
    private AppVo app;
    private WorkTeamVo workTeam;
    private CatalogVo catalog;

}
