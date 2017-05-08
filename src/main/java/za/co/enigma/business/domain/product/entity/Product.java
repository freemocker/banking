package za.co.enigma.business.domain.product.entity;

import za.co.enigma.domain.archetypes.MomentIntervalDomainArchetype;
import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper=true)

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@Table(name="PRODUCT",
uniqueConstraints= {
        @javax.persistence.UniqueConstraint(
                name="PRODUCT_02U", 
                columnNames={"ID", "UUID"})
        }
)
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public abstract class Product extends MomentIntervalDomainArchetype {
	
	private static final long serialVersionUID = -5543659562035675296L;

	
}
