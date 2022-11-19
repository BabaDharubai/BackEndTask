/**
 * 
 */
package com.pdfcreator.model;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

/**
 * @author BabaFakruddinDharubai
 *
 */
public class ApiErrors {

	String error;
	String message;
	HttpStatus status;
	int statusCode;
	LocalDateTime timestamp;
	/**
	 * Default Constructor of ApiError, it will go and assign the instances with the default values from Object class
	 */
	public ApiErrors() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param error the error to pass the method
	 * @param message the message to pass to the method
	 * @param status the status to pass the method
	 * @param statusCode the code of status to pass to the method
	 * @param timestamp the LocalDateTime to pass to the method
	 */
	public ApiErrors(String error, String message, HttpStatus status, int statusCode, LocalDateTime timestamp) {
		super();
		this.error = error;
		this.message = message;
		this.status = status;
		this.statusCode = statusCode;
		this.timestamp = timestamp;
	}
	/**
	 * @return the error
	 */
	public String getError() {
		return error;
	}
	/**
	 * @param error the error to set
	 */
	public void setError(String error) {
		this.error = error;
	}
	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	/**
	 * @return the status
	 */
	public HttpStatus getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(HttpStatus status) {
		this.status = status;
	}
	/**
	 * @return the statusCode
	 */
	public int getStatusCode() {
		return statusCode;
	}
	/**
	 * @param statusCode the statusCode to set
	 */
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	/**
	 * @return the timestamp
	 */
	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	/**
	 * @param timestamp the timestamp to set
	 */
	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
	
	/**This method prints the object values
	 * @return the ApiErrors Object with the fields given in the toString method
	 */
	@Override
	public String toString() {
		return "ApiErrors [error=" + error + ", message=" + message + ", status=" + status + ", statusCode="
				+ statusCode + ", timestamp=" + timestamp + "]";
	}
	
}
