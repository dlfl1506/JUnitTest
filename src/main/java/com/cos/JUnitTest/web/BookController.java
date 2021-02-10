package com.cos.JUnitTest.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cos.JUnitTest.domain.Book;
import com.cos.JUnitTest.domain.BookRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class BookController {

	private final BookRepository bookRepository;
	
	@PostMapping("/book")
	public ResponseEntity<?> save(@RequestBody Book book){
		return new ResponseEntity<>(bookRepository.save(book),HttpStatus.CREATED);
	}
	
	@GetMapping("/book")
	public ResponseEntity<?> findAll(){
		return new ResponseEntity<>(bookRepository.findAll(),HttpStatus.OK);
	}
	
	@GetMapping("/book/{id}")
	public ResponseEntity<?> findById(@PathVariable int id){
		return new ResponseEntity<>(bookRepository.findById(id)
				.orElseThrow(()->new IllegalArgumentException("id를 확인해주세요 !!")),HttpStatus.OK);
	}
	
	@DeleteMapping("/book/{id}")
	public String deleteById(@PathVariable int id){
		bookRepository.deleteById(id); 
		return "ok";
	}
	
}
