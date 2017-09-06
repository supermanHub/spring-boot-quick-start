package com.wenbo.archetype.spring_boot_quick_start.web.service;

import com.wenbo.archetype.spring_boot_quick_start.support.exception.DuplicateException;
import com.wenbo.archetype.spring_boot_quick_start.support.exception.NotFoundException;
import com.wenbo.archetype.spring_boot_quick_start.web.entity.Book;
import com.wenbo.archetype.spring_boot_quick_start.web.service.impl.BookServiceImpl;

/**
 * Book service Implementation refer to {@link BookServiceImpl}
 * 
 * @author Wenbo Wang (jackie-1685@163.com)
 */
public interface BookService {

	/**
	 * Get book by book name
	 * 
	 * @param bookName
	 *            String required
	 * 
	 */
	public Book getBookByName(String bookName) throws NotFoundException;

	/**
	 * Create a book
	 * 
	 * @param bookName
	 *            String required
	 * 
	 */
	public Book createBook(String bookName) throws DuplicateException;
}
