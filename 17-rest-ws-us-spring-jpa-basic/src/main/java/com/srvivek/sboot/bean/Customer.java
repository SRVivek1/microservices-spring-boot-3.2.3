/**
 * 
 */
package com.srvivek.sboot.bean;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

/**
 * 
 */
@Entity (name = "customers")
public record Customer(@Id @GeneratedValue String id, @Column(name = "cust_name") String name) {

}
