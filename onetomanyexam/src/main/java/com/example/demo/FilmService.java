package com.example.demo;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class FilmService {
	@Autowired
	private FilmRepository filmRepository;
	
	public Page<Film>getAllFilms(int page,int size,String sortBy){
		PageRequest pageable=PageRequest.of(page, size, Sort.by(sortBy));
		return filmRepository.findAll(pageable);
	}
	public Optional<Film> getFilmById(Integer id) {
		return filmRepository.findById(id);
	}
	public Film create(Film film) {
		return filmRepository.save(film);
	}
	public Film update(Film film) {
		return filmRepository.save(film);
	}
	public void delete(Integer id) {
		filmRepository.deleteById(id);
	}
}
