package com.springboot.project.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.project.entity.ToDoEntity;
import com.springboot.project.repository.IToDoRepo;
import com.springboot.project.service.IToDoService;

@Service
public class ToDoServiceImpl implements IToDoService{
	
	@Autowired
	IToDoRepo toDoRepo;
	
	@Override
	public List<ToDoEntity> getAllToDoItems() {
		
		ArrayList<ToDoEntity> todoList = new ArrayList<ToDoEntity>();
		
		toDoRepo.findAll().forEach(todo -> todoList.add(todo));
		return todoList;
	}

	@Override
	public ToDoEntity getToDoItemById(Long toDoId) {
		return toDoRepo.findById(toDoId).get();
	}

	@Override
	public boolean updateStatus(Long toDoId) {
		ToDoEntity todoEntity = getToDoItemById(toDoId);
		todoEntity.setTodoEntityStatus("Completed");
		return saveOrUpdateToDoItems(todoEntity);
	}

	@Override
	public boolean saveOrUpdateToDoItems(ToDoEntity toDoEntity) {
		
		ToDoEntity updatedentity = toDoRepo.save(toDoEntity);
		
		if(getToDoItemById(updatedentity.getToDoEntityId()) != null) {
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteToDoItem(Long toDoId) {
		toDoRepo.deleteById(toDoId);
		
		if(toDoRepo.findById(toDoId).isEmpty()){
			return true;
		}
		
		return false;
	}



}
