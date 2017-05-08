package za.co.enigma.business.domain.party.entity.relationship;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlTransient;

import za.co.enigma.business.domain.party.entity.role.PartyRole;
import za.co.enigma.domain.archetypes.MomentIntervalDomainArchetype;


@Entity
@Table(name = "PARTY_RELATIONSHIP",
uniqueConstraints={
		@UniqueConstraint(name = "PARTY_RELATIONSHIP_02U",
				columnNames = { "ID", "UUID" })
}
		)
public class PartyRelationship extends MomentIntervalDomainArchetype {

	private static final long serialVersionUID = 5826083764487206332L;
	private PartyRelationshipType partyRelationshipType;
	private PartyRole partyRole;

	@Column(name="PARTY_RELATIONSHIP_TYPE")
	@Enumerated(EnumType.STRING)
	public PartyRelationshipType getPartyRelationshipType() {
		return partyRelationshipType;
	}
	public void setPartyRelationshipType(PartyRelationshipType partyRelationshipType) {
		this.partyRelationshipType = partyRelationshipType;
	}

	@ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
	@JoinColumn(name = "PARTY_ROLE_ID", foreignKey = @ForeignKey(name = "PARTY_ROLE_FK01"))
	public PartyRole getPartyRole() {
		return partyRole;
	}
	public void setPartyRole(PartyRole partyRole) {
		this.partyRole = partyRole;
	}

	@XmlTransient
	public static class Builder {
		private PartyRelationship partyRelationship;

		public Builder(){
			this.partyRelationship = new PartyRelationship();
		}

		public Builder withId(long id) {
			this.partyRelationship.setId(id);
			return this;
		}

		public Builder withUuid(String uuid) {
			this.partyRelationship.setUuid(uuid);
			return this;
		}

		public Builder withTenant(int tenant) {
			this.partyRelationship.setTenant(tenant);
			return this;
		}

		public Builder withEffectiveFrom(LocalDateTime effectiveFrom) {
			this.partyRelationship.setEffectiveFrom(effectiveFrom);
			return this;
		}
		public Builder withEffectiveTo(LocalDateTime effectiveTo) {
			this.partyRelationship.setEffectiveTo(effectiveTo);
			return this;
		}

		public Builder withPartyRelationshipType(PartyRelationshipType partyRelationshipType) {
			this.partyRelationship.setPartyRelationshipType(partyRelationshipType);
			return this;
		}

		public Builder withPartyRole(PartyRole partyRole) {
			this.partyRelationship.setPartyRole(partyRole);
			return this;
		}

		public PartyRelationship build(){
			return this.partyRelationship;
		}
	}
}
