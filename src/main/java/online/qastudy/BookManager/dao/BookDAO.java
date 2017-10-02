package online.qastudy.BookManager.dao;

import online.qastudy.BookManager.model.Book;

import java.util.List;

public interface BookDAO {
    void addBook(Book book);

    void updateBook(Book book);

    void removeBook(int id);

    Book getBookById(int id);

    List<Book> listBooks();
}
