package com.app.interview.service;

import com.app.interview.domain.Book;
import com.app.interview.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;

    public Page<Book> listPageableBooks(Pageable pageable){
        return bookRepository.findAll(pageable);
    }

    public Book findById(long id){
        return bookRepository.findById(id).get();
    }

    public Page<Book> searchBook(String isbn, String title, Pageable pageable){
        return bookRepository.findAllByIsbnLikeAndTitleLike(isbn, title, pageable);
    }

    public Book saveBook(Book book){
        return bookRepository.save(book);
    }

    public List<Book> listByAuthor(String author){
        return bookRepository.findAllByAuthors(author).get();
    }

    public List<Book> listByGenre(String genre){
        return bookRepository.findAllByAuthors(genre).get();
    }
    public List<Book> listByYear(String year){
        return bookRepository.findAllByAuthors(year).get();
    }
}
