package guru.springframework.sfgpetclinic.bootstrap;


import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.services.OwnerService;
import guru.springframework.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private OwnerService ownerService;
    private VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();
        owner1.setFirstName("Jacques");
        owner1.setId(1L);
        owner1.setLastName("van der Merwe");
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Tiaan");
        owner2.setId(2L);
        owner2.setLastName("van der Merwe");
        ownerService.save(owner2);

        System.out.println("Loaded Owners......");

        Vet vet1 = new Vet();
        vet1.setFirstName("Tannie");
        vet1.setId(1L);
        vet1.setLastName("Springfield");
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Ander");
        vet2.setId(2L);
        vet2.setLastName("stupid ou");
        vetService.save(vet2);

        System.out.println("Loaded Vets......");

    }
}
