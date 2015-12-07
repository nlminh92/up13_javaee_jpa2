package com.thai.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "t_department")
public class Departement {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "nom", length = 40)
    private String nom;

    @OneToMany
    private Collection<Commune> communeList = new ArrayList<Commune>();

    public Departement() {
        this(null, null);
    }

    public Departement(String nom) {
        this(nom, null);
    }

    public Departement(String nom, Collection<Commune> communes) {
        this.nom = nom;
        if (communes != null) {
            this.communeList = communes;
        }
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Collection<Commune> getCommunes() {
        return communeList;
    }

    public void setCommunes(Collection<Commune> communeList) {
        this.communeList = communeList;
    }

    public void setCommune(Commune commune) {
        this.communeList.add(commune);
    }
}
