/**
 * 
 */
package com.srvivek.sboot.bean;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFilter;

/**
 * 
 */
@JsonFilter("DynamicFilterBean2")
public record DynamicFilterBean2(String id, String name, String pan, Date doj) {

}
