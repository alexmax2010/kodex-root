package ec.com.kgr.entity;


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import ec.com.kruger.spring.orm.entity.simple.SimpleAbstractBaseAuditableLockingIp;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

/**
 * LicenseEntity.
 *
 * @author Kruger on 5/6/2024.
 * @version 1.0
 */

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "KCKDXTLICENSE")
public class LicenseEntity extends SimpleAbstractBaseAuditableLockingIp<String> {

    private static final long serialVersionUID = 2L;

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "LICENSE_CODE")
    private String licenseId;

    @Column(name = "APP_CODE")
    private String appId;

    @Column(name = "WORK_TEAM_CODE")
    private String workTeamId;

    @Column(name = "STATE_CATALOG_CODE")
    private String stateCatalogId;

    @Column(name = "USER_ID")
    private String userId;

    @Column(name = "LICENSE")
    private String license;

    @Column(name = "DEVICE")
    private String device;

    @Column(name = "START_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date starDate;

    @Column(name = "END_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate;

    @JoinColumn(name = "APP_CODE", insertable = false, updatable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private AppEntity appEntity;

    @JoinColumn(name = "WORK_TEAM_CODE", insertable = false, updatable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private WorkTeamEntity workTeamEntity;

    @JoinColumn(name = "STATE_CATALOG_CODE", insertable = false, updatable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private CatalogEntity catalogEntity;

    /**
     * Get entity id.
     */
    @Override
    public String getId() {
        return this.licenseId;
    }
}
