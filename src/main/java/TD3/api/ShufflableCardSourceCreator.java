package TD3.api;

/**
 * Factory for the creation of shufflable card sources.
 */
public interface ShufflableCardSourceCreator {
    
    /**
     * Creates a new shufflable card source.
     */
    ShufflableCardSource create();
}
