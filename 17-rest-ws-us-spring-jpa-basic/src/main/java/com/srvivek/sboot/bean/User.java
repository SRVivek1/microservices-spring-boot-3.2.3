/**
 * 
 */
package com.srvivek.sboot.bean;

import java.util.Date;
import java.util.Objects;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

/**
 * User bean
 */

@Schema(description = "User details.")
@Entity(name = "users")
public class User {

	@Schema(description = "User id")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer Id;

	@Schema(description = "User's full name")
	@Size(min = 4, max = 40, message = "Names should be > 2 & < 40 characters.")
	private String name;

	@Schema(description = "Date of birth")
	@Past(message = "DOB should be past date.")
	private Date dob;

	public User() {

	}

	/**
	 * @param id
	 * @param name
	 * @param dob
	 */
	public User(Integer id, @Size(min = 4, max = 40, message = "Names should be > 2 & < 40 characters.") String name,
			@Past(message = "DOB should be past date.") Date dob) {
		super();
		Id = id;
		this.name = name;
		this.dob = dob;
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	@Override
	public int hashCode() {
		return Objects.hash(Id, dob, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(Id, other.Id) && Objects.equals(dob, other.dob) && Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "User [Id=" + Id + ", name=" + name + ", dob=" + dob + "]";
	}
}