package za.co.enigma.business.domain.party.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import za.co.enigma.domain.archetypes.DescriptionDomainArchetype;

@EqualsAndHashCode(callSuper=true)

@Entity
@Table(name="PARTY_TYPE",
uniqueConstraints= {
        @javax.persistence.UniqueConstraint(name="PARTY_TYPE_02U", columnNames={"ID", "UUID"})
        }
)
public class PartyType extends DescriptionDomainArchetype {

    private static final long serialVersionUID = 3917295761717926664L;

}
