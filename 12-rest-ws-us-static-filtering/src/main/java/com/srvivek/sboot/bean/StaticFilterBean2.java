/**
 * 
 */
package com.srvivek.sboot.bean;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.validation.constraints.Size;

/**
 * 
 */
@JsonIgnoreProperties(value = { "pan", "doj" })
public record StaticFilterBean2(String id, @Size(min = 2, max = 40, message = "min 2 & max 40 chars") String name,
		String pan, Date doj) {

}
