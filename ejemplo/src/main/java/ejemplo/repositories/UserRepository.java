package ejemplo.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import ejemplo.ejb.Person;


public interface UserRepository extends CrudRepository<Person,Integer> {
	
	public static final int PAGE_SIZE = 5;
	
	Person findByNombreAndApellido(String nombre, String apellido);
	
	Page<Person> findAll(Pageable pageable);
}