package com.performance.testing.performance.model;


import lombok.Data;

import javax.management.relation.Role;
import javax.persistence.*;
import java.sql.Date;

@Table(name = "courses")
@Data
@Entity
public class Courses {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private Date createAt;
    private String averRating;
    private boolean isActive;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "author_id", nullable = false)
    private Accounts author;
}
