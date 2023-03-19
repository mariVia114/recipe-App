//Project: < Recipe Database >
//		* Assignment: < assignment 2 >
//		* Author(s): < Marie Pagaduan, Janine Usana, Ellyn Bibon>
//		* Student Number: < 101256979,  101328279, 101329235>
//		* Date: December 4, 2022
//		* Description: <It contains the forgot password file>
package net.javaguides.springboot.model;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public class PasswordForgot {
    @NotEmpty(message = "{EMAIL_REQUIRED}")
    @Email(message = "{NOT_VALID_EMAIL}")
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
