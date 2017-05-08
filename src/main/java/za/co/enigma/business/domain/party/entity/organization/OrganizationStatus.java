package za.co.enigma.business.domain.party.entity.organization;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import lombok.EqualsAndHashCode;
import za.co.enigma.domain.archetypes.DescriptionDomainArchetype;

@EqualsAndHashCode(callSuper=true)

@Entity
@Table(name="ORGANIZATION_STATUS",
uniqueConstraints= {
		@javax.persistence.UniqueConstraint(name="ORGANIZATION_STATUS_02U", columnNames={"ID", "UUID"})
}
		)
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class OrganizationStatus  extends DescriptionDomainArchetype {
	
	private static final long serialVersionUID = -8973529794541670042L;

	
	@XmlTransient
	public static class Builder {
		private OrganizationStatus organizationStatus;
		
		public Builder(){
			this.organizationStatus = new OrganizationStatus();
		}
	 		
		public Builder withId(long id) {
			this.organizationStatus.setId(id);
			return this;
		}

		public Builder withUuid(String uuid) {
			this.organizationStatus.setUuid(uuid);
			return this;
		}
		
		public Builder withTenant(int tenant){
			this.organizationStatus.setTenant(tenant);
			return this;
		}
		
		public Builder withName(String name) {
			this.organizationStatus.setName(name);
			return this;
		}
		public Builder withCode(String code) {
			this.organizationStatus.setCode(code);
			return this;
		}
		
		public Builder withNote(String note) {
			this.organizationStatus.setNote(note);
			return this;
		}
		public Builder withDescription(String description){
			this.organizationStatus.setDescription(description);
			return this;
		}
		
		public OrganizationStatus build(){
			return this.organizationStatus;
		}
	}

}
