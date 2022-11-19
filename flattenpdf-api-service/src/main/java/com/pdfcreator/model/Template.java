package com.pdfcreator.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author BabaFakruddinDharubai
 *
 */
@Entity
public class Template {
	@Id
	@GeneratedValue(generator = "template_seq", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "template_seq",sequenceName = "template_sequence",initialValue = 100,allocationSize = 1)
	@JsonIgnore
	private Integer templateid;
	@Column(length = 20)
	private String templatename;
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name = "template_id")
	private List<Field> fields;
	@Column(length=20)
	@JsonIgnore
	private String path;
	
	/**
	 * 
	 */
	public Template() {
		super();
	}
	
	/**
	 * @param templatename to pass name to the constructor
	 * @param fields list of fileds to send to the specific template
	 */
	public Template(String templatename, List<Field> fields,String path) {
		super();
		this.templatename = templatename;
		this.fields = fields;
		this.path=path;
	}

	/**
	 * @param templateid to pass templateid to the constructor
	 * @param templatename to pass templatename to the constructor
	 * @param fields  to pass list of fields to the constructor
	 * @param path a defined path of file location is passed to the constructor
	 */
	public Template(Integer templateid, String templatename, List<Field> fields, String path) {
		super();
		this.templateid = templateid;
		this.templatename = templatename;
		this.fields = fields;
		this.path = path;
	}

	/**
	 * @return the templateid
	 */
	public Integer getTemplateid() {
		return templateid;
	}

	/**
	 * @param templateid the templateid to set
	 */
	public void setTemplateid(Integer templateid) {
		this.templateid = templateid;
	}

	/**
	 * @return the templatename
	 */
	public String getTemplatename() {
		return templatename;
	}

	/**
	 * @param templatename the templatename to set
	 */
	public void setTemplatename(String templatename) {
		this.templatename = templatename;
	}

	/**
	 * @return the fields
	 */
	public List<Field> getFields() {
		return fields;
	}

	/**
	 * @param fields the fields to set
	 */
	public void setFields(List<Field> fields) {
		this.fields = fields;
	}

	/**
	 * @return the path
	 */
	public String getPath() {
		return path;
	}

	/**
	 * @param path the path to set
	 */
	public void setPath(String path) {
		this.path = path;
	}

	/**
	 * @return a template with the values
	 */
	@Override
	public String toString() {
		return "Template [templatename=" + templatename + ", fields=" + fields + ", path=" + path + "]";
	}

	
	
}
