package guru.springframework.sfgpetclinic.services;

import java.util.Set;

public interface

CrudService<T, ID> {

	T findById(ID id);

	T save(T interfaceObject);

	Set<T> findAll();

	void delete(T interfaceObject);

	void deleteById(ID id);

}
