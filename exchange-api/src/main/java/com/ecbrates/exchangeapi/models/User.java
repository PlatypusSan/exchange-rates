package com.ecbrates.exchangeapi.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Table(name = "user_table")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String login;
    @Column
    private String password;
    @Column
    private String phone;
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Role> roles;
}