package online.qastudy.BookManager.controller;

import online.qastudy.BookManager.model.Book;
import online.qastudy.BookManager.service.impl.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
import online.qastudy.BookManager.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class BookController {
    private BookServiceImpl bookService;

    @Autowired(required = true)
    @Qualifier(value = "bookService")
    public void setBookService(BookServiceImpl bookService) {
        this.bookService = bookService;
    }

    @RequestMapping
    public String listBooks(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("listBooks", this.bookService.listBooks());

        return "books";
    }


    private BookService bookService;

    @Autowired(required = true)
    @Qualifier(value = "bookservice")
    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }


}
