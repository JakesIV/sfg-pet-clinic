package guru.springframework.sfgpetclinic.bootstrap;

import guru.springframework.sfgpetclinic.model.*;
import guru.springframework.sfgpetclinic.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

	//we use the service interface so that we either inject JPA objects or MAP object depending on spring profile
	private final OwnerService ownerService;

	private final VetService vetService;

	private final PetTypeService petTypeService;

	private final SpecialtyService specialtyService;

	private final VisitService visitService;

	public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialtyService specialtyService, VisitService visitService) {
		this.ownerService = ownerService;
		this.vetService = vetService;
		this.petTypeService = petTypeService;
		this.specialtyService = specialtyService;
		this.visitService = visitService;
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
		System.out.println("Loaded Pet Types......");
		//
		Owner owner1 = new Owner().builder()
				.firstName("Jacques")
				.lastName("van der Merwe")
				.address("2 Argent ave, Helderkruin")
				.city("Roodepoort")
				.telephoneNumber("011-111-2222")
				.build();
		//This is using the builder pattern to create the pet object
		Pet pet1 = new Pet().builder().name("Zoey").petType(savedDogPetType).birthDate(LocalDate.now()).owner(owner1).build();
		pet1.setOwner(owner1);
		owner1.getPets().add(pet1);
		ownerService.save(owner1);
		//
		Owner owner2 = new Owner();
		owner2.setFirstName("Tiaan");
		owner2.setLastName("van der Merwe");
		owner2.setAddress("2 Argent ave, Helderkruin");
		owner2.setCity("Roodepoort");
		owner2.setTelephoneNumber("121212121");
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
		vet1.setAddress("fdsffdsfds");
		vet1.setCity("Joburg");
		vet1.setTelephoneNumber("212121212121");
		vetService.save(vet1);
		//
		Vet vet2 = new Vet();
		vet2.setFirstName("Ander");
		vet2.setLastName("stupid ou");
		vet2.getSpecialty().add(radiology);
		vet2.getSpecialty().add(dentistry);
		vet2.setAddress("gfdjkfgd  kjgflkg gfg");
		vet2.setCity("PTA");
		vet2.setTelephoneNumber("444444444");
		vetService.save(vet2);
		//
		System.out.println("Loaded Vets......");

		Visit visit = new Visit();
		visit.setDescription("General checkup");
		visit.setPet(pet1);
		visit.setDate(LocalDate.now());
		visit.setVet(vet1);
		visitService.save(visit);

		Visit visit2 = new Visit();
		visit.setDescription("Dentist");
		visit.setPet(pet1);
		visit.setDate(LocalDate.now());
		visit.setVet(vet2);
		visitService.save(visit);

		System.out.println("Loaded Visits......");

	}

}
