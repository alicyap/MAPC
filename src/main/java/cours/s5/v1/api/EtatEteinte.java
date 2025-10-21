package cours.s5.v1.api;

public class EtatEteinte implements EtatAmpoule {

    private Ampoule contexte;

    public EtatEteinte(Ampoule contexte) {
        this.contexte = contexte;
    }

    @Override
    public EtatAmpoule allumer() throws ActionIllegale {
        contexte.doAllumer();
        return new EtatAllumee(contexte);
    }

    @Override
    public EtatAmpoule eteindre() throws ActionIllegale {
        throw new ActionIllegale("ampoule déjà éteinte");
    }
    
}
