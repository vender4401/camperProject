package camper_join.service;



import java.util.Map;

public class JoinRequest {
	private String id;
	private String name;
	private String gender;
	private String birth;	
	
	private String phone;

	private String email;
	
	private String password;
	private String passwordCheck;	
	private String password2;
	
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPasswordCheck() {
		return passwordCheck;
	}
	public void setPasswordCheck(String passwordCheck) {
		this.passwordCheck = passwordCheck;
	}
	public String getPassword2() {
		return password2;
	}
	public void setPassword2(String password2) {
		this.password2 = password2;
	}

	public void validate(Map<String, Boolean> errors) {
		// id값이 잘 들어왔는지?
		checkEmpty(errors, id, "id");
		// name 잘 들어왔는지?
		checkEmpty(errors, name, "name");
		// 성별 gender 잘 들어왔는지?
		checkEmpty(errors, gender, "gender");
		// 생년월일 잘 들어왔는지? 
		checkEmpty(errors, birth, "birth");	
		
		// phone 잘 들어왔는지?
		checkEmpty(errors, phone, "phone");

		// email 잘 들어왔는지?
		checkEmpty(errors, email, "email");
		
		
		// password 잘 들어왔는지?
		checkEmpty(errors, password, "password");
		// passwordCheck 잘 들어왔는지?
		checkEmpty(errors, passwordCheck, "passwordCheck");
		// 2차passwrd2 잘 들어왔는지?
		checkEmpty(errors, password2, "password2");
		
		
		
		if (!errors.containsKey("passwordCheck")) {
			if (!isPasswordEqualToConfirm()) {
				errors.put("notMatch", true);
			}
		}
	}
	
	private void checkEmpty(Map<String, Boolean> errors, String pw, String pwCheck) {
		if (pw == null || pw.isEmpty()) {
			errors.put(pwCheck, true);
		}
		
	}
	
	
	private boolean isPasswordEqualToConfirm() {
		return password != null && password.equals(passwordCheck);
	}

	
	
	
	
	
	
	
}
