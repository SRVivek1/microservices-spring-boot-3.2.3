/**
 * 
 */
package com.srvivek.sboot.bean;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.validation.constraints.Size;

/**
 * 
 */
public record StaticFilterBean(String id, @Size(min = 2, max = 40, message = "min 2 & max 40 chars") String name,
		@JsonIgnore String pan, @JsonIgnore Date doj) {

}
