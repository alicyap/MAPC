package TD5.q2.business.impl.structure.identification;

import TD5.q2.business.api.structure.identification.UserId;

/**
 * Implémentation simple et triviale d'identification d'utilisateur.
 */
public class UserIdImpl extends AbstractId<Integer> implements UserId {

    UserIdImpl(int id) {
        super(id);
    }

}