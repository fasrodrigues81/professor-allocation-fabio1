package com.project.professor.allocation.fabio1.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Professor {

	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@Column(name = "name", nullable = false)
	private Long id;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "cpf", length = 11, unique = true, nullable = false)
	private String cpf;

	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@Column(name = "department_Id", nullable = false)
	private Long departmentId;

	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	@ManyToOne(optional = false)
	@JoinColumn(name = "department_Id", updatable = false, insertable = false, nullable = false)
	private Department Depart;

	public Department getDepart() {
		return Depart;
	}

	public void setDepart(Department depart) {
		Depart = depart;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}

	@Override
	public String toString() {
		return "Professor [id=" + id + ", name=" + name + ", cpf=" + cpf + ", departmentId=" + departmentId
				+ ", Depart=" + Depart + ", getId()=" + getId() + ", getName()=" + getName() + ", getCpf()=" + getCpf()
				+ ", getDepartmentId()=" + getDepartmentId() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}

}
