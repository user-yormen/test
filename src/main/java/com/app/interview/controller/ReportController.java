package com.app.interview.controller;

import com.app.interview.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ReportController {

    @Autowired
    BookService bookService;

    @GetMapping("report_by_author/{author}")
    public String reportByAuthor(Model model, @PathVariable String author){
        model.addAttribute("books", bookService.listByAuthor(author));
        return "reports/report_by_author";
    }

    @GetMapping("report_by_genre/{genre}")
    public String reportByGenre(Model model, @PathVariable String genre){
        model.addAttribute("books", bookService.listByAuthor(genre));
        return "reports/report_by_author";
    }

    @GetMapping("report_by_year/{year}")
    public String reportByYear(Model model, @PathVariable String year){
        model.addAttribute("books", bookService.listByAuthor(year));
        return "reports/report_by_author";
    }

}
