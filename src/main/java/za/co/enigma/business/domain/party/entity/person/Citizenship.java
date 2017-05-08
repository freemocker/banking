package za.co.enigma.business.domain.party.entity.person;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import lombok.EqualsAndHashCode;
import za.co.enigma.domain.archetypes.MomentIntervalDomainArchetype;

@EqualsAndHashCode(callSuper=true)

@Entity
@Table(name="CITIZENSHIP",
uniqueConstraints= {
		@javax.persistence.UniqueConstraint(name="CITIZENSHIP_02U", columnNames={"ID", "UUID"})
}
		)
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Citizenship extends MomentIntervalDomainArchetype{

	private static final long serialVersionUID = 6438582460911209123L;

	private Country country;
	//	private Passport passport;

	@JoinColumn(name="COUNTRY_ID")
	@OneToOne(cascade=CascadeType.ALL)
	public Country getCountry() {
		return country;
	}
	public void setCountry(Country country) {
		this.country = country;
	}

	/*	@OneToOne
	public Passport getPassport() {
		return passport;
	}
	public void setPassport(Passport passport) {
		this.passport = passport;
	}*/

	@XmlTransient
	public static class Builder {
		private Citizenship citizenship;

		public Builder() {
			this.citizenship = new Citizenship();
		}

		public Builder withId(long id) {
			this.citizenship.setId(id);
			return this;
		}

		public Builder withUuid(String uuid) {
			this.citizenship.setUuid(uuid);
			return this;
		}

		public Builder withTenant(int tenant) {
			this.citizenship.setTenant(tenant);
			return this;
		}
		public Builder withCountry(Country country) {
			this.citizenship.setCountry(country);
			return this;
		}
		public Builder withEffectiveFrom(LocalDateTime effectiveFrom) {
			this.citizenship.setEffectiveFrom(effectiveFrom);
			return this;
		}

		public Builder withEffectiveTo(LocalDateTime effectiveTo) {
			this.citizenship.setEffectiveTo(effectiveTo);
			return this;
		}
		public Citizenship build() {
			return this.citizenship;
		}
	}

}
