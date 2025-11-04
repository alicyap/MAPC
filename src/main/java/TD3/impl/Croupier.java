package TD3.impl;

import TD3.api.ShufflableCardSource;
import TD3.api.ShufflableCardSourceCreator;

/**
 * A basic implementation of a {@link ShufflableCardSourceCreator}
 */
public class Croupier implements ShufflableCardSourceCreator {

    @Override
    public ShufflableCardSource create() {
        return new Deck();
    }
    
}
