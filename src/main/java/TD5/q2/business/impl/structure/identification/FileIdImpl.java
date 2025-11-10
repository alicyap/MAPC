package TD5.q2.business.impl.structure.identification;

import TD5.q2.business.api.structure.identification.FileId;

/**
 * Implémentation simple et triviale d'identification de fichier.
 */
public class FileIdImpl extends AbstractId<Integer> implements FileId {

    FileIdImpl(int id) {
        super(id);
    }

}