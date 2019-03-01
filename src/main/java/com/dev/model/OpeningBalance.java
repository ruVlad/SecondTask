package com.dev.model;

import javax.persistence.*;

@Entity
@Table(name = "opening_balance")
public class OpeningBalance {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

    @Column(name = "id_account")
    private int idAccount;

    private double asset;

    private double liability;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(int idAccount) {
        this.idAccount = idAccount;
    }

    public double getAsset() {
        return asset;
    }

    public void setAsset(double asset) {
        this.asset = asset;
    }

    public double getLability() {
        return liability;
    }

    public void setLability(double liability) {
        this.liability = liability;
    }
}
