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
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.eclipse.persistence.annotations.JoinFetch;
import org.eclipse.persistence.annotations.JoinFetchType;

@Entity
@Table(name = "t_maire")
public class Maire implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "nom", length = 40)
    private String nom;

    // Prevention of duplicate writing to foreign key columns
    @JoinColumn(name = "commune_id", insertable = false, updatable = false)
    @OneToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinFetch(JoinFetchType.OUTER)
    private Commune commune;

    @Embedded
    @OneToOne(mappedBy="maire", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private Address address;

    public Maire() {
        this(null, null);
    }

    public Maire(String nom) {
        this(nom, null);
    }

    public Maire(String nom, Commune commune) {
        this(nom, commune, null);
    }

    public Maire(String nom, Commune commune, Address address) {
        this.nom = nom;
        this.commune = commune;
        this.address = address;
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
