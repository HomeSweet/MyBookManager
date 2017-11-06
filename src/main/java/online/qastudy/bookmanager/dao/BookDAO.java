package online.qastudy.bookmanager.dao;

import online.qastudy.bookmanager.model.Book;

import java.util.List;

public interface BookDAO {
    void addBook(Book book);

    void updateBook(Book book);

    void removeBook(int id);

    Book getBookById(int id);

    List<Book> listBooks();
}
