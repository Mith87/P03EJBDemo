package ejemplo.contracts;

import java.util.List;

import ejemplo.pojo.PersonPOJO;

public class UserResponse extends BaseResponse {

	private List<PersonPOJO> usuarios;

	public UserResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public List<PersonPOJO> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<PersonPOJO> usuarios) {
		this.usuarios = usuarios;
	}
}
