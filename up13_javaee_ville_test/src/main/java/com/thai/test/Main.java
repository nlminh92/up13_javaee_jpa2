package com.thai.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.thai.model.Commune;
import com.thai.model.Departement;
import com.thai.model.Maire;

public class Main {

    public static void main(String[] args) {

        // Premier
        Commune comHautesAlpes0 = new Commune("Jarjayes", "05460");
        Commune comHautesAlpes1 = new Commune("Villar-d'Arêne", "05470");
        Commune comHautesAlpes2 = new Commune("Ancelle", "05260");
        Commune comHautesAlpes3 = new Commune("Puy-Saint-Eusèbe", "05300");

        Departement deptHautesAlpes = new Departement("Hautes-Alpes");
        Commune[] comHautesAlpes = { comHautesAlpes0, comHautesAlpes1, comHautesAlpes2, comHautesAlpes3 };
        deptHautesAlpes.setCommunes(Arrays.asList(comHautesAlpes));

        List<Commune> communeList = new ArrayList<Commune>();
        communeList.addAll(Arrays.asList(comHautesAlpes));

        comHautesAlpes0.setDepartement(deptHautesAlpes);
        comHautesAlpes1.setDepartement(deptHautesAlpes);
        comHautesAlpes2.setDepartement(deptHautesAlpes);
        comHautesAlpes3.setDepartement(deptHautesAlpes);

        Maire maireHautesAlpes0 = new Maire("Jarjayes Maire", comHautesAlpes0);
        Maire maireHautesAlpes1 = new Maire("Villar-d'Arêne Maire", comHautesAlpes1);
        Maire maireHautesAlpes2 = new Maire("Ancelle Maire", comHautesAlpes2);
        Maire maireHautesAlpes3 = new Maire("Puy-Saint-Eusèbe Maire", comHautesAlpes3);

        comHautesAlpes0.setMaire(maireHautesAlpes0);
        comHautesAlpes1.setMaire(maireHautesAlpes1);
        comHautesAlpes2.setMaire(maireHautesAlpes2);
        comHautesAlpes3.setMaire(maireHautesAlpes3);

        List<Maire> maireList = new ArrayList<Maire>();
        maireList.add(maireHautesAlpes0);
        maireList.add(maireHautesAlpes1);
        maireList.add(maireHautesAlpes2);
        maireList.add(maireHautesAlpes3);

        // Deuxieme
        Commune comEssone0 = new Commune("Viry-Châtillon", "91150");
        Commune comEssone1 = new Commune("Étréchy", "91670");
        Commune comEssone2 = new Commune("Mauchamps", "91690");
        Commune comEssone3 = new Commune("Athis-Mons", "91200");

        Departement deptEssone = new Departement("Essonne");
        Commune[] comEssone = { comEssone0, comEssone1, comEssone2, comEssone3 };
        deptEssone.setCommunes(Arrays.asList(comEssone));

        communeList.addAll(Arrays.asList(comEssone));

        comEssone0.setDepartement(deptEssone);
        comEssone1.setDepartement(deptEssone);
        comEssone2.setDepartement(deptEssone);
        comEssone3.setDepartement(deptEssone);

        Maire maireEssone0 = new Maire("Viry-Châtillon Maire", comEssone0);
        Maire maireEssone1 = new Maire("Étréchy Maire", comEssone1);
        Maire maireEssone2 = new Maire("Mauchamps Maire", comEssone2);
        Maire maireEssone3 = new Maire("Athis-Mons Maire", comEssone3);

        comEssone0.setMaire(maireEssone0);
        comEssone1.setMaire(maireEssone1);
        comEssone2.setMaire(maireEssone2);
        comEssone3.setMaire(maireEssone3);

        maireList.add(maireEssone0);
        maireList.add(maireEssone1);
        maireList.add(maireEssone2);
        maireList.add(maireEssone3);

        // Persistence
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ville_test");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        for (Commune commune : communeList) {
            em.persist(commune);
        }

        for (Maire maire : maireList) {
            em.persist(maire);
        }

        em.persist(deptHautesAlpes);
        em.persist(deptEssone);

        em.getTransaction().commit();

        // Clear object
        em.getEntityManagerFactory().getCache().evictAll();

        // Retrieve
        Departement dept = em.find(Departement.class, 17L);
        System.out.println("Department : " + dept.getNom());
        for (Commune commune : dept.getCommunes()) {
            System.out.println("Communs de Department : " + commune.getNom());
        }
        for (Commune commune : dept.getCommunes()) {
            System.out.println("Maire de commune " + commune.getNom() + ": " + dept.getMaire(commune).getNom());
        }

        System.out.println("Finish");

    }
}
