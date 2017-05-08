package za.co.enigma.domain.archetypes;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper=true)

@MappedSuperclass
public abstract class ThingDomainArchetype extends BaseEntity {

    private static final long serialVersionUID = 3391555359664846509L;

    private String name;

    @Column(name="NAME")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
    
}
