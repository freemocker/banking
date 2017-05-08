package za.co.enigma.business.domain.party.entity.contact;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.EqualsAndHashCode;
import za.co.enigma.domain.archetypes.MomentIntervalDomainArchetype;

@EqualsAndHashCode(callSuper=true)

@Entity
@Table(name="PARTY_CONTACT_MECHANISM_PURPOSE",
uniqueConstraints= {
		@javax.persistence.UniqueConstraint(name="PARTY_CONTACT_MECHANISM_PURPOSE_02U", columnNames={"ID", "UUID"})
}
		)
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class PartyContactMechanismPurpose extends MomentIntervalDomainArchetype{
	
	private static final long serialVersionUID = 3916963286252851680L;

}
