package com.performance.testing.performance.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

@Table(name = "accounts")
@Data
@Entity
@AllArgsConstructor
public class Accounts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String fullName;
    private String name;
    private String email;
    private Date birthDate;

    @Enumerated(EnumType.STRING)
    private Country country;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id", nullable = false)
    private Roles role;

    @OneToMany(mappedBy = "", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Set<Courses> createdCourses;

    public Accounts() {
    }

    public Accounts(long id, String fullName) {
        this.id = id;
        this.fullName = fullName;
    }

    public Accounts(long id, String fullName, String name, String email) {
        this.id = id;
        this.fullName = fullName;
        this.name = name;
        this.email = email;
    }

    public enum Country{
        VN("Việt Nam",""),
        EN("Anh","");

        private String name,code;
        Country(String name,String code){
            this.name = name;
            this.code = code;
        }

    }
}
