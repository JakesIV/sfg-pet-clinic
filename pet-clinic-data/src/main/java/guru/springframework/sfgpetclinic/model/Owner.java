package guru.springframework.sfgpetclinic.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/*
Implementation of Person
 */
public class Owner extends Person {

    private Set<Pet> pets;

    public Set<Pet> getPets() {
        return pets;
    }

    public void setPets(Set<Pet> pets) {
        this.pets = pets;
    }
}
