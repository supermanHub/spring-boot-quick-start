package com.wenbo.archetype.spring_boot_quick_start.web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.wenbo.archetype.spring_boot_quick_start.support.exception.DuplicateException;
import com.wenbo.archetype.spring_boot_quick_start.support.exception.NotFoundException;
import com.wenbo.archetype.spring_boot_quick_start.web.entity.Book;
import com.wenbo.archetype.spring_boot_quick_start.web.repository.BookRepository;
import com.wenbo.archetype.spring_boot_quick_start.web.service.BookService;

/**
 * Book service implementation
 * 
 * @author Wenbo Wang (jackie-1685@163.com)
 */

@Service
public class BookServiceImpl implements BookService {

	private @Autowired BookRepository bookRepository;

	@Override
	@Transactional(readOnly = true)
	public Book getBookByName(String bookName) throws NotFoundException {
		Assert.hasText(bookName, "Book name must not be empty");

		Book book = bookRepository.findByBookName(bookName);

		if (null == book) {
			throw new NotFoundException("Book is not exist");
		}

		return book;
	}

	@Override
	@Transactional
	public Book createBook(String bookName) throws DuplicateException {
		Assert.hasText(bookName, "Book name must not be empty");

		Book book = bookRepository.findByBookName(bookName);
		if (null != book) {
			throw new DuplicateException("Book with the given name is exist");
		}

		book = new Book();
		book.setBookName(bookName);

		return bookRepository.save(book);
	}
}
