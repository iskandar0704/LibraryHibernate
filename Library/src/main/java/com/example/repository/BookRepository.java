package com.example.repository;

import com.example.config.HibernateConfig;
import com.example.dto.Book;
import com.example.exception.BookCreationException;
import com.example.exception.ItemNotFoundException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.persistence.Query;
import java.util.List;
import java.util.UUID;

@Repository
public class BookRepository {
    private SessionFactory sessionFactory = HibernateConfig.getSessionFactory();

    public void addBook(Book book){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();


        if(book.getTitle() == null || book.getTitle().isBlank() || book.getTitle().length() <= 3){
            throw new BookCreationException("Title required!");
        }

        if(book.getAuthor() == null || book.getAuthor().isBlank() || book.getAuthor().length() <= 3){
            throw new BookCreationException("Author required!");
        }


        book.setId(UUID.randomUUID().toString());
        session.save(book);

        transaction.commit();
        session.close();
    }

    public List<Book> getBookList(){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Query query =  session.createQuery("From Book");
        List<Book> bookList = query.getResultList();

        transaction.commit();
        session.close();

        return bookList;
    }

    public Book getBookById(String id){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery("From Book");
        List<Book> bookList = query.getResultList();

        Book b = new Book();

        for (Book bo: bookList){
            if(b.getId().equals(id)){
                 b = bo;
            }
        }

        if(b == null){
            throw new ItemNotFoundException("Book not found!");
        }

        transaction.commit();
        session.close();

        return b;
    }

    public void deleteBookById(String id){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        getBookById(id);

        Query query = session.createQuery("Delete From Book Where id ="+id);
        query.executeUpdate();

        transaction.commit();
        session.close();
    }

    public void updateBookById(String id,Book book){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        String sql = "Update Book Set title= '%s', author = '%s', publishYear = '%s' where id = "+id;
        sql =  String.format(sql,book.getTitle(),book.getAuthor(),book.getPublishYear());

        Query query = session.createQuery(sql);
        query.executeUpdate();

        transaction.commit();
        session.close();
    }

}
