package com.app.interview.controller;

import com.app.interview.domain.Book;
import com.app.interview.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SearchController {

    @Autowired
    BookService bookService;

    @GetMapping("/")
    public String search(Model model, @RequestParam(defaultValue = "0") int page){
        model.addAttribute("searchBook", new Book());

        model.addAttribute("books", bookService.listPageableBooks(PageRequest.of(page, 10)));
//        model.addAttribute("books", bookService.listPageableBooks(PageRequest.of(page, 10, Sort.Direction.ASC, "title")));
        return "search/search";
    }

    @GetMapping("/search")
    public String searchBooks(Model model, @RequestParam(defaultValue = "0") int page, Book book){
        model.addAttribute("searchBook", book);
        model.addAttribute("books", bookService.
                searchBook(book.getIsbn(), book.getTitle(), PageRequest.of(page, 10)));
        return "search/search";
    }

    @GetMapping("/search/{bookSearch}")
    public String boobDetails(Model model, @PathVariable String bookSearch){
        model.addAttribute("books", new Book());
        return "search/search_book";
    }
}
