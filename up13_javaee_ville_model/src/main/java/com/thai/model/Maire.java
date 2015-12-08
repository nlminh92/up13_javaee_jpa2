package com.thai.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "t_maire")
public class Maire implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "nom", length = 40)
    private String nom;

    @JoinColumn(name="commune_id", insertable=false, updatable=false)
    private Commune commune;

    @Embedded
    private Address address;

    public Maire() {
        this(null, null);
    }

    public Maire(String nom) {
        this(nom, null);
    }

    public Maire(String nom, Commune commune) {
        this.nom = nom;
        this.commune = commune;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Commune getCommune() {
        return commune;
    }

    public void setCommune(Commune commune) {
        this.commune = commune;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

}
