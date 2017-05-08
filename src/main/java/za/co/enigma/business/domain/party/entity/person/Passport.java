package za.co.enigma.business.domain.party.entity.person;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.ForeignKey;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import lombok.EqualsAndHashCode;
import za.co.enigma.common.util.LocalDateAdapter;
import za.co.enigma.domain.archetypes.ThingDomainArchetype;

@EqualsAndHashCode(callSuper=true)

@Entity
@Table(name="PASSPORT",
uniqueConstraints= {
		@javax.persistence.UniqueConstraint(name="PASSPORT_02U", columnNames={"ID", "UUID"})
}
		)
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Passport extends ThingDomainArchetype {

	private static final long serialVersionUID = 5487985870030510612L;

	private long passportId;
	private String passportNumber;
	private LocalDate issueDate;
	private LocalDate expirationDate;
	private Citizenship citizenship;
	private Person person;

	@Column(name="PASSPORT_ID")
	public long getPassportId() {
		return passportId;
	}
	public void setPassportId(long passportId) {
		this.passportId = passportId;
	}

	@Column(name="PASSPORT_NUMBER")
	public String getPassportNumber() {
		return passportNumber;
	}
	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}

	@Column(name="ISSUE_DATE")
	@XmlJavaTypeAdapter(LocalDateAdapter.class)
	public LocalDate getIssueDate() {
		return issueDate;
	}
	public void setIssueDate(LocalDate issueDate) {
		this.issueDate = issueDate;
	}

	@Column(name="EXPIRATION_DATE")
	@XmlJavaTypeAdapter(LocalDateAdapter.class)
	public LocalDate getExpirationDate() {
		return expirationDate;
	}
	public void setExpirationDate(LocalDate expirationDate) {
		this.expirationDate = expirationDate;
	}

	@JoinColumn(name="CITIZENSHIP_ID")
	@OneToOne(cascade=CascadeType.ALL)
	public Citizenship getCitizenship() {
		return citizenship;
	}
	public void setCitizenship(Citizenship citizenship) {
		this.citizenship = citizenship;
	}

	@ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
	@JoinColumn(name = "PERSON_ID", foreignKey = @ForeignKey(name = "PERSON_FK01"))
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}

	@XmlTransient
	public static class Builder {
		private Passport passport;

		public Builder() {
			this.passport = new Passport();
		}

		public Builder witId(long id) {
			this.passport.setId(id);
			return this;
		}


		public Builder withUuid(String uuid) {
			this.passport.setUuid(uuid);
			return this;
		}


		public Builder withTenant(int tenant) {
			this.passport.setTenant(tenant);
			return this;
		}

		public Builder withName(String name) {
			this.passport.setName(name);
			return this;
		}

		public Builder withPassportId(long passportId) {
			this.passport.setPassportId(passportId);
			return this;
		}

		public Builder withPassportNumber(String passportNumber) {
			this.passport.setPassportNumber(passportNumber);
			return this;
		}

		public Builder withIssueDate(LocalDate issueDate) {
			this.passport.setIssueDate(issueDate);
			return this;
		}

		public Builder withExpirationDate(LocalDate expirationDate){
			this.passport.setExpirationDate(expirationDate);
			return this;

		}

		public Builder withCitizenship(Citizenship citizenship) {
			this.passport.setCitizenship(citizenship);
			return this;
		}

		/*public Builder withPerson(Person person) {
			this.passport.setPerson(person);
			return this;
		}*/

		public Passport build(){
			return this.passport;
		}
	}
}
