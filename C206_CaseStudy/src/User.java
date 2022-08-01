
public class User {
	private String name; 
	private String role; 
	private String email; 
	private String password; 
	
	public User(String name, String role, String email, String password) {
		super();
		this.name = name;
		this.role = role;
		this.email = email;
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public String getRole() {
		return role;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}
}
