package com.springboot.project.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name="ToDo")
@Entity
public class ToDoEntity {

	@Id
	@Column(name="Id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long toDoEntityId;
	
	@Column(name="Title")
	@Nonnull
	private String toDoEntityTitle;
	
	@Column(name="Date")
	@Nonnull
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date todoEntityDate;
	
	@Column(name="Status")
	@Nonnull
	private String todoEntityStatus;
	
	public ToDoEntity() {
	}

	public Long getToDoEntityId() {
		return toDoEntityId;
	}

	public void setToDoEntityId(Long toDoEntityId) {
		this.toDoEntityId = toDoEntityId;
	}

	public String getToDoEntityTitle() {
		return toDoEntityTitle;
	}

	public void setToDoEntityTitle(String toDoEntityTitle) {
		this.toDoEntityTitle = toDoEntityTitle;
	}

	public Date getTodoEntityDate() {
		return todoEntityDate;
	}

	public void setTodoEntityDate(Date todoEntityDate) {
		this.todoEntityDate = todoEntityDate;
	}

	public String getTodoEntityStatus() {
		return todoEntityStatus;
	}

	public void setTodoEntityStatus(String todoEntityStatus) {
		this.todoEntityStatus = todoEntityStatus;
	}
	
	
}
