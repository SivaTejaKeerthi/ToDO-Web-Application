package com.springboot.project.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springboot.project.entity.ToDoEntity;

@Service
public interface IToDoService {
	
	public List<ToDoEntity> getAllToDoItems();
	
	public ToDoEntity getToDoItemById(Long toDoId);
	
	public boolean updateStatus(Long toDoId);
	
	public boolean saveOrUpdateToDoItems(ToDoEntity toDoEntity);
	
	public boolean deleteToDoItem(Long toDoId);
}
