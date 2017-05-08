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
@Table(name="ORGANIZATION_TYPE",
uniqueConstraints= {
		@javax.persistence.UniqueConstraint(name="ORGANIZATION_TYPE_02U", columnNames={"ID", "UUID"})
}
		)
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class OrganizationType   extends DescriptionDomainArchetype{
	
	private static final long serialVersionUID = 6391261453094995955L;

	
	@XmlTransient
	public static class Builder {
		private OrganizationType organizationType;
		
		public Builder(){
			this.organizationType = new OrganizationType();
		}
	 		
		public Builder withId(long id) {
			this.organizationType.setId(id);
			return this;
		}

		public Builder withUuid(String uuid) {
			this.organizationType.setUuid(uuid);
			return this;
		}
		
		public Builder withTenant(int tenant){
			this.organizationType.setTenant(tenant);
			return this;
		}
		
		public Builder withName(String name) {
			this.organizationType.setName(name);
			return this;
		}
		public Builder withCode(String code) {
			this.organizationType.setCode(code);
			return this;
		}
		
		public Builder withNote(String note) {
			this.organizationType.setNote(note);
			return this;
		}
		public Builder withDescription(String description){
			this.organizationType.setDescription(description);
			return this;
		}
		
		public OrganizationType build(){
			return this.organizationType;
		}
	}

}
