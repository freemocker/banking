package za.co.enigma.domain.archetypes;

import java.time.LocalDate;
import java.time.Month;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import lombok.EqualsAndHashCode;
import za.co.enigma.common.util.LocalDateAdapter;
/**
 * 
 * @author luckson
 * 
 * The Role class archetype that models a way of participation by a party (person or organization), place or, thing. [Coad99]
 * Examples of role classes include Applicant, Account Holder, Approver, Pilot, Cashier, Customer, Supplier, Operator, etc.
 * Role classes are pastel yellow in color. They represent recognizable ways that people, places, and
 *  things participate in moment-intervals (happenings) in our software. Roles are sets of responsibilities and 
 *  duties that we are able and authorized to perform. 
 *  We often talk about ourselves as wearing multiple or different hats when we are expected to perform multiple or different roles. 
 *  Role classes model those hats, and those hats are always yellow.  
 */

@EqualsAndHashCode(callSuper=true)

@MappedSuperclass
public abstract class RoleDomainArchetype extends BaseEntity {

	private static final long serialVersionUID = -4368049626775403459L;

	private String name;
	private String description;
	private LocalDate effectiveFrom;
	private LocalDate effectiveTo;
	
	@Column(name="NAME")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	@Column(name="DESCRIPTION")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name="EFFECTIVE_FROM")
	@XmlJavaTypeAdapter(LocalDateAdapter.class)
	public LocalDate getEffectiveFrom() {
		if (this.effectiveFrom == null) {
			this.effectiveFrom = LocalDate.of(1970, Month.JANUARY, 01);
		}
		return effectiveFrom;
	}

	public void setEffectiveFrom(LocalDate effectiveFrom) {
		this.effectiveFrom = effectiveFrom;
	}

	@Column(name="EFFECTIVE_TO")
	@XmlJavaTypeAdapter(LocalDateAdapter.class)
	public LocalDate getEffectiveTo() {
		if (this.effectiveTo == null) {
			this.effectiveTo = LocalDate.of(9999, Month.DECEMBER, 31);
		}
		return effectiveTo;
	}

	public void setEffectiveTo(LocalDate effectiveTo) {
		this.effectiveTo = effectiveTo;
	}
}
