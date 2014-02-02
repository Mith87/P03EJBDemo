package ejemplo.repositories;

import org.springframework.data.repository.CrudRepository;

import ejemplo.ejb.Person;

public interface GeneralRepository extends CrudRepository<Person,Integer> {
	
	public static final int PAGE_SIZE = 5;
}
