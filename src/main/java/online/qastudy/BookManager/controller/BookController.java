package online.qastudy.BookManager.controller;

import online.qastudy.BookManager.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class BookController {
    private BookService bookService;

    @Autowired(required = true)
    @Qualifier(value = "bookservice")
    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }

    
}
