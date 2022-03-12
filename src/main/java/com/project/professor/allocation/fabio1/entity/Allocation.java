package com.project.professor.allocation.fabio1.entity;

import java.time.DayOfWeek;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.deser.std.DateDeserializers;
import com.fasterxml.jackson.databind.ser.std.DateSerializer;

import io.swagger.annotations.ApiModelProperty;

@Entity
public class Allocation {

	@JsonProperty(access = Access.READ_ONLY)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private Long id;

	@Enumerated(EnumType.STRING)
	@Column(name = "day", nullable = false)
	private DayOfWeek day;

	@ApiModelProperty(example = "10:00-0300")
	@JsonFormat(pattern = "HH:mmZ")
	@JsonSerialize(using = DateSerializer.class)
    @JsonDeserialize(using = DateDeserializers.DateDeserializer.class)
	@Column(name = "start", nullable = false)
	@Temporal(TemporalType.TIME)
	private Date start;

	@ApiModelProperty(example = "12:00-0300")
	@JsonFormat(pattern = "HH:mmZ")
    @JsonSerialize(using = DateSerializer.class)
    @JsonDeserialize(using = DateDeserializers.DateDeserializer.class)
	@Column(name = "end", nullable = false)
	@Temporal(TemporalType.TIME)
	private Date end;

	@JsonProperty(access = Access.WRITE_ONLY)
	@Column(name = "course_Id", nullable = false)
	private Long courseId;

	@JsonProperty(access = Access.READ_ONLY)
	@ManyToOne(optional = false)
	@JoinColumn(name = "course_Id", updatable = false, insertable = false, nullable = false)
	private Course cour;

	@JsonProperty(access = Access.WRITE_ONLY)
	@Column(name = "professor_Id", nullable = false)
	private Long professorId;

	@JsonProperty(access = Access.READ_ONLY)
	@ManyToOne(optional = false)
	@JoinColumn(name = "professor_Id", updatable = false, insertable = false, nullable = false)
	private Professor prof;

	public Course getCour() {
		return cour;
	}

	public void setCour(Course cour) {
		this.cour = cour;
	}

	public Professor getProf() {
		return prof;
	}

	public void setProf(Professor prof) {
		this.prof = prof;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public DayOfWeek getDay() {
		return day;
	}

	public void setDay(DayOfWeek day) {
		this.day = day;
	}

	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public Date getEnd() {
		return end;
	}

	public void setEnd(Date end) {
		this.end = end;
	}

	public Long getCourseId() {
		return courseId;
	}

	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}

	public Long getProfessorId() {
		return professorId;
	}

	public void setProfessorId(Long professorId) {
		this.professorId = professorId;
	}

	@Override
	public String toString() {
		return "Allocation [id=" + id + ", day=" + day + ", start=" + start + ", end=" + end + ", courseId=" + courseId
				+ ", Cour=" + cour + ", professorId=" + professorId + ", Prof=" + prof + ", getId()=" + getId()
				+ ", getDay()=" + getDay() + ", getStart()=" + getStart() + ", getEnd()=" + getEnd()
				+ ", getCourseId()=" + getCourseId() + ", getProfessorId()=" + getProfessorId() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

}
