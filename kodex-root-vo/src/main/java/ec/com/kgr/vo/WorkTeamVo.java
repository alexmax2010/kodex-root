package ec.com.kgr.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * WorkTeamVo.
 *
 * @author Kruger on 6/6/2024.
 * @version 1.0
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WorkTeamVo {

    private String workTeamId;
    private String name;
    private String description;
}