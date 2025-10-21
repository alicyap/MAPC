package cours.s5.v1.api;

public class EtatAllumee implements EtatAmpoule {

    private Ampoule contexte;

    public EtatAllumee(Ampoule contexte) {
        this.contexte = contexte;
    }

    @Override
    public EtatAmpoule allumer() throws ActionIllegale {
        throw new ActionIllegale("ampoule déjà allumée");
    }
    
    @Override
    public EtatAmpoule eteindre() throws ActionIllegale {
        contexte.doEteindre();
        return new EtatEteinte(contexte);
    }
    
}
