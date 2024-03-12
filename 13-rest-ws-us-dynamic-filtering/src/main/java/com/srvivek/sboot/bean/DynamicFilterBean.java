/**
 * 
 */
package com.srvivek.sboot.bean;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFilter;

/**
 * 
 */
@JsonFilter("DynamicFilterBean")
public record DynamicFilterBean(String id, String name, String pan, Date doj) {

}
