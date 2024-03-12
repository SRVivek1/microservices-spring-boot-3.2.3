/**
 * 
 */
package com.srvivek.sboot.bean;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

/**
 * 
 */
@Entity(name = "posts")
@Schema(description = "User posts beans")
public class Post {

	@Id
	@GeneratedValue
	@Column(name = "post_id")
	@Schema(description = "Post ID.")
	private Integer id;

	@Schema(description = "Post content")
	@Column(name = "content")
	private String content;

	@Schema(description = "Posted by.")
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	private User user;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public int hashCode() {
		return Objects.hash(content, id, user);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Post other = (Post) obj;
		return Objects.equals(content, other.content) && Objects.equals(id, other.id)
				&& Objects.equals(user, other.user);
	}

	@Override
	public String toString() {
		return "Post [id=" + id + ", content=" + content + "]";
	}
}
