package org.example.ccs.cc2025.cc1.avant;

import java.util.ArrayList;
import java.util.List;

public class Etudiant {
    private final String id, adresse; // primitive obsession
    private final List<Double> ns;

    public Etudiant(String id, String adresse) {
        // manque assert
        this.id = id;
        this.adresse = adresse;
        this.ns = new ArrayList<>();
    }

    // manque constructeur par recopie
    public String id() {
        return this.id;
    }

    public String adresse() {
        return this.adresse;
    }

    public void noter(double nouvelleNote) {
        this.ns.add(nouvelleNote);
    }

    public double moyenne() {
        // manque assert
        return this.ns.stream()
                .mapToDouble(x -> x)
                .sum() / this.ns.size();
    }
}
