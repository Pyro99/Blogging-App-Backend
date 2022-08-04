package com.blog.payload;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto 
{
	private int id;
	
	@NotEmpty
	//@Size(min = 4, max = 10, message = "Password must be min 4 and max 10 characters !!")
	@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{4,10}$",
	message = "Password must contain atleast 1 digit, atleast 1 lower case character, "
			+ "atleast 1 upper case character, atleast 1 special character and must be min of 4 and"
			+ " max of 10 characters !!")
	private String password;
	
	@NotEmpty
	@Email
	private String email;
	
	@NotEmpty
	@Size(min = 4,message = "Name must be min of 4 characters !!")
	private String name;
	
	@NotEmpty
	private String about;
}
