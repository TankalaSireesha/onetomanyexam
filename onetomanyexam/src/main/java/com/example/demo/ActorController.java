package com.example.demo;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ActorController {
	@Autowired
	private ActorSevice actorService;
	@GetMapping("/actor")
	public Page<Actor>getAllActors(@RequestParam(defaultValue="0")int page,
			@RequestParam(defaultValue="5")int size,
			@RequestParam(defaultValue="id")String sortBy){
		return actorService.getAllActors(page, size, sortBy);
	}
	
	@GetMapping("/actor/{id}")
	
	public Optional<Actor> getActorById(@PathVariable Integer id) {
		return actorService.getActorById(id);
		
	}
	@PostMapping("/actor")
	public Actor create(@RequestBody Actor actor) {
		return actorService.create(actor);
		
	}
	@PutMapping("/actor/{id}")
	public Actor update(@RequestBody Actor actor) {
		return actorService.update(actor);
		
	}
	@DeleteMapping("/actor/{id}")
	public void delete(@PathVariable Integer id) {
		actorService.delete(id);
	}
}
