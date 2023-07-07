package com.proga.MyProga.models;

import jakarta.persistence.*;

@Entity
@Table(name = "transaction")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long transactionId;


    private float amount;
    //private float amountMinus;
    private Long billFrom;
    private Long billTo;

    public Transaction() {
    }

    public Transaction(float amount, Long billFrom, Long billTo) {
        this.amount = amount;
        this.billFrom = billFrom;
        this.billTo = billTo;
    }

    public Transaction(float amount, Long billToId) {

    }

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public Long getBillFrom() {
        return billFrom;
    }

    public void setBillFrom(Long billFrom) {
        this.billFrom = billFrom;
    }

    public Long getBillTo() {
        return billTo;
    }

    public void setBillTo(Long billTo) {
        this.billTo = billTo;
    }
}
