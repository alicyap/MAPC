package TD5.q1.impl;

import TD5.q1.api.ShufflableCardSource;
import TD5.q1.api.ShufflableCardSourceCreator;

/**
 * A basic implementation of a {@link ShufflableCardSourceCreator}
 */
public class Croupier implements ShufflableCardSourceCreator {

    @Override
    public ShufflableCardSource create() {
        return new Deck();
    }
    
}
