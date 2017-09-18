package com.wenbo.archetype.spring_boot_quick_start.web.repository;


import com.wenbo.archetype.spring_boot_quick_start.support.jpa.CustomJpaRepository;
import com.wenbo.archetype.spring_boot_quick_start.web.entity.Author;
import com.wenbo.archetype.spring_boot_quick_start.web.entity.Book;
import com.wenbo.archetype.spring_boot_quick_start.web.entity.BookAuthor;

/**
 * 
 * @author Wenbo Wang (jackie-1685@163.com)
 */
public interface BookAuthorRepository extends CustomJpaRepository<BookAuthor, Long>{

	public BookAuthor findByBookAndAuthor(Book book, Author author);
	
	public void deleteByAuthor(Author author);
	
	public void deleteByBook(Book book);
}
