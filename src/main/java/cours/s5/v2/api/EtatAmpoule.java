package cours.s5.v2.api;

import io.vavr.control.Try;

public interface EtatAmpoule {
    Try<Integer> allumer(Ampoule a);
    Try<Void> eteindre(Ampoule a);
}
