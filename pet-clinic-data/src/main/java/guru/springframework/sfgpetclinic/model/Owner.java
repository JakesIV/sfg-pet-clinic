package guru.springframework.sfgpetclinic.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import java.util.HashSet;
import java.util.Set;

/*
Implementation of Person
 */
@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "owners")
public class Owner extends Person {

	// We had to create this parameterised constructor for the builder pattern when
	// extending classes else the builder patter do not find the inherited properties
	@Builder
	public Owner(@NotEmpty String firstName, @NotEmpty String lastName, @NotEmpty String address, @NotEmpty String city,
			@NotEmpty String telephoneNumber) {
		super(firstName, lastName, address, city, telephoneNumber);
	}

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
	private Set<Pet> pets = new HashSet<>();

}
