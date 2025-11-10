package org.example.ccs.cc2025.cc1.apres;

import java.util.ArrayList;
import java.util.List;

public class Etudiant {
    private final String id;
    private final Adresse adresse; // introduction et utilisation type métier
    private final List<Double> ns;

    public Etudiant(String id, Adresse adresse) {
        assert id != null && !id.isEmpty() && adresse != null; // assert
        this.id = id;
        this.adresse = adresse;
        this.ns = new ArrayList<>();
    }

    // constructeur par recopie
    public Etudiant(Etudiant e) {
        assert e != null;
        this.id = e.id;
        this.adresse = e.adresse;
        this.ns = new ArrayList<>(e.ns);
    }

    public String id() {
        return this.id;
    }

    public Adresse adresse() {
        return this.adresse;
    }

    public void noter(double nouvelleNote) {
        this.ns.add(nouvelleNote);
    }

    public double moyenne() {
        assert this.ns.size() != 0; // assert
        return this.ns.stream()
                .mapToDouble(x -> x)
                .sum() / this.ns.size();
    }
}
