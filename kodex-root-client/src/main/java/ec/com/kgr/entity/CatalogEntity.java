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
 * CatalogEntity.
 *
 * @author Kruger on 5/6/2024.
 * @version 1.0
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "KCKDXTCATALOG")
public class CatalogEntity extends SimpleAbstractBaseAuditableLockingIp<String> {

    private static final long serialVersionUID = 2L;

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "CATALOG_CODE")
    private String catalogId;

    @Column(name = "GROUP")
    private String group;

    @Column(name = "VALUE")
    private String value;

    @Column(name = "DESCRIPTION")
    private String description;

    /**
     * Get entity id.
     */
    @Override
    public String getId() {
        return this.catalogId;
    }
}
