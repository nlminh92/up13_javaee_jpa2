package com.thai.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "t_commune")
public class Commune {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "nom", length = 40)
    private String nom;

    @Column(name = "code_postal", length = 40)
    private String codePostal;

    @OneToOne(mappedBy = "commune")
    private Maire maire;

    @OneToOne
    private Departement departement;

    public Commune() {
        this(null, null);
    }

    public Commune(String nom, String codePostal) {
        this(nom, codePostal, null);
    }

    public Commune(String nom, String codePostal, Departement departement) {
        this.nom = nom;
        this.codePostal = codePostal;
        this.setDepartement(departement);
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

}
