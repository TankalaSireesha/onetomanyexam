package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
public class Actor {
		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		
		private Integer id;
		private String name;
		
		@OneToMany(mappedBy="actor",cascade=CascadeType.ALL)
		private List<Film>film=new ArrayList<Film>();

		public Actor(Integer id, String name, List<Film> film) {
			super();
			this.id = id;
			this.name = name;
			this.film = film;
		}
		public Actor() {
			
		}
		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public List<Film> getFilm() {
			return film;
		}

		public void setFilm(List<Film> film) {
			this.film = film;
		}
		
		
}

