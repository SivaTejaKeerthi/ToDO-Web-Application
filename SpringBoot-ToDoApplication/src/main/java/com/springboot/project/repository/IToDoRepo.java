package com.springboot.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.project.entity.ToDoEntity;

@Repository
public interface IToDoRepo extends JpaRepository<ToDoEntity, Long> {

}
