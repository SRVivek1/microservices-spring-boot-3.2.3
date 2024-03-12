/**
 * 
 */
package com.srvivek.sboot.bean;

import java.util.Date;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

/**
 * User bean
 */
@Schema(description = "User details.")
public record User(@Schema(description = "User id") Integer id, @Schema(description = "User's full name") @Size(min = 4, max = 40, message = "Names should be > 2 & < 40 characters.") String name,
		@Schema(description = "Date of birth") @Past(message = "DOB should be past date.") Date dob) {

}
