package com.github.supermanhub.spring_boot_quick_start.web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.github.supermanhub.spring_boot_quick_start.support.constant.MessageCode;
import com.github.supermanhub.spring_boot_quick_start.support.exception.DuplicateException;
import com.github.supermanhub.spring_boot_quick_start.support.exception.NotFoundException;
import com.github.supermanhub.spring_boot_quick_start.web.entity.Author;
import com.github.supermanhub.spring_boot_quick_start.web.entity.Book;
import com.github.supermanhub.spring_boot_quick_start.web.entity.BookAuthor;
import com.github.supermanhub.spring_boot_quick_start.web.repository.AuthorRepository;
import com.github.supermanhub.spring_boot_quick_start.web.repository.BookAuthorRepository;
import com.github.supermanhub.spring_boot_quick_start.web.repository.BookRepository;
import com.github.supermanhub.spring_boot_quick_start.web.service.AuthorService;

/**
 * Author service implementation
 * 
 * @author Wenbo Wang (jackie-1685@163.com)
 */

@Service
@Transactional(readOnly = true)
public class AuthorServiceImpl implements AuthorService {
	private @Autowired AuthorRepository authorRepository;
	private @Autowired BookRepository bookRepository;
	private @Autowired BookAuthorRepository bookAuthorRepository;

	@Override
	public Author getAuthor(Long authorId) throws NotFoundException {
		Assert.notNull(authorId, "Author ID must not be null");

		Author author = authorRepository.findOne(authorId);
		if (null == author) {
			throw new NotFoundException(MessageCode.AUTHOR_NOT_FOUND);
		}

		return author;
	}

	@Override
	@Transactional
	public Author createAuthor(String authorName) throws DuplicateException {
		Assert.hasText(authorName, "Author name must not be empty");

		Author author = authorRepository.findByAuthorName(authorName);
		if (null != author) {
			throw new DuplicateException(MessageCode.AUTHOR_DUPLICATE);
		}

		author = new Author();
		author.setAuthorName(authorName);

		return authorRepository.save(author);
	}

	@Override
	@Transactional
	public void deleteAuthor(Long authorId) throws NotFoundException {
		Assert.notNull(authorId, "Author ID must not be null");

		Author author = authorRepository.findOne(authorId);
		if (null == author) {
			throw new NotFoundException(MessageCode.AUTHOR_NOT_FOUND);
		}

		bookAuthorRepository.deleteByAuthor(author);
		authorRepository.delete(author);
	}

	@Override
	@Transactional
	public Author assignBook(Long authorId, Long bookId) throws NotFoundException {
		Assert.notNull(authorId, "Author ID must not be null");
		Assert.notNull(bookId, "Book ID must not be null");

		Author author = authorRepository.findOne(authorId);
		if (null == author) {
			throw new NotFoundException(MessageCode.AUTHOR_NOT_FOUND);
		}

		Book book = bookRepository.findOne(bookId);
		if (null == book) {
			throw new NotFoundException(MessageCode.BOOK_NOT_FOUND);
		}

		BookAuthor bookAuthor = bookAuthorRepository.findByBookAndAuthor(book, author);
		if (null == bookAuthor) {
			bookAuthor = new BookAuthor();
			bookAuthor.setAuthor(author);
			bookAuthor.setBook(book);
			bookAuthorRepository.save(bookAuthor);
		}

		return bookAuthor.getAuthor();
	}

}
