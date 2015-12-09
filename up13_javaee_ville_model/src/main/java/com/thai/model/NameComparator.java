package com.thai.model;

import java.util.Comparator;

public class NameComparator implements Comparator<Commune> {

    @Override
    public int compare(Commune arg0, Commune arg1) {
        return arg0.getNom().compareTo(arg1.getNom());
    }

}
