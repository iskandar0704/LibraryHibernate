package com.example.repository;

import com.example.config.HibernateConfig;
import com.example.dto.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

@Repository
public class StudentRepository {
    @Autowired
    private SessionFactory sessionFactory;

    public void addStudent(Student student){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.save(student);

        transaction.commit();
        session.close();
    }

    public List<Student> getStudentList(){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Query query =  session.createQuery("From Student");
        List<Student> studentList = query.getResultList();

        transaction.commit();
        session.close();

        return studentList;
    }

    public Student getStudentById(String id){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery("From Student ");
        List<Student> studentList = query.getResultList();

        for (Student s: studentList){
            if(s.getId().equals(id)){
                return s;
            }
        }

        transaction.commit();
        session.close();

        return null;
    }

    public void deleteStudentById(String id){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery("Delete From Student Where id ="+id);
        query.executeUpdate();

        transaction.commit();
        session.close();
    }

    public void updateStudentById(String id,Student student){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        String sql = "Update Student Set name= '%s', surname = '%s', phone = '%s' , createdDate = '%s' where  id = "+id;
        sql =  String.format(sql,student.getName(),student.getSurname(),student.getPhone(),student.getCreatedDate());

        Query query = session.createQuery(sql);
        query.executeUpdate();

        transaction.commit();
        session.close();
    }

}
