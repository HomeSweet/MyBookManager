package online.qastudy.bookmanager.dao;

import online.qastudy.bookmanager.model.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class BookDAOImpl implements BookDAO {

    private static final Logger logger = LoggerFactory.getLogger(BookDAOImpl.class);

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private SessionFactory sessionFactory;

    @Override
    public void addBook(Book book) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(book);
        logger.info("Book was saved successfully: " + book.toString());
    }

    @Override
    public void updateBook(Book book) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(book);
        logger.info("Book was updated successfully: " + book.toString());
    }

    @Override
    public void removeBook(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Book deletedBook = (Book) session.load(Book.class, new Integer(id));
        if (deletedBook != null) {

            session.delete(deletedBook);

        }
        logger.info("Book was deleted successfully: " + deletedBook.toString());
    }

    @Override
    public Book getBookById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Book book = (Book) session.load(Book.class, new Integer(id));
        logger.info("Book successfully loaded: " + book.toString());
        return book;
    }

    @Override
    public List<Book> listBooks() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Book> booksList = session.createQuery("from Book").list();
        for (Book book : booksList) {
            logger.info("Book list " + book.toString());
        }
        return booksList;
    }
}
