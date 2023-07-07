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
    @JoinColumn(name = "Id")
    Users users;

    public Bill() {
    }
    public Users getDatabase() {
        return users;
    }

    public void setDatabase(Users users) {
        this.users = users;
    }

    public Bill(float ammount, Users users) {
        //this.billId = billId;
        this.ammount = ammount;
        this.users = users;
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
