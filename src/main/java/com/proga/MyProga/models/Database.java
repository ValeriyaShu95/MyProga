package com.proga.MyProga.models;

import jakarta.persistence.*;

@Entity
@Table(name = "database")
public class Database {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private int age;



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

    public int getAge() {
        return age;
    }

    public Database() {
    }

    public Database(Long id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Database(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void setAge(int age) {
        this.age = age;


    }

}
