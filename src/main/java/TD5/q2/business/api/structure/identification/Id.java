package TD5.q2.business.api.structure.identification;

/**
 * Interface générique pour l'indentification métier.
 */
public interface Id<T> {

    /**
     * Retourne l'id de l'objet métier.
     * @return l'id de l'objet métier.
     */
    T id();

}
