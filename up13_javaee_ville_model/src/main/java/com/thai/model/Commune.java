package com.thai.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "t_commune")
public class Commune implements Serializable {

    private static final long serialVersionUID = 2L;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;

    @Column(name="nom", length=40)
    private String nom;

    @Column(name="code_postal", length=40)
    private String codePostal;

    @OneToOne(mappedBy="commune")
    private Maire maire;

    @ManyToOne(
            cascade=CascadeType.PERSIST,
            fetch=FetchType.EAGER)
    private Departement departement;

    @Embedded
    @OneToOne(mappedBy="commune")
    private Address address;

    public Commune() {
        this(null, null);
    }

    public Commune(String nom, String codePostal) {
        this(nom, codePostal, null);
    }

    public Commune(String nom, String codePostal, Departement departement) {
        this.nom = nom;
        this.codePostal = codePostal;
        this.departement = departement;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public Maire getMaire() {
        return maire;
    }

    public void setMaire(Maire maire) {
        this.maire = maire;
    }

    public Departement getDepartement() {
        return departement;
    }

    public void setDepartement(Departement departement) {
        this.departement = departement;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

}
