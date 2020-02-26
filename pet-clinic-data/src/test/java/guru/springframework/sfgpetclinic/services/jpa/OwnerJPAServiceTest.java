package guru.springframework.sfgpetclinic.services.jpa;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.repositories.OwnerRepository;
import guru.springframework.sfgpetclinic.model.repositories.PetRepository;
import guru.springframework.sfgpetclinic.model.repositories.PetTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

//Here we setup a Mockito test
@ExtendWith(MockitoExtension.class)
class OwnerJPAServiceTest {

    @Mock
    OwnerRepository ownerRepository;

    @Mock
    PetRepository petRepository;

    @Mock
    PetTypeRepository petTypeRepository;

    @InjectMocks
    OwnerJPAService ownerJPAService;

    Owner owner;

    @BeforeEach
    void setup () {
        owner = new Owner();
        owner.setId(1L);
        owner.setLastName("van der Merwe");
    }

    @Test
    void findByLastName() {
        //this intercepts the method findByLastName() and would then return the data we created in previous step
        when(ownerRepository.findByLastName(any())).thenReturn(owner);

        Owner van = ownerJPAService.findByLastName("van der Merwe");
        //assertNull(van);
        assertEquals(1,owner.getId());

        verify(ownerRepository).findByLastName(any());

    }

    @Test
    void findById() {
    }

    @Test
    void save() {
    }

    @Test
    void findAll() {
    }

    @Test
    void delete() {
    }

    @Test
    void deleteById() {
    }
}