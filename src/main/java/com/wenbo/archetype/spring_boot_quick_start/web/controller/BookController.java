package com.wenbo.archetype.spring_boot_quick_start.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wenbo.archetype.spring_boot_quick_start.support.exception.DuplicateException;
import com.wenbo.archetype.spring_boot_quick_start.support.exception.NotFoundException;
import com.wenbo.archetype.spring_boot_quick_start.web.entity.Book;
import com.wenbo.archetype.spring_boot_quick_start.web.service.BookService;

/**
 * Rest Controller of Book requests
 * 
 * @author Wenbo Wang (jackie-1685@163.com)
 */

@RestController
@RequestMapping("/book")
public class BookController {

	private @Autowired BookService bookService;

	@RequestMapping(path = "/{bookName}", method = RequestMethod.GET)
	public Book getBook(@PathVariable String bookName) {

		Book book = null;

		try {
			book = bookService.getBookByName(bookName);

		} catch (NotFoundException e) {
			System.err.println(e.getMessage());
		}

		return book;
	}

	@RequestMapping(method = RequestMethod.POST)
	public Book createBook(String bookName) {

		Book book = null;

		try {
			book = bookService.createBook(bookName);

		} catch (DuplicateException e) {
			System.err.println(e.getMessage());
		}

		return book;
	}
}
