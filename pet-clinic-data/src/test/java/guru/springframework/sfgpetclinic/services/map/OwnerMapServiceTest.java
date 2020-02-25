package guru.springframework.sfgpetclinic.services.map;

import guru.springframework.sfgpetclinic.model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class OwnerMapServiceTest {

    OwnerMapService ownerMapService;

    @BeforeEach
    void setUp() {
        ownerMapService = new OwnerMapService(new PetTypeMapService(), new PetMapService());
        //creates one owner object with Id = 1
        ownerMapService.save(new Owner().builder().firstName("Jacques").lastName("van der Merwe")
                .address("2 Argent ave, Helderkruin").city("Roodepoort").telephoneNumber("011-111-2222").build());
    }

    @Test
    void findById() {
        Owner owner = ownerMapService.findById(1L);
        assertEquals("Jacques", owner.getFirstName());
    }

    @Test
    void save() {
        ownerMapService.save(new Owner().builder().firstName("Tiaan").lastName("van der Merwe")
                .address("2 Argent ave, Helderkruin").city("Roodepoort").telephoneNumber("011-111-2222").build());
        Owner owner2 = ownerMapService.findById(2L);
        assertEquals("Tiaan", owner2.getFirstName());
        Owner owner1 = ownerMapService.findById(1L);
        assertEquals("Jacques", owner1.getFirstName());
    }

    @Test
    void findAll() {
       Set<Owner> owners =  ownerMapService.findAll();
       assertEquals(1, owners.size());
    }

    @Test
    void deleteById() {
        ownerMapService.deleteById(1L);
        assertEquals(0, ownerMapService.findAll().size());
    }

    @Test
    void delete() {
        ownerMapService.delete(ownerMapService.findById(1L));
        assertEquals(0, ownerMapService.findAll().size());
    }

    @Test
    void findByLastName() {
        Owner owner = ownerMapService.findByLastName("van der Merwe");
        assertNotNull(owner);

        assertEquals(1L, owner.getId());
    }
}