package ejemplo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ejemplo.ejb.Person;
import ejemplo.repositories.GeneralRepository;
import ejemplo.repositories.UserRepository;
import ejemplo.services.GeneralServiceInterface;


@Service
public class GeneralService implements GeneralServiceInterface{		
	
	@Autowired
	GeneralRepository generalRepository;
	
	@Autowired
	UserRepository tipoUsuarioRepository;
	
	@Override
	public List<Person> getAllTipoUsuario() {
		return (List<Person>) tipoUsuarioRepository.findAll();
	}

	@Override
	public Person getTipoUsuarioById(Integer idTipoUsuario) {
		return tipoUsuarioRepository.findOne(idTipoUsuario);
	}
	
}