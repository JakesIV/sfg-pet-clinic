package guru.springframework.sfgpetclinic.bootstrap;

import guru.springframework.sfgpetclinic.model.*;
import guru.springframework.sfgpetclinic.services.OwnerService;
import guru.springframework.sfgpetclinic.services.PetTypeService;
import guru.springframework.sfgpetclinic.services.SpecialtyService;
import guru.springframework.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

	private OwnerService ownerService;

	private VetService vetService;

	private PetTypeService petTypeService;

	private SpecialtyService specialtyService;

	public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialtyService specialtyService) {
		this.ownerService = ownerService;
		this.vetService = vetService;
		this.petTypeService = petTypeService;
		this.specialtyService = specialtyService;
	}

	@Override
	public void run(String... args) throws Exception {

		int count = petTypeService.findAll().size();

		if (count == 0)
		{
			loadData();
		}
	}

	private void loadData() {
		PetType dog = new PetType();
		dog.setName("Dog");
		PetType savedDogPetType = petTypeService.save(dog);
		//
		PetType cat = new PetType();
		cat.setName("Cat");
		petTypeService.save(cat);
		//
		PetType bird = new PetType();
		bird.setName("Bird");
		PetType savedCatPetType = petTypeService.save(bird);
		//
		Owner owner1 = new Owner();
		owner1.setFirstName("Jacques");
		owner1.setLastName("van der Merwe");
		owner1.setAddress("2 Argent ave, Helderkruin");
		owner1.setCity("Roodepoort");
		owner1.setTelephoneNumber("011-111-2222");
		//
		Pet pet1 = new Pet();
		pet1.setName("Zoey");
		pet1.setPetType(savedDogPetType);
		pet1.setBirthDate(LocalDate.now());
		pet1.setOwner(owner1);
		owner1.getPets().add(pet1);
		ownerService.save(owner1);
		//
		Owner owner2 = new Owner();
		owner2.setFirstName("Tiaan");
		owner2.setLastName("van der Merwe");
		owner2.setAddress("2 Argent ave, Helderkruin");
		owner2.setCity("Roodepoort");
		ownerService.save(owner2);
		//
		System.out.println("Loaded Owners......");
		//Add Specialties
		Specialty radiology = new Specialty();
		radiology.setDescription("Radiology");
		Specialty radiologySpecialty = specialtyService.save(radiology);
		//
		Specialty dentistry = new Specialty();
		dentistry.setDescription("Dentistry");
		Specialty dentistrySpecialty = specialtyService.save(dentistry);
		//
		Specialty surgery = new Specialty();
		surgery.setDescription("Surgery");
		Specialty surgerySpecialty = specialtyService.save(surgery);

		Vet vet1 = new Vet();
		vet1.setFirstName("Tannie");
		vet1.setLastName("Springfield");
		vet1.getSpecialty().add(surgery);
		vet1.getSpecialty().add(dentistry);
		vetService.save(vet1);
		//
		Vet vet2 = new Vet();
		vet2.setFirstName("Ander");
		vet2.setLastName("stupid ou");
		vet2.getSpecialty().add(radiology);
		vet2.getSpecialty().add(dentistry);
		vetService.save(vet2);
		//
		System.out.println("Loaded Vets......");

		Visit visit = new Visit();
		visit.setDescription("General checkup");
		visit.setPet(pet1);
		visit.setDate(LocalDate.now());

		Visit visit2 = new Visit();
		visit.setDescription("Dentist");
		visit.setPet(pet1);
		visit.setDate(LocalDate.now());

	}

}
