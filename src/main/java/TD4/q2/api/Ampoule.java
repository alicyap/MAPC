package TD4.q2.api;

import io.vavr.control.Option;

import java.util.function.Consumer;

public class Ampoule {
    private EtatAmpoule e;
    private int usage;
    private Consumer<String> informateur; // Prend une entrée String -> void

    // on utilise consumer == strategy
    public Ampoule(Consumer<String> informateur) {
        this.usage = 0;
        this.informateur = informateur;
        this.e = EtatEteinte.INSTANCE;
    }

    // visibilité package
    void _allumer() {
        informateur.accept("l'ampoule s'allume");
        usage++;
    }

    // visibilité package
    void _eteindre() {
        informateur.accept("l'ampoule s'éteint");
    }

    // visibilité package
    int usages() {
        return usage;
    }

    // visibilité package
    void changeEtat(EtatAmpoule e) {
        this.e = e;
    }

    private Consumer<? super Throwable> informateurErreur = 
        exception -> informateur.accept(exception.getMessage());

    public Option<Integer> allumer() {
        return this.e.allumer(this).onFailure(informateurErreur).toOption();
    }

    public void eteindre() {
        this.e.eteindre(this).onFailure(informateurErreur);
    }
}
