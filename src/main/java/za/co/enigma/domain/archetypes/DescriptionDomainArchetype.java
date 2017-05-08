package za.co.enigma.domain.archetypes;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import lombok.EqualsAndHashCode;

/**
 * 
 * @author luckson
 *
 * The Description class archetype that models a catalog-entry-like description. 
 * It is a collection of values that apply again and again. 
 * It also provides behavior across the collection of all things that correspond to its description. [Coad99].
 * Examples include classes representing product descriptions of all kinds. 
 * The difference between a blue and green is the difference between a film and the DVD's on which the film is recorded.
 * Description classes are pastel blue in color. Description classes categorize or label other stuff depending on different values,
 *  typically objects of Party, Place, Thing classes but occasionally Moment-Intervals too. 
 *  The industries that companies work within are objects of a Description class. 
 *  The models of a car in a show room are objects of a Description class. 
 * The titles of books sold by Amazon.com are objects of a Description class.
 * The labels you use to catalog stuff like this, are always blue!
 */

@EqualsAndHashCode(callSuper=true)

@MappedSuperclass
public abstract class DescriptionDomainArchetype extends BaseEntity {

	private static final long serialVersionUID = -2256019790922847052L;

	private String name;
	private String code;
	private String note;
	private String description; 

	@Column(name="NAME")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Column(name="CODE")
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	@Column(name="NOTE")
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}

	@Column(name="DESCRIPTION")
	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}

}
