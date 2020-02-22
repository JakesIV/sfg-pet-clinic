package guru.springframework.sfgpetclinic.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "pets")
public class Pet extends BaseEntity {

	@Column(name = "birth_date")
	private LocalDate birthDate;

	@ManyToOne
	@JoinColumn(name = "owner_id")
	private Owner owner;

	@ManyToOne
	@JoinColumn(name = "type_id")
	private PetType petType;

	@Column(name = "name")
	private String name;

	@OneToMany(cascade = CascadeType.ALL)
	private Set<Visit> visits = new HashSet<>();

}
