package com.app.interview.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.app.interview.domain.Book;

@Repository
//public interface BookRepository extends JpaRepository<Book, Long> {
public interface BookRepository extends PagingAndSortingRepository<Book, Long> {

	Optional<List<Book>> findAllByAuthors(String author);

	Optional<List<Book>> findAllByYear(String year);

	Optional<List<Book>> findAllByGenres(String genres);

	List<Book> findAllByIsbnLikeAndTitleLike(String isbn, String title);

	Page<Book> findAllByIsbnLikeAndTitleLike(String isbn, String title, Pageable pageable);
}
