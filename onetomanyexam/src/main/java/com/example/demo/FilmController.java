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
public class FilmController {
	@Autowired
	private FilmService filmService;
	@GetMapping("/film")
	public Page<Film>getAllFilms(@RequestParam(defaultValue="0")int page,
			@RequestParam(defaultValue="5")int size,
			@RequestParam(defaultValue="id")String sortBy){
		return  filmService.getAllFilms(page, size, sortBy);
	}
	
	@GetMapping("/film/{id}")
	
	public Optional<Film> getFilById(@PathVariable Integer id) {
		return  filmService.getFilmById(id);
		
	}
	@PostMapping("/film")
	public Film create(@RequestBody Film film) {
		return  filmService.create(film);
		
	}
	@PutMapping("/film/{id}")
	public Film update(@RequestBody Film film) {
		return  filmService.update(film);
		
	}
	@DeleteMapping("/film/{id}")
	public void delete(@PathVariable Integer id) {
		 filmService.delete(id);
	}
}
