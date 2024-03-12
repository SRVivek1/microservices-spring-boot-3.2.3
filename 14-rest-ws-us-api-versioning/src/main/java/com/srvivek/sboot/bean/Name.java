/**
 * 
 */
package com.srvivek.sboot.bean;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Represent name as firstName & lastName {@link String} properties.
 */
@Schema(description = "Name class.")
public record Name(@Schema(description = "User's first name") String firstName,
		@Schema(description = "User's last name") String lastName) {

}
