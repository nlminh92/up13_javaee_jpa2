package com.thai.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.TreeSet;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

@Entity
@Table(name = "t_department")
public class Departement {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "nom", length = 40)
    private String nom;

    @OneToMany(
            cascade=CascadeType.PERSIST,
            fetch=FetchType.EAGER,
            mappedBy="departement")
    @OrderBy("nom DESC")
    private Collection<Commune> communeList = new TreeSet<Commune>(new NameComparator());

    public Departement() {
        this(null, null);
    }

    public Departement(String nom) {
        this(nom, null);
    }

    public Departement(String nom, List<Commune> communes) {
        this.nom = nom;
        if (communes != null) {
            this.communeList = communes;
        }
    }

    public long getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Collection<Commune> getCommunes() {
        List<Commune> newCommunes = new ArrayList<Commune>();
        for (Commune commune : communeList) {
            Commune copycat = new Commune();
            copycat.setCodePostal(commune.getCodePostal());
            copycat.setMaire(commune.getMaire());
            copycat.setNom(commune.getNom());
            newCommunes.add(copycat);
        }
        return newCommunes;
    }

    public void setCommunes(Collection<Commune> communeList) {
        this.communeList.addAll(communeList);
    }

    public void setCommune(Commune commune) {
        this.communeList.add(commune);
    }

    public Maire getMaire(Commune commune) {
        Maire maire = commune.getMaire();
        if (maire == null) {
            return null;
        }
        return new Maire(maire.getNom(), maire.getCommune());
    }

    public List<Maire> getMaires() {
        Maire maire = null;
        List<Maire> maireList = new ArrayList<Maire>();
        for (Commune commune : communeList) {
            maire = getMaire(commune);
            if (maire == null) {
                continue;
            }
            maireList.add(new Maire(maire.getNom(), maire.getCommune()));
        }
        return maireList;
    }
}
