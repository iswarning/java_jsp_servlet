package entity;

public class User {

	private int id;
	private String name;
	private String email;
	private String provider;
	private String provider_id;
	private String password;
	private String remember_token;
	private int role;
	
	public User() {
		super();
	}

	public User(int id, String name, String email, String provider, String provider_id, String password,
			String remember_token, int role) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.provider = provider;
		this.provider_id = provider_id;
		this.password = password;
		this.remember_token = remember_token;
		this.role = role;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getProvider() {
		return provider;
	}

	public void setProvider(String provider) {
		this.provider = provider;
	}

	public String getProvider_id() {
		return provider_id;
	}

	public void setProvider_id(String provider_id) {
		this.provider_id = provider_id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRemember_token() {
		return remember_token;
	}

	public void setRemember_token(String remember_token) {
		this.remember_token = remember_token;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", provider=" + provider + ", provider_id="
				+ provider_id + ", password=" + password + ", remember_token=" + remember_token + ", role=" + role
				+ "]";
	}
	
	
}
