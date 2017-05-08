package za.co.enigma.domain.archetypes;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper=true)

@MappedSuperclass
public abstract class PlaceDomainArchetype extends BaseEntity {

	private static final long serialVersionUID = -8650408548491958520L;

	private String longitude;
	private String latitude;
	private String name;

	@Column(name="LONGITUDE")
	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	
	@Column(name="LATITUDE")
	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	
	@Column(name="NAME")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
