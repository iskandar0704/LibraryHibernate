package com.example.dto;

import com.example.enums.StudentBookStatus;

import javax.persistence.*;

@Entity
@Table
public class StudentBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private String id;

    @Column
    private String student_id;

    @Column
    private String book_id;

    @Column
    private String createdDate;

    @Column
    private StudentBookStatus status;

    @Column
    private String returnedDate;

    @Column
    private String duration;

    public StudentBook() {
    }

    @Override
    public String toString() {
        return "StudentBook{" +
                "id='" + id + '\'' +
                ", student_id='" + student_id + '\'' +
                ", book_id='" + book_id + '\'' +
                ", createdDate=" + createdDate +
                ", status=" + status +
                ", returnedDate=" + returnedDate +
                ", duration='" + duration + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

    public String getBook_id() {
        return book_id;
    }

    public void setBook_id(String book_id) {
        this.book_id = book_id;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public StudentBookStatus getStatus() {
        return status;
    }

    public void setStatus(StudentBookStatus status) {
        this.status = status;
    }

    public String getReturnedDate() {
        return returnedDate;
    }

    public void setReturnedDate(String returnedDate) {
        this.returnedDate = returnedDate;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }
}
