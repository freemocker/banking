package za.co.enigma.business.domain.party.entity.contact;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.EqualsAndHashCode;
import za.co.enigma.domain.archetypes.PlaceDomainArchetype;

@EqualsAndHashCode(callSuper=true)

@Entity
@Table(name="POSTAL_ADDRESS",
uniqueConstraints= {
		@javax.persistence.UniqueConstraint(name="POSTAL_ADDRESS_02U", columnNames={"ID", "UUID"})
}
		)
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class PostalAddress extends PlaceDomainArchetype {

	private static final long serialVersionUID = 3162818203051719779L;
	private String address1;
	private String address2;
	private String directions;
	
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public String getDirections() {
		return directions;
	}
	public void setDirections(String directions) {
		this.directions = directions;
	}

}
