package iva.cruddwebapp.model;


import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Date;

/**
 * Created by Admin on 01.04.15.
 */
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Pattern(regexp = "[A-Za-z]+\\s?[A-Za-z]*")
    @NotNull
    @NotEmpty
    @Size(min = 2, max = 25)
    private String name;


    @Column(name = "age")
    @NotNull
    @Min(1)
    @Max(130)
    private Integer age;

    @Column(name = "isAdmin")
    @NotNull
    private Boolean isAdmin;

    @Column(name = "createdDate")
    private Date createdDate = new Date();

    public User() {
    }

    public User(String name, Integer age, Boolean isAdmin) {
        super();
        this.name = name;
        this.age = age;
        this.isAdmin = isAdmin;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Boolean getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(Boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}
