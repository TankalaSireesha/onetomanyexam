package com.example.demo;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class ActorSevice {
		@Autowired
		private ActorRepository actorRepository;
		
		public Page<Actor>getAllActors(int page,int size,String sortBy){
			PageRequest pageable=PageRequest.of(page, size, Sort.by(sortBy));
			return actorRepository.findAll(pageable);
		}
		public Optional<Actor> getActorById(Integer id) {
			return actorRepository.findById(id);
		}
		public Actor create(Actor actor) {
			return actorRepository.save(actor);
		}
		public Actor update(Actor actor) {
			return actorRepository.save(actor);
		}
		public void delete(Integer id) {
			actorRepository.deleteById(id);
		}
}
