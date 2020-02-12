package guru.springframework.sfgpetclinic.model;

import java.util.ArrayList;
import java.util.List;

/*
Implementation of Person
 */
public class Owner extends Person {

    private List<Pet> pets = new ArrayList<>();

    public List<Pet> getPets() {
        return pets;
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }
}
