package com.app.interview.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Book {
	
	@Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private long id;
	
	private String title;
	
	private String authors;
	
	private String year;
	
	private String isbn;
	
	private String genres;

}
