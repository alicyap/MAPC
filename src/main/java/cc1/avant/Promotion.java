package org.example.ccs.cc2025.cc1.avant;

import java.util.HashMap;
import java.util.Collection;
import java.util.Map;

public class Promotion {
    private Map<String, Etudiant> es;

    public Promotion() {
        this.es = new HashMap<>();
    }

    public Promotion(Promotion p) {
        // manque assert
        this.es = new HashMap<>();
        for (String k : p.es.keySet())
                this.es.put(k, p.es.get(k)); // erreur de copie (étudiants mutables)
    }

    public void inscrire(Etudiant e) {
        // manque assert
        this.es.put(e.id(), e);
    }

    public Collection<Etudiant> etudiants() {
        return this.es.values(); // mieux vaut itérer
    }

    public double moyenne() {
        // manque assert
        return this.es.values().stream()
                .mapToDouble(Etudiant::moyenne)
                .sum() / this.es.values().size();
    }
}
