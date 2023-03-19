//Project: < Recipe Database >
//		* Assignment: < assignment 2 >
//		* Author(s): < Marie Pagaduan, Janine Usana, Ellyn Bibon>
//		* Student Number: < 101256979,  101328279, 101329235>
//		* Date: December 4, 2022
//		* Description: <It contains the user registration file>
package net.javaguides.springboot.web.dto;

public class UserRegistrationDto {

	private String firstName;
	private String lastName;
	private String email;
	private String password;

	public UserRegistrationDto() {}

	public UserRegistrationDto(String firstName, String lastName, String email, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
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
}
