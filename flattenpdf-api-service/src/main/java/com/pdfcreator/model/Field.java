package com.pdfcreator.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author BabaFakruddinDharubai
 *
 */
@Entity
public class Field {
	@Id
	@GeneratedValue
	@JsonIgnore
	private Integer fieldid;
	@Column(length = 20)
	private String fieldname;
	@Transient
	private String value;

	/**
	 * 
	 */
	public Field() {
		super();
	}
	
	/**
	 * @param fieldname to pass the fieldname to the constructor
	 */
	public Field(String fieldname) {
	super();
	this.fieldname = fieldname;
}

	/**
	 * @param fieldid to pass the fieldid to the constructor
	 * @param fieldname to pass the fieldname to the constructor
	 */
	public Field(Integer fieldid, String fieldname) {
		super();
		this.fieldid = fieldid;
		this.fieldname = fieldname;
	}

	
	/**
	 * @param fieldid to pass fieldid to the constructor
	 * @param fieldname to pass the fieldname to the constructor
	 * @param value to pass the value to the constructor
	 */
	public Field(Integer fieldid, String fieldname, String value) {
		super();
		this.fieldid = fieldid;
		this.fieldname = fieldname;
		this.value = value;
	}

	/**
	 * @return the fieldid
	 */
	public Integer getFieldid() {
		return fieldid;
	}

	/**
	 * @param fieldid the fieldid to set
	 */
	public void setFieldid(Integer fieldid) {
		this.fieldid = fieldid;
	}

	/**
	 * @return the fieldname
	 */
	public String getFieldname() {
		return fieldname;
	}

	/**
	 * @param fieldname the fieldname to set
	 */
	public void setFieldname(String fieldname) {
		this.fieldname = fieldname;
	}

	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}

	/**
	 * @return
	 */
	@Override
	public String toString() {
		return "Field [fieldname=" + fieldname + "]";
	}
	
}
