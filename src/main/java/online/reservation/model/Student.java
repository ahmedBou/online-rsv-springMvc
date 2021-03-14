package online.reservation.model;

import lombok.extern.slf4j.Slf4j;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Slf4j
@Entity
@Table(name="student")
public class Student {
    @Id
    @GeneratedValue
    @Column(name = "studentId")
    private Long id;

    private String name;
    private String email;
    private String pswd;

    // Constructors, Getters and Setters

    public Student() {
    }

    public Student(String name, String email) {
        super();
        this.name = name;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPswd() {
        return pswd;
    }

    public void setPswd(String pswd) {
        this.pswd = pswd;
    }
}
