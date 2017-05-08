package za.co.enigma.business.domain.agreement.entity;


import javax.persistence.Entity;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import za.co.enigma.domain.archetypes.ThingDomainArchetype;


@Entity
@Table(name="OTHER_AGREEMENT",
uniqueConstraints= {
		@javax.persistence.UniqueConstraint(name="OTHER_AGREEMENT_02U", columnNames={"ID", "UUID"})
}
		)
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class OtherAgreement extends ThingDomainArchetype {

	private static final long serialVersionUID = -3463250948370623359L;
	
	@XmlTransient
	public static class Builder {
		private OtherAgreement otherAgreement;
		
		public Builder(){
			this.otherAgreement = new OtherAgreement();
		}
		
	    public Builder withId(long id) {
	    	this.otherAgreement.setId(id);
	    	return this;
	    }
	    
	    public Builder withUuid(String uuid) {
	    	this.otherAgreement.setUuid(uuid);
	    	return this;
	    }
	    
	    public Builder withTenant(int tenant) {
	    	this.otherAgreement.setTenant(tenant);
	    	return this;
	    }
	    
	    public Builder withName(String name) {
	    	this.otherAgreement.setName(name);
	    	return this;
	    }
	}
}
