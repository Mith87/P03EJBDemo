package ejemplo.contracts;

import ejemplo.pojo.PersonPOJO;


public class UserRequest extends BasePagingRequest {

	private PersonPOJO user;
	
	public UserRequest() {
		super();
	}
	
	public PersonPOJO getUser() {
		return user;
	}
	
	public void setUser(PersonPOJO user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "UsersRequest [user=" + user + "]";
	}
}
