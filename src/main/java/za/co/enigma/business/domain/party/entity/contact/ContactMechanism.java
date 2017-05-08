package za.co.enigma.business.domain.party.entity.contact;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.EqualsAndHashCode;
import za.co.enigma.domain.archetypes.ThingDomainArchetype;


@EqualsAndHashCode(callSuper=true)

@Entity
@Table(name="CONTACT_MECHANISM",
uniqueConstraints= {
		@javax.persistence.UniqueConstraint(name="CONTACT_MECHANISM_02U", columnNames={"ID", "UUID"})
}
		)
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@NamedQuery(name = ContactMechanism.findAll, query = "SELECT cm FROM ContactMechanism cm")
public class ContactMechanism extends ThingDomainArchetype {

	private static final long serialVersionUID = -7437519004929569344L;
	private static final String PREFIX = "za.co.enigma.domain.universal.model.party.contact.";
    public static final String findAll = PREFIX + "all";
    
	private long contactMechanismId;
	private PostalAddress postalAddress;
	
	public long getContactMechanismId() {
		return contactMechanismId;
	}
	public void setContactMechanismId(long contactMechanismId) {
		this.contactMechanismId = contactMechanismId;
	}
	public PostalAddress getPostalAddress() {
		return postalAddress;
	}
	public void setPostalAddress(PostalAddress postalAddress) {
		this.postalAddress = postalAddress;
	}
	
}
