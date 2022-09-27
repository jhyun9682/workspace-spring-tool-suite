package com.booklib.DTO;

public class UserInfo {
	private String u_id;
	private String u_password;
	private String u_name;
	private String u_phone;
	private String u_birth;
	private String u_gender;
	private String u_email;
	private String u_address;
	
	public UserInfo() {
	}
	
	
	public UserInfo(String u_id, String u_password, String u_name, String u_phone, String u_birth, String u_gender,
			String u_email, String u_address) {
		super();
		this.u_id = u_id;
		this.u_password = u_password;
		this.u_name = u_name;
		this.u_phone = u_phone;
		this.u_birth = u_birth;
		this.u_gender = u_gender;
		this.u_email = u_email;
		this.u_address = u_address;
	}

	public String getU_id() {
		return u_id;
	}

	public void setU_id(String u_id) {
		this.u_id = u_id;
	}

	public String getU_password() {
		return u_password;
	}

	public void setU_password(String u_password) {
		this.u_password = u_password;
	}

	public String getU_name() {
		return u_name;
	}

	public void setU_name(String u_name) {
		this.u_name = u_name;
	}

	public String getU_phone() {
		return u_phone;
	}

	public void setU_phone(String u_phone) {
		this.u_phone = u_phone;
	}

	public String getU_birth() {
		return u_birth;
	}

	public void setU_birth(String u_birth) {
		this.u_birth = u_birth;
	}

	public String getU_gender() {
		return u_gender;
	}

	public void setU_gender(String u_gender) {
		this.u_gender = u_gender;
	}

	public String getU_email() {
		return u_email;
	}

	public void setU_email(String u_email) {
		this.u_email = u_email;
	}

	public String getU_address() {
		return u_address;
	}

	public void setU_address(String u_address) {
		this.u_address = u_address;
	}

	@Override
	public String toString() {
		return "UserInfo [u_id=" + u_id + ", u_password=" + u_password + ", u_name=" + u_name + ", u_phone=" + u_phone
				+ ", u_birth=" + u_birth + ", u_gender=" + u_gender + ", u_email=" + u_email + ", u_address="
				+ u_address + "]";
	}
	
}
