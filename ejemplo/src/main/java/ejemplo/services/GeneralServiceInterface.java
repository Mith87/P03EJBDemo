package ejemplo.services;

import java.util.List;

import ejemplo.ejb.Person;

public interface GeneralServiceInterface {

	List<Person> getAllTipoUsuario();
	Person getTipoUsuarioById(Integer idTipoUsuario);
}
