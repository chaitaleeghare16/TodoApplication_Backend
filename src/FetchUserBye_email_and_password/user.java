package FetchUserBye_email_and_password;

public class user {
	
	private int id ;
	private String firstname;
	private String lastname;
	
	private String usertype;
	private String status;
	private String email;
	
	
	
	
	
	public user(int id, String firstname, String lastname, String usertype,String status,String email
			) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		
		this.usertype = usertype;
		this.status = status;
		this.email=email;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	public String getUsertype() {
		return usertype;
	}
	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}
	
	public user(String email) {
		super();
		this.email = email;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	

}
