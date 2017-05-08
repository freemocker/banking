package za.co.enigma.business.domain.party.entity.person;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import lombok.EqualsAndHashCode;
import za.co.enigma.domain.archetypes.PlaceDomainArchetype;

@EqualsAndHashCode(callSuper=true)

@Entity
@Table(name="COUNTRY",
uniqueConstraints= {
		@javax.persistence.UniqueConstraint(name="COUNTRY_02U", columnNames={"ID", "UUID"})
}
		)
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Country extends PlaceDomainArchetype {
	
	private static final long serialVersionUID = -2422799908827606633L;
	
	private String iso;
	private String iso3;
	private String niceName;
	private String numcode;
	private String phonecode;
	
	@Column(name="ISO")
	public String getIso() {
		return iso;
	}
	public void setIso(String iso) {
		this.iso = iso;
	}
	
	@Column(name="ISO_3")
	public String getIso3() {
		return iso3;
	}
	public void setIso3(String iso3) {
		this.iso3 = iso3;
	}
	
	@Column(name="NUM_CODE")
	public String getNumcode() {
		return numcode;
	}
	public void setNumcode(String numcode) {
		this.numcode = numcode;
	}
	
	@Column(name="PHONE_CODE")
	public String getPhonecode() {
		return phonecode;
	}
	public void setPhonecode(String phonecode) {
		this.phonecode = phonecode;
	}
	
	@Column(name="NICE_NAME")
	public String getNiceName() {
		return niceName;
	}
	public void setNiceName(String niceName) {
		this.niceName = niceName;
	}
	
	@XmlTransient
	public static class Builder {
		private Country country;
		
		public Builder(){
			this.country = new Country();
		}
	
		public Builder withId(long id) {
			this.country.setId(id);
			return this;
		}
		
		public Builder withUuid(String uuid) {
			this.country.setUuid(uuid);
			return this;
		}
		
		public Builder withTenant(int tenant) {
			this.country.setTenant(tenant);
			return this;
		}
		public Builder withLongitude(String longitude) {
			this.country.setLongitude(longitude);
			return this;
		}
		
		public Builder withLatitude(String latitude) {
			this.country.setLatitude(latitude);
			return this;
		}
		
		public Builder withName(String name) {
			this.country.setName(name);
			return this;
		}

		public Builder withIso(String iso) {
			this.country.setIso(iso);
			return this;
		}
		
		public Builder withIso3(String iso3) {
			this.country.setIso3(iso3);
			return this;
		}
		
		public Builder withNiceName(String niceName) {
			this.country.setNiceName(niceName);
			return this;
		}
		
		public Builder withNumCode(String numcode) {
			this.country.setNumcode(numcode);
			return this;
		}
		
		public Builder withPhoneCode(String phonecode) {
			this.country.setPhonecode(phonecode);
			return this;
		}
		
		public Country build(){
			return this.country;
		}
	}
}
