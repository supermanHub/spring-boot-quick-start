package com.github.supermanhub.spring_boot_quick_start.web.repository;

import com.github.supermanhub.spring_boot_quick_start.support.jpa.CustomJpaRepository;
import com.github.supermanhub.spring_boot_quick_start.web.entity.Author;
import com.github.supermanhub.spring_boot_quick_start.web.entity.Book;
import com.github.supermanhub.spring_boot_quick_start.web.entity.BookAuthor;

/**
 * <b>BookAuthor Repository</b><br>
 * You can use NamedQuery or Query annotation here.<br>
 * 
 * 
 * @author Wenbo Wang (jackie-1685@163.com)
 */
public interface BookAuthorRepository extends CustomJpaRepository<BookAuthor, Long> {

	public BookAuthor findByBookAndAuthor(Book book, Author author);

	public void deleteByAuthor(Author author);

	public void deleteByBook(Book book);
}
