package com.thai.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_maire")
public class Maire {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "nom", length = 40)
    private String nom;

    private Commune commune;

    public Maire() {
        this(null, null);
    }

    public Maire(String nom) {
        this(nom, null);
    }

    public Maire(String nom, Commune commune) {
        this.nom = nom;
        this.commune = commune;

        System.out.println("Maire: " + this.nom + " -- commune: " + this.commune);
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

}
