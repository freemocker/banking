package za.co.enigma.business.domain.party.entity.contact;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.EqualsAndHashCode;
import za.co.enigma.domain.archetypes.ThingDomainArchetype;

@EqualsAndHashCode(callSuper=true)

@Entity
@Table(name="ELECTRONIC_ADDRESS",
uniqueConstraints= {
		@javax.persistence.UniqueConstraint(name="ELECTRONIC_ADDRESS_02U", columnNames={"ID", "UUID"})
}
		)
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ElectronicAddress extends ThingDomainArchetype {

	private static final long serialVersionUID = -857187732895927319L;
	private String electronicAddress;
	
	public String getElectronicAddress() {
		return electronicAddress;
	}
	public void setElectronicAddress(String electronicAddress) {
		this.electronicAddress = electronicAddress;
	}
	
}
