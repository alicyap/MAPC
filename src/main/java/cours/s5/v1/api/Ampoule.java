package cours.s5.v1.api;

public class Ampoule {
    private EtatAmpoule e;

    public Ampoule() {
        this.e = new EtatEteinte(this);
    }

    public void allumer() throws ActionIllegale {
        this.e = this.e.allumer();
    }

    public void eteindre() throws ActionIllegale {
        this.e = this.e.eteindre();
    }

    void doAllumer() {
        System.out.println("l'ampoule s'allume");
    }

    void doEteindre() {
        System.out.println("l'ampoule s'éteint");
    }
}
