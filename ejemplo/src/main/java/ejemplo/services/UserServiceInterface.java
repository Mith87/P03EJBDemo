package ejemplo.services;

import org.springframework.data.domain.Page;

import ejemplo.contracts.UserRequest;
import ejemplo.ejb.Person;

public interface UserServiceInterface {
	
	Page<Person> getAll(UserRequest ur);

	Boolean saveUser(Person user);

	Person getSessionUser(int idUser);


}
