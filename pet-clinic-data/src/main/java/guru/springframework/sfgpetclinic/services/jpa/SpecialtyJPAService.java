package guru.springframework.sfgpetclinic.services.jpa;

import guru.springframework.sfgpetclinic.model.Specialty;
import guru.springframework.sfgpetclinic.model.repositories.SpecialtyRepository;
import guru.springframework.sfgpetclinic.services.SpecialtyService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Component
@Profile("springdatajpa")
public class SpecialtyJPAService implements SpecialtyService {

	private final SpecialtyRepository specialtyRepository;

	public SpecialtyJPAService(SpecialtyRepository specialtyRepository) {
		this.specialtyRepository = specialtyRepository;
	}

	@Override
	public Specialty findById(Long id) {
		Optional<Specialty> speciality = specialtyRepository.findById(id);
		return speciality.orElse(null);
	}

	@Override
	public Specialty save(Specialty speciality) {
		return specialtyRepository.save(speciality);
	}

	@Override
	public Set<Specialty> findAll() {
		Set<Specialty> specialties = new HashSet<>();
		specialtyRepository.findAll().forEach(specialties::add);
		return specialties;
	}

	@Override
	public void delete(Specialty speciality) {

	}

	@Override
	public void deleteById(Long id) {

	}

}
