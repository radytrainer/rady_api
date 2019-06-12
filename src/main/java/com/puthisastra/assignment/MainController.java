package com.puthisastra.assignment;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
public class MainController {
	
	private BookRepository bookRepository;
	
	@GetMapping
	@ResponseBody
	public List<Book> getAllBooks() {
		return bookRepository.findAll();
	}
	
	@GetMapping("/create")
	@ResponseBody
	public Book createBook() {
		Book book = new Book();
		book.setTitle("Napoleon");
		book.setPages(1);
		return bookRepository.save(book);
	}
	
	@GetMapping("/getBookById")
	@ResponseBody
	public Optional<Book> getBookById() {
		return bookRepository.findById(1L);
	}
	
	@GetMapping("/update")
	@ResponseBody
	public List<Book> updateBookById() {
		bookRepository.setBook("Bookingstory", 1L);
		return bookRepository.findAll();
	}
	
	@GetMapping("/delete")
	@ResponseBody
	public List<Book> deleteBookById() {
		bookRepository.deleteById(1L);
		return bookRepository.findAll();
	}

	
}
