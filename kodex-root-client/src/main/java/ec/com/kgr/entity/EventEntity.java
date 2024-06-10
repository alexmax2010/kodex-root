package ec.com.kgr.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import ec.com.kruger.spring.orm.entity.simple.SimpleAbstractBaseAuditableLockingIp;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

/**
 * EventEntity.
 *
 * @author Kruger on 9/6/2024.
 * @version 1.0
 */

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "KCKDXTEVENTS")
public class EventEntity extends SimpleAbstractBaseAuditableLockingIp<String> {

    private static final long serialVersionUID = 2L;

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "EVENT_CODE")
    private String eventId;

    @Column(name = "LICENSE_CODE")
    private String licenseId;

    @Column(name = "USER_ID")
    private String userId;

    @Column(name = "EVENT_TYPE")
    private String eventType;

    @Column(name = "TOTAL")
    private Integer total;


    /**
     * Get entity id.
     */
    @Override
    public String getId() {
        return this.eventId;
    }
}
