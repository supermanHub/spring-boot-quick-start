package com.wenbo.archetype.spring_boot_quick_start.web.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.wenbo.archetype.spring_boot_quick_start.web.entity.Book;

/**
 * 
 * @author Wenbo Wang (jackie-1685@163.com)
 */
public interface BookRepository extends PagingAndSortingRepository<Book, Long> {

	public Book findByBookName(String bookName);
}
