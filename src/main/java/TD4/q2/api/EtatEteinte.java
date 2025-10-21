package TD4.q2.api;

import io.vavr.control.Try;

public class EtatEteinte implements EtatAmpoule {

    private EtatEteinte() {
    }

    public static final EtatAmpoule INSTANCE = new EtatEteinte();

    @Override
    public Try<Integer> allumer(Ampoule a) {
        if (a.usages() < 3) {
            a._allumer();  // incrémente usages
            a.changeEtat(EtatAllumee.INSTANCE);
            return Try.success(a.usages());
        }
        a.changeEtat(EtatCassee.INSTANCE);
        return Try.failure(new ActionIllegale("ampoule cassée"));

    }

    @Override
    public Try<Void> eteindre(Ampoule a) {
        return Try.failure(new ActionIllegale("ampoule déjà éteinte"));
    }

}
