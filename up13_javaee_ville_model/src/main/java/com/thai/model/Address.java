package com.thai.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.OneToOne;

@Embeddable
public class Address implements Serializable {

    private static final long serialVersionUID = 3L;

    @Column(name="rue", length=40)
    private String rue;

    @OneToOne
    private Commune commune;

    public Address() {
        this(null, null);
    }

    public Address(String rue, Commune commune) {
        this.rue = rue;
        this.commune = commune;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public Commune getCommune() {
        return commune;
    }

    public void setCommune(Commune commune) {
        this.commune = commune;
    }
}
