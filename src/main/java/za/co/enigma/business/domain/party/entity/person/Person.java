package za.co.enigma.business.domain.party.entity.person;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
//import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.EqualsAndHashCode;
import za.co.enigma.business.domain.account.entity.role.AccountRole;
import za.co.enigma.business.domain.account.entity.role.AccountTransactionRole;
import za.co.enigma.business.domain.party.entity.IdentificationType;
import za.co.enigma.business.domain.party.entity.Party;
import za.co.enigma.business.domain.party.entity.role.PartyRole;
import za.co.enigma.common.util.LocalDateAdapter;

@EqualsAndHashCode(callSuper=true)

@NamedQueries(
		{
			@NamedQuery(name=Person.FIND_BY_ID_NUMBER,query="SELECT p FROM Person p WHERE p.identificationNumber = :idNumber"),
			@NamedQuery(name=Person.FIND_ALL_WITH_IDS,query="SELECT p FROM Person p WHERE p.id IN :ids "),
			@NamedQuery(name=Person.findAll, query="SELECT p FROM Person p")
		})

@Entity
@Table(name="PERSON")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Person extends Party implements Serializable {

	private static final long serialVersionUID = -872301141247224928L;

	public static final String FIND_BY_ID_NUMBER = "Person.findByIdNumber";
	public static final String FIND_ALL_WITH_IDS = "Person.findAllWithIds";

	private static final String PREFIX = "za.co.enigma.business.domain.party.entity.person.";
    public static final String findAll = PREFIX + "all";
    
	private Gender gender;
	private Title title;
	private LocalDate bornOn;
	private LocalDate diedOn;
	private String suffix;
	private String prefix;
	private String givenName;
	private String familyName;
	private String preferredName;
	private String nickname;
	private IdentificationType identificationType;
	private String identificationNumber;
	private int height;
	private int weight;
	private String mothersMaidenName;
	private MaritalStatusType maritalStatus;
	private List<Passport> passports;
	
	public Person() {
		passports = new ArrayList<>();
	}
	
	@Enumerated(EnumType.STRING)
	@Column(name="GENDER")
	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	@Enumerated(EnumType.STRING)
	@Column(name="TITLE")
	public Title getTitle() {
		return this.title;
	}

	public void setTitle(Title title) {
		this.title = title;
	}

	@Column(name="BORN_ON")
	@XmlJavaTypeAdapter(LocalDateAdapter.class)
	public LocalDate getBornOn() {
		return bornOn;
	}

	public void setBornOn(LocalDate bornOn) {
		this.bornOn = bornOn;
	}

	@Column(name="DIED_ON")
	@XmlJavaTypeAdapter(LocalDateAdapter.class)
	public LocalDate getDiedOn() {
		if (diedOn == null) {
			diedOn = LocalDate.of(9999, Month.DECEMBER, 31);
		}
		return diedOn;
	}

	public void setDiedOn(LocalDate diedOn) {
		this.diedOn = diedOn;
	}
	@Column(name="SUFFIX")
	public String getSuffix() {
		return suffix;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	@Column(name="PREFIX")
	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
	
	@Column(name="GIVEN_NAME")
	public String getGivenName() {
		return givenName;
	}

	public void setGivenName(String givenName) {
		this.givenName = givenName;
	}

	@Column(name="FAMILY_NAME")
	public String getFamilyName() {
		return familyName;
	}

	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	@Column(name="PREFERRED_NAME")
	public String getPreferredName() {
		return preferredName;
	}

	public void setPreferredName(String preferredName) {
		this.preferredName = preferredName;
	}

	
	@Enumerated(EnumType.STRING)
	@Column(name="IDENTIFICATION_TYPE")
	public IdentificationType getIdentificationType() {
		return identificationType;
	}

	public void setIdentificationType(IdentificationType identificationType) {
		this.identificationType = identificationType;
	}

	@Column(name="IDENTIFICATION")
	public String getIdentificationNumber() {
		return identificationNumber;
	}

	public void setIdentificationNumber(String identificationNumber) {
		this.identificationNumber = identificationNumber;
	}
	
	@Column(name="NICKNAME")
	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	@Column(name="HEIGHT")
	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	@Column(name="WEIGHT")
	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	@Column(name="MOTHERS_MAIDEN_NAME")
	public String getMothersMaidenName() {
		return mothersMaidenName;
	}

	public void setMothersMaidenName(String mothersMaidenName) {
		this.mothersMaidenName = mothersMaidenName;
	}

	@Column(name="MARITAL_STATUS_TYPE")
	@Enumerated(EnumType.STRING)
	public MaritalStatusType getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(MaritalStatusType maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	@JoinTable(name= "PERSON_PASSPORT",
			joinColumns=@JoinColumn(name ="PERSON_ID"),
			inverseJoinColumns = @JoinColumn(name = "PASSPORT_ID"))
	@OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
	public List<Passport> getPassports() {
		return passports;
	}

	public void setPassports(List<Passport> passports) {
		this.passports = passports;
	}


	/**
	 * Builder
	 * @author luckson
	 *
	 */
	//@Transient
	@XmlTransient
	public static class Builder {
		private Person person;
		
		public Builder() {
			this.person =  new Person();
		}
		
		public Builder withId(long id) {
			this.person.setId(id);
			return this;
		}
		public Builder withTenantId(int tenantId) {
			this.person.setTenant(tenantId);
			return this;
		}
		
		public Builder withUUID(String uuid) {
			this.person.setUuid(uuid);
			return this;
		}
		
		public Builder withCellphone(String cellphone) {
			this.person.setCellphone(cellphone);
			return this;
		}
		public Builder withTelephone(String telephone) {
			this.person.setTelephone(telephone);
			return this;
		}
			
		public Builder withIdentificationType(IdentificationType type) {
			this.person.setIdentificationType(type);
			return this;
		}
		
		public Builder withGivenName(String name) {
			this.person.setGivenName(name.toUpperCase());
			return this;
		}
		
		public Builder withEmailAddress(String emailAddress) {
			this.person.setEmailAddress(emailAddress.toUpperCase());
			return this;
		}
		
		public Builder withAddress(String address) {
			this.person.setAddress(address.toUpperCase());
			return this;
		}
		
		public Builder withGender(Gender gender) {
			this.person.setGender(gender);
			return this;
		}
		
		public Builder withTitle(Title title) {
			this.person.setTitle(title);
			return this;
		}
		
		public Builder withBornOnDate(LocalDate bornOn) {
			this.person.setBornOn(bornOn);
			return this;
		}
		
		public Builder withDiedOnDate(LocalDate diedOn) {
			if (diedOn == null) {
				this.person.setDiedOn(LocalDate.of(9999, Month.DECEMBER, 31));
			}
			this.person.setDiedOn(diedOn);
			return this;
		}
		
		
		public Builder withSuffix(String suffix) {
			this.person.setSuffix(suffix.toUpperCase());
			return this;
		}
		
		public Builder withPrefix(String prefix) {
			this.person.setPrefix(prefix);
			return this;
		}
		public Builder withFamilyName(String familyName) {
			this.person.setFamilyName(familyName.toUpperCase());
			return this;
		}
		
		
		public Builder withPreferredName(String preferredName) {
			this.person.setPreferredName(preferredName.toUpperCase());
			return this;
		}
		
		
		public Builder withNickname(String nickname){
			this.person.setNickname(nickname.toUpperCase());
			return this;
		}
		
		public Builder withIdentificationNumber(String idNumber) {
			this.person.setIdentificationNumber(idNumber.toUpperCase());
			return this;
		}
		
		public Builder withHeight(int height) {
			this.person.setHeight(height);
			return this;
		}
		
		public Builder withWeight(int weight) {
			this.person.setWeight(weight);
			return this;
		}
		
		public Builder withMothersMaidenName(String mothersMaidenName) {
			this.person.setMothersMaidenName(mothersMaidenName);
			return this;
		}
		
		
		public Builder withMaritalStatusType(MaritalStatusType maritalStatus) {
			this.person.setMaritalStatus(maritalStatus);
			return this;
		}
		
		public Builder withPassport(Passport passport){
			this.person.getPassports().add(passport);
			return this;
		}
		
		public Builder withPartyRole(PartyRole partyRole) {
			this.person.getPartyRoles().add(partyRole);
			return this;
		}
	    
	    public Builder withAccountTransactionRole(AccountTransactionRole accountTransactionRole) {
	    	this.person.getAccountTransactionRoles().add(accountTransactionRole);
	    	return this;
	    }
	    
	    public Builder withAccountRole(AccountRole accountRole) {
	    	this.person.getAccountRoles().add(accountRole);
	    	return this;
	    }
	    
		public Person build() {
			// check conditions
			if (person.getGivenName().isEmpty()) {
				throw new IllegalStateException("Person's name cannot be empty");
			}
			return this.person;
		}
	}
}