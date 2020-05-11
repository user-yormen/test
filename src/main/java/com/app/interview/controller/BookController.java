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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping("/all_books")
    public String allBooks(Model model, @RequestParam(defaultValue = "0") int page){
        model.addAttribute("newbooks", new Book());
        model.addAttribute("books",
                bookService.listPageableBooks(PageRequest.of(page, 10, Sort.Direction.ASC, "title")));
        return "books/books";
    }

    @GetMapping("/create_new_book")
    public String createNewBook(Model model){
        model.addAttribute("newbooks", new Book());
        return "books/create_book";
    }

    @GetMapping("/edit_book/{id}")
    public String editBook(Model model, @PathVariable long id){
        model.addAttribute("editbooks", bookService.findById(id));
        return "create";
    }

    @PostMapping("/save_book")
    public String saveBook(Book book){
        bookService.saveBook(book);
        return "redirect:/all_books";
    }


}
