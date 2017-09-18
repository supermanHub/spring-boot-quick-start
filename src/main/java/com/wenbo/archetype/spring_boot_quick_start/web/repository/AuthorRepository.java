package com.wenbo.archetype.spring_boot_quick_start.web.repository;

import java.util.Set;

import com.wenbo.archetype.spring_boot_quick_start.support.jpa.CustomJpaRepository;
import com.wenbo.archetype.spring_boot_quick_start.web.entity.Author;

/**
 * <b>Author Repository</b><br>
 * You can use NamedQuery or Query annotation here.
 * 
 * @author Wenbo Wang (jackie-1685@163.com)
 */
public interface AuthorRepository extends CustomJpaRepository<Author, Long> {

	public Author findByAuthorName(String authorName);

	public Set<Author> findByAuthorBooks_Book_Id(Long bookId);
}
