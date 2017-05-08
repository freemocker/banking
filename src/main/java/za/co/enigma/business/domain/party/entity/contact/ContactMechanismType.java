package za.co.enigma.business.domain.party.entity.contact;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.EqualsAndHashCode;
import za.co.enigma.domain.archetypes.DescriptionDomainArchetype;

@EqualsAndHashCode(callSuper=true)

@Entity
@Table(name="CONTACT_MECHANISM_TYPE",
uniqueConstraints= {
		@javax.persistence.UniqueConstraint(name="CONTACT_MECHANISM_TYPE_02U", columnNames={"ID", "UUID"})
}
		)
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ContactMechanismType extends DescriptionDomainArchetype{

	private static final long serialVersionUID = 8078066535184171407L;
	
}
