package za.co.enigma.domain.archetypes;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import lombok.EqualsAndHashCode;
import za.co.enigma.common.util.LocalDateTimeAdapter;
/**
 * 
 * @author luckson
 * The Moment-Interval class archetype that models something that one needs to work with 
 * and track for business and legal reasons, 
 * something that occurs at a moment in time or over an interval of time.
 * Moment-Interval classes are pink (pastel red). 
 * They represent happenings that take place that our software is interested in, 
 * interactions and business transactions between people, places and things
 */

@EqualsAndHashCode(callSuper=true)

@MappedSuperclass
public abstract class MomentIntervalDomainArchetype extends BaseEntity {

    private static final long serialVersionUID = -709323524159747392L;
    
    private LocalDateTime effectiveFrom;
    private LocalDateTime effectiveTo;

    @Column(name = "EFFECTIVE_FROM", nullable = false)
    @NotNull(message = "\"The Effective From field cannot be null.\"")
    @XmlJavaTypeAdapter(LocalDateTimeAdapter.class)
	public LocalDateTime getEffectiveFrom() {
    	if(this.effectiveFrom == null) {
    		LocalDate date = LocalDate.of(1970, Month.JANUARY, 01);
			LocalTime time = LocalTime.of(0, 0);
			this.effectiveFrom = LocalDateTime.of(date, time);
    	}
		return effectiveFrom;
	}

	public void setEffectiveFrom(LocalDateTime effectiveFrom) {
		this.effectiveFrom = effectiveFrom;
	}

    @Column(name = "EFFECTIVE_TO", nullable = false)
    @NotNull(message = "\"The Effective From field cannot be null.\"")
    @XmlJavaTypeAdapter(LocalDateTimeAdapter.class)
	public LocalDateTime getEffectiveTo() {
    	if(this.effectiveTo == null) {
    		LocalDate date = LocalDate.of(9999, Month.DECEMBER, 31);
			LocalTime time = LocalTime.of(0, 0);
			this.effectiveTo = LocalDateTime.of(date, time);
    	}
		return effectiveTo;
	}

	public void setEffectiveTo(LocalDateTime effectiveTo) {
		this.effectiveTo = effectiveTo;
	}
    
}
