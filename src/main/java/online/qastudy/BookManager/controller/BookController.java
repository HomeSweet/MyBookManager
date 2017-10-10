package online.qastudy.BookManager.controller;

import online.qastudy.BookManager.model.Book;
import online.qastudy.BookManager.service.impl.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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

    
}
