package com.thai.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.thai.model.Address;
import com.thai.model.Commune;
import com.thai.model.Departement;
import com.thai.model.Maire;

public class MainAddress {

    public static void main(String[] args) {

        // Premier
        Commune comHautesAlpes0 = new Commune("Jarjayes", "05460");
        Commune comHautesAlpes1 = new Commune("Villar-d'Arêne", "05470");
        Commune comHautesAlpes2 = new Commune("Ancelle", "05260");
        Commune comHautesAlpes3 = new Commune("Puy-Saint-Eusèbe", "05300");

        //// Address
        Address addHautesAlpes0 = new Address("123 rue de Jarjayes", comHautesAlpes0);
        Address addHautesAlpes1 = new Address("123 rue de Villar-d'Arêne", comHautesAlpes1);
        Address addHautesAlpes2 = new Address("123 rue de Ancelle", comHautesAlpes2);
        Address addHautesAlpes3 = new Address("123 rue de Puy-Saint-Eusèbe", comHautesAlpes3);

        comHautesAlpes0.setAddress(addHautesAlpes0);
        comHautesAlpes1.setAddress(addHautesAlpes1);
        comHautesAlpes2.setAddress(addHautesAlpes2);
        comHautesAlpes3.setAddress(addHautesAlpes3);

        Address[] addresses = { addHautesAlpes0, addHautesAlpes1, addHautesAlpes2, addHautesAlpes3 };
        List<Address> addressList = new ArrayList<Address>(Arrays.asList(addresses));

        Departement deptHautesAlpes = new Departement("Hautes-Alpes");
        Commune[] comHautesAlpes = { comHautesAlpes0, comHautesAlpes1, comHautesAlpes2, comHautesAlpes3 };
        deptHautesAlpes.setCommunes(Arrays.asList(comHautesAlpes));

        List<Commune> communeList = new ArrayList<Commune>(Arrays.asList(comHautesAlpes));

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

        //// Address
        Address addMaireHautesAlpes0 = new Address("321 rue de Jarjayes Maire", comHautesAlpes0);
        Address addMaireHautesAlpes1 = new Address("321 rue de Villar-d'Arêne Maire", comHautesAlpes1);
        Address addMaireHautesAlpes2 = new Address("321 rue de Ancelle Maire", comHautesAlpes2);
        Address addMaireHautesAlpes3 = new Address("321 rue de Puy-Saint-Eusèbe Maire", comHautesAlpes3);

        maireHautesAlpes0.setAddress(addMaireHautesAlpes0);
        maireHautesAlpes1.setAddress(addMaireHautesAlpes1);
        maireHautesAlpes2.setAddress(addMaireHautesAlpes2);
        maireHautesAlpes3.setAddress(addMaireHautesAlpes3);

        Address[] addressesMaireHautesAlpes = { addMaireHautesAlpes0, addMaireHautesAlpes1, addMaireHautesAlpes2, addMaireHautesAlpes3 };
        addressList.addAll(Arrays.asList(addressesMaireHautesAlpes));

        Maire[] maires = { maireHautesAlpes0, maireHautesAlpes1, maireHautesAlpes2, maireHautesAlpes3 };
        List<Maire> maireList = new ArrayList<Maire>(Arrays.asList(maires));

        // Deuxieme
        Commune comEssone0 = new Commune("Viry-Châtillon", "91150");
        Commune comEssone1 = new Commune("Étréchy", "91670");
        Commune comEssone2 = new Commune("Mauchamps", "91690");
        Commune comEssone3 = new Commune("Athis-Mons", "91200");

        //// Address
        Address addEssone0 = new Address("789 rue de Viry-Châtillon", comEssone0);
        Address addEssone1 = new Address("789 rue de Étréchy", comEssone1);
        Address addEssone2 = new Address("789 rue de Mauchamps", comEssone2);
        Address addEssone3 = new Address("789 rue de Athis-Mons", comEssone3);

        comEssone0.setAddress(addEssone0);
        comEssone1.setAddress(addEssone1);
        comEssone2.setAddress(addEssone2);
        comEssone3.setAddress(addEssone3);

        Address[] addressesEssone = { addEssone0, addEssone1, addEssone2, addEssone3 };
        addressList.addAll(Arrays.asList(addressesEssone));

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

        Maire[] mairesEssone = { maireEssone0, maireEssone1, maireEssone2, maireEssone3 };
        maireList.addAll(Arrays.asList(mairesEssone));

        //// Address
        Address addMaireEssone0 = new Address("987 rue de Viry-Châtillon Maire", comEssone0);
        Address addMaireEssone1 = new Address("987 rue de Étréchy Maire", comEssone1);
        Address addMaireEssone2 = new Address("987 rue de Mauchamps Maire", comEssone2);
        Address addMaireEssone3 = new Address("987 rue de Athis-Mons Maire", comEssone3);

        maireEssone0.setAddress(addMaireEssone0);
        maireEssone1.setAddress(addMaireEssone1);
        maireEssone2.setAddress(addMaireEssone2);
        maireEssone3.setAddress(addMaireEssone3);

        Address[] addressesMaireEssone = { addMaireEssone0, addMaireEssone1, addMaireEssone2, addMaireEssone3 };
        addressList.addAll(Arrays.asList(addressesMaireEssone));

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

        em.flush();
        em.getTransaction().commit();
        // Clear object
        em.getEntityManagerFactory().getCache().evictAll();

        Departement dept = em.find(Departement.class, deptHautesAlpes.getId());
        Collection<Commune> retrievedCommuneList = dept.getCommunes();
        for (Commune commune : retrievedCommuneList) {
            System.out.println("Communs de Department : " + commune.getNom());
            System.out.println("Maire de commune " + commune.getNom() + ": " + dept.getMaire(commune).getNom());
        }

        System.out.println("Finish");

    }
}