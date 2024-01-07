package com.springboot.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.springboot.project.entity.ToDoEntity;
import com.springboot.project.service.IToDoService;

@Controller
public class ToDoController {

	@Autowired
	private IToDoService toDoService;

	@GetMapping({"/", "viewToDoItems"})
	public String viewAllToDoItems(Model model, @ModelAttribute("message") String message) {
		model.addAttribute("list", toDoService.getAllToDoItems());
		model.addAttribute("message", message);

		return "ViewToDoItem";
	}

	@GetMapping("/updateToDoStatus/{toDoEntityId}")
	public String updateStatus(@PathVariable Long toDoEntityId, RedirectAttributes redirectAttributes) {
		if(toDoService.updateStatus(toDoEntityId)) {
			redirectAttributes.addFlashAttribute("message", "update successful");
			return "redirect:/viewToDoItems";
		}
		redirectAttributes.addFlashAttribute("message", "update failure");
		return "redirect:/viewToDoItems";
	}

	@GetMapping("/addToDoItem")
	public String addToDoItem(Model model) {
		model.addAttribute("todo", new ToDoEntity());
		return "AddToDoItem";
	}

	@PostMapping("/saveToDoItem")
	public String saveToDoItems(ToDoEntity todoEntity, RedirectAttributes redirectAttributes) {
		if(toDoService.saveOrUpdateToDoItems(todoEntity)) {
			redirectAttributes.addFlashAttribute("message", "save is successful");
			return "redirect:/viewToDoItems";
		}
		redirectAttributes.addFlashAttribute("message", "save is failure");
		return "redirect:/addToDoItem";
	}

	@GetMapping("/editToDoItem/{toDoEntityId}")
	public String editToDoItem(@PathVariable Long toDoEntityId, Model model) {
		model.addAttribute("todo",toDoService.getToDoItemById(toDoEntityId));
		return "EditToDoItem";
	}

	@PostMapping("/saveEditToDoItem")
	public String saveEditToDoItem(ToDoEntity todo, RedirectAttributes redirectAttributes) {
		if(toDoService.saveOrUpdateToDoItems(todo)) {
			redirectAttributes.addFlashAttribute("message", "successfully saved the edit");
			return "redirect:/viewToDoItems";
		}
		redirectAttributes.addFlashAttribute("message", " failed to saved the edit");
		return "redirect:/editToDoItems"+ todo.getToDoEntityId();
	}


	@GetMapping("/deleteToDoItem/{toDoEntityId}")
	public String deleteToDoItem(@PathVariable Long toDoEntityId, RedirectAttributes redirectAttributes) {
		if(toDoService.deleteToDoItem(toDoEntityId)) {
			redirectAttributes.addFlashAttribute("message", "delete is successful");
			return "redirect:/viewToDoItems";
		}
		
		redirectAttributes.addFlashAttribute("message", "delete is failure");
		
		return "redirect:/viewToDoItems";
	}

}
