/**
 * 
 */
package com.srvivek.sboot.exception;

import java.util.Date;

/**
 * 
 */
public class ExceptionResponse {

	private Date timestamp;
	private String messgae;
	private String details;
	/**
	 * @param timestamp
	 * @param messgae
	 * @param details
	 */
	public ExceptionResponse(Date timestamp, String messgae, String details) {
		super();
		this.timestamp = timestamp;
		this.messgae = messgae;
		this.details = details;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	public String getMessgae() {
		return messgae;
	}
	public void setMessgae(String messgae) {
		this.messgae = messgae;
	}
	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}
}
