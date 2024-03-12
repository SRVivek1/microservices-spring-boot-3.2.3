/**
 * 
 */
package com.srvivek.sboot.bean;

import java.util.Date;

import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

/**
 * User bean
 */
public record User(Integer id, @Size(min = 4, max = 40, message = "Names should be > 2 & < 40 characters.") String name,
		@Past(message = "DOB should be past date.") Date dob) {

}
