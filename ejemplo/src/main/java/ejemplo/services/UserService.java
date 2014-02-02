package ejemplo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ejemplo.contracts.UserRequest;
import ejemplo.ejb.Person;
import ejemplo.repositories.UserRepository;
/*import com.cenfotec.cenfoteca.contracts.UsersRequest;
import com.cenfotec.cenfoteca.ejb.Usuario;*/
//import ejemplo.repositories.UserRepository;
import ejemplo.services.UserServiceInterface;

/*import com.cenfotec.cenfoteca.contracts.UsersRequest;
import com.cenfotec.cenfoteca.ejb.Usuario;
import com.cenfotec.cenfoteca.repositories.UsersRepository;*/


@Service
public class UserService implements UserServiceInterface{

	@Autowired
	UserRepository userRepository;
	
	@Override
	@Transactional
	public Page<Person> getAll(UserRequest ur) {
	
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
		
		Page<Person> result;
		
		if(ur.getSearchColumn().toLowerCase().equals("all")){
			result = userRepository.findAll(pr);
		}else{
			result = userRepository.findAll(pr);
		}
		return result;
		
	}

	@Override
	@Transactional
	public Boolean saveUser(Person user) {
		
		Person nuser = userRepository.save(user);
	
		Boolean result = true;
		if(nuser == null){
			result = false;
		}
		return result;
		
	}

	@Override
	public Person getSessionUser(int idUser) {
		return userRepository.findOne(idUser);
	}
}
