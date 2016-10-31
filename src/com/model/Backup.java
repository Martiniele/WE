package com.model;

/**
 * Backup entity. @author MyEclipse Persistence Tools
 */

public class Backup implements java.io.Serializable {

	// Fields
	private Integer id;
	private String name;
	private String filepath;

	// Constructors

	/** default constructor */
	public Backup() {
	}

	/** minimal constructor */
	public Backup(String name) {
		this.name = name;
	}

	/** full constructor */
	public Backup(String name, String filepath) {
		this.name = name;
		this.filepath = filepath;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFilepath() {
		return this.filepath;
	}

	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}
}