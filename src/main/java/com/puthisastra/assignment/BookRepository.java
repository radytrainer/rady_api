package com.puthisastra.assignment;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface BookRepository extends JpaRepository<Book, Long> {

	@Modifying
	@Transactional
	@Query("update Book a set a.title= ?1 where a.id= ?2 ")
	int setBook(String title, Long Id);
	
	@Modifying
	@Transactional
	@Query("delete Book a where a.Id= ?1")
	void deleteById(Long Id);


}
