package za.co.enigma.domain.archetypes;

import javax.persistence.MappedSuperclass;

/**
 * 
 * @author luckson
 *
 * The Party, Place, Thing class archetype that models someone or something who plays different roles.[Coad99] 
 * Examples of Party classes are Person and Organization. 
 * Examples of Place classes  include Office, Store, Warehouse, Airport, Bank Branch, etc. 
 * Thing classes are those that identify individual items such as individual cars, airplanes, DVD's, books, pieces of equipment, etc.
 * Party, Place, Thing classes are pastel green in color.  
 * If Role classes are the different (yellow) hats that can be worn, then Party, Place, Thing classes are the wearers of those hats. 
 * Obviously, people play roles but places can too. A building might have a role as a restaurant another as a crime scene. 
 * Things can also play roles, a role in a manufacturing process, and a role in a sales process, for example.
 *  If it you can converse with it, be taken to court by it, move it, kick it, sit on it, or stand in it, 
 *  then it is likely to be a green Party, Place, Thing.
 *  
 *  Hats are yellow but those that wear them are green!
 */
@MappedSuperclass
public abstract class PartyDomainArchetype extends BaseEntity {

    private static final long serialVersionUID = 7038096617217710811L;

}
