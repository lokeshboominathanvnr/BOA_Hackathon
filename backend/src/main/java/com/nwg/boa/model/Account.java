package com.nwg.boa.model;
import jakarta.persistence.*;


@Entity
@Table(name = "account")
public class Account {

    @Column(name = "customerid")
    private String customerid;
    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String  lastname ;
    @Column(name = "savingsacc")
    private String  savingsacc;
    @Column(name = "currentacc")
    private String  currentacc;
    @Column(name = "savingsbalance")
    private double savingsbalance;
    @Column(name = "currentbalance")
    private double  currentbalance;

    @Column(name = "smallsavings")
    private boolean smallsavings;
    @Column(name = "smallsavingsacc")
    private String  smallsavingsacc ;

    @Column(name = "smallsavingsbalance")
    private double  smallsavingsbalance ;
    @Column(name = "smallsavingsperc1")
    private int  smallsavingsperc1 ;

    @Column(name = "smallsavingsperc2")
    private int  smallsavingsperc2 ;
    @Id
    private Long id;

    @Column(name = "targetgoal")
    private double  targetgoal ;

    private double  transactionamt ;


    public Account() {

    }

    public String getCustomerid() {
        return customerid;
    }

    public void setCustomerid(String customerid) {
        this.customerid = customerid;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getSavingsacc() {
        return savingsacc;
    }

    public void setSavingsacc(String savingsacc) {
        this.savingsacc = savingsacc;
    }

    public String getCurrentacc() {
        return currentacc;
    }

    public void setCurrentacc(String currentacc) {
        this.currentacc = currentacc;
    }

    public double getSavingsbalance() {
        return savingsbalance;
    }

    public void setSavingsbalance(double savingsbalance) {
        this.savingsbalance = savingsbalance;
    }

    public double getCurrentbalance() {
        return currentbalance;
    }

    public void setCurrentbalance(double currentbalance) {
        this.currentbalance = currentbalance;
    }

    public boolean isSmallsavings() {
        return smallsavings;
    }

    public void setSmallsavings(boolean smallsavings) {
        this.smallsavings = smallsavings;
    }

    public String getSmallsavingsacc() {
        return smallsavingsacc;
    }

    public void setSmallsavingsacc(String smallsavingsacc) {
        this.smallsavingsacc = smallsavingsacc;
    }

    public double getSmallsavingsbalance() {
        return smallsavingsbalance;
    }

    public void setSmallsavingsbalance(double smallsavingsbalance) {
        this.smallsavingsbalance = smallsavingsbalance;
    }

    public int getSmallsavingsperc1() {
        return smallsavingsperc1;
    }

    public void setSmallsavingsperc1(int smallsavingsperc1) {
        this.smallsavingsperc1 = smallsavingsperc1;
    }

    public int getSmallsavingsperc2() {
        return smallsavingsperc2;
    }

    public void setSmallsavingsperc2(int smallsavingsperc2) {
        this.smallsavingsperc2 = smallsavingsperc2;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getTargetgoal() {
        return targetgoal;
    }

    public void setTargetgoal(double targetgoal) {
        this.targetgoal = targetgoal;
    }

    public double getTransactionamt() {
        return transactionamt;
    }

    public void setTransactionamt(double transactionamt) {
        this.transactionamt = transactionamt;
    }
}
