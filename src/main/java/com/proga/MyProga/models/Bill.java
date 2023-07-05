package com.proga.MyProga.models;

import jakarta.persistence.*;

@Entity
@Table(name = "bill")
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long billId;
    private float ammount;
    @ManyToOne
    @JoinColumn(name = "id")
    Database database;

    public Bill() {
    }

    public Database getDatabase() {
        return database;
    }

    public void setDatabase(Database database) {
        this.database = database;
    }

    public Bill(float ammount, Database database) {
        //this.billId = billId;
        this.ammount = ammount;
        this.database = database;
    }

    public Long getBillId() {
        return billId;
    }

    public void setBillId(Long billId) {
        this.billId = billId;
    }

    public float getAmmount() {
        return ammount;
    }

    public void setAmmount(float ammount) {
        this.ammount = ammount;
    }
}
