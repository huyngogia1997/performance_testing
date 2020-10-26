package com.performance.testing.performance.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Table(name = "roles")
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Roles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Enumerated(EnumType.STRING)
    private Role name;

    public enum Role{
        STUDENT("Học sinh"),
        ADMIN("Người quản trị");

        private String name;
        Role(String name){
            this.name = name;
        }
    }
}
