package org.example.ccs.cc2025.cc1.apres;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Promotion implements Iterable<Etudiant> {
    private Map<String, Etudiant> es;

    public Promotion() {
        this.es = new HashMap<>();
    }

    public Promotion(Promotion p) {
        assert p != null; // assert
        this.es = Promotion.copieEtudiants(p); // copie plus complexe avec copie étudiants car mutables
    }

    // private important
    private static Map<String, Etudiant> copieEtudiants(Promotion p) {
        Map<String, Etudiant> copieEtudiants = new HashMap<>();
        for (String k : p.es.keySet())
            copieEtudiants.put(k, new Etudiant(p.es.get(k)));
        return copieEtudiants;
    }

    public void inscrire(Etudiant e) {
        assert e != null; // assert
        this.es.put(e.id(), e);
    }

    @Override public Iterator<Etudiant> iterator() {
        // itérateur
        Map<String, Etudiant> copieEtudiants = Promotion.copieEtudiants(this);
        return copieEtudiants.values().iterator();
    }

    // si on veut garder le nom de méthode
    public Iterator<Etudiant> etudiants() {
        return iterator();
    }
    
    public double moyenne() {
        assert this.es.size() != 0; // assert
        return this.es.values().stream()
                .mapToDouble(Etudiant::moyenne)
                .sum() / this.es.values().size();
    }
}
