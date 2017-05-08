package za.co.enigma.business.domain.account.entity.role;

import za.co.enigma.domain.archetypes.DescriptionDomainArchetype;


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
@Table(name="ROLE_TYPE",
uniqueConstraints= {
        @javax.persistence.UniqueConstraint(
                name="ROLE_TYPE_02U", 
                columnNames={"ID", "UUID"})
        }
)
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)

public abstract class RoleType extends DescriptionDomainArchetype {
	
	private static final long serialVersionUID = 8500499057870425065L;


}
