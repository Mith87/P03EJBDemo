package ejemplo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/*import com.cenfotec.cenfoteca.contracts.UsersRequest;
import com.cenfotec.cenfoteca.ejb.Usuario;*/
//import ejemplo.repositories.UserRepository;
import ejemplo.services.UserServiceInterface;

/*import com.cenfotec.cenfoteca.contracts.UsersRequest;
import com.cenfotec.cenfoteca.ejb.Usuario;
import com.cenfotec.cenfoteca.repositories.UsersRepository;*/


@Service
public class UserService implements UserServiceInterface{

	/*@Autowired
	UserRepository usersRepository;
	
	@Override
	@Transactional
	public Page<Usuario> getAll(UsersRequest ur) {
	
		PageRequest pr;
		Sort.Direction direction = Sort.Direction.DESC;
		if(ur.getDirection().equals("ASC")){
			direction = Sort.Direction.ASC;
		}
		
		if(ur.getSortBy().size() > 0){
			Sort sort = new Sort(direction,ur.getSortBy());
			pr = new PageRequest(ur.getPageNumber(),ur.getPageSize(),sort);
		}else{
			pr = new PageRequest(ur.getPageNumber(),ur.getPageSize());
		}
		
		Page<Usuario> result;
		
		if(ur.getSearchColumn().toLowerCase().equals("all")){
			result = userRepository.findAll(pr);
		}else if(ur.getSearchColumn().toLowerCase().equals("firstname")){
			result = userRepository.findByFirstnameContaining(ur.getSearchTerm(),pr);
		} else if(ur.getSearchColumn().toLowerCase().equals("lastname")){
			result = userRepository.findByLastnameContaining(ur.getSearchTerm(),pr);
		}else{
			result = userRepository.findAll(pr);
		}
		return result;
		
	}

	@Override
	@Transactional
	public Boolean saveUser(Usuario user) {
		
		Usuario nuser = userRepository.save(user);
	
		Boolean result = true;
		if(nuser == null){
			result = false;
		}
		return result;
		
	}

	@Override
	public Usuario getSessionUser(int idUser) {
		return userRepository.findOne(idUser);
	}*/
}
