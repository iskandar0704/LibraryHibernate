package com.example.repository;

import com.example.config.HibernateConfig;
import com.example.dto.Student;
import com.example.dto.StudentBook;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

@Repository
public class StudentBookRepository {
    private SessionFactory sessionFactory = HibernateConfig.getSessionFactory();

    public void addStudentBook(StudentBook studentBook){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.save(studentBook);

        transaction.commit();
        session.close();
    }

    public List<StudentBook> getStudentBookList(){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Query query =  session.createQuery("From StudentBook ");
        List<StudentBook> studentBookList = query.getResultList();

        transaction.commit();
        session.close();

        return studentBookList;
    }

    public StudentBook getStudentBookById(String id){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery("From StudentBook ");
        List<StudentBook> studentBookList = query.getResultList();

        for (StudentBook s: studentBookList){
            if(s.getId().equals(id)){
                return s;
            }
        }

        transaction.commit();
        session.close();

        return null;
    }

    public void deleteStudentBookById(String id){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery("Delete From StudentBook Where id ="+id);
        query.executeUpdate();

        transaction.commit();
        session.close();
    }

    public void updateStudentBookById(String id,StudentBook studentBook){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        String sql = "Update StudentBook Set student_id= '%s', book_id = '%s', createdDate = '%s' , status = '%s', returnedDate = '%s', duration = '%s' where  id = "+id;
        sql =  String.format(sql,studentBook.getStudent_id(),studentBook.getBook_id(),studentBook.getCreatedDate(),studentBook.getStatus(),studentBook.getReturnedDate(),studentBook.getDuration());

        Query query = session.createQuery(sql);
        query.executeUpdate();

        transaction.commit();
        session.close();
    }
    
}
