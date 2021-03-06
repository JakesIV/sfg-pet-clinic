package guru.springframework.sfgpetclinic.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@Builder
@Entity
@Table(name = "visits")
public class Visit extends BaseEntity {

	@Column(name = "date")
	private LocalDate date;

	@Column(name = "description")
	private String description;

	@ManyToOne
	@JoinColumn(name = "pet_id")
	private Pet pet;

	@OneToOne
	private Vet vet;

	public Visit() {
		this.date = LocalDate.now();
	}

}
