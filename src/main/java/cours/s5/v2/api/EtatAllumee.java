package cours.s5.v2.api;

import io.vavr.control.Try;

public class EtatAllumee implements EtatAmpoule {

    private EtatAllumee() {}

    // Singleton, on positionne l'état dès le début
    public static final EtatAmpoule INSTANCE = new EtatAllumee();

    @Override
    public Try<Integer> allumer(Ampoule a) {
        return Try.failure(new ActionIllegale("ampoule déjà allumée"));
    }
    
    @Override
    public Try<Void> eteindre(Ampoule a) {
        a._eteindre();
        a.changeEtat(EtatEteinte.INSTANCE);
        return Try.success(null);
    }
    
}
