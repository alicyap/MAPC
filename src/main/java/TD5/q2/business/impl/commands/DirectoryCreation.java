package TD5.q2.business.impl.commands;

import java.util.Optional;

import TD5.q2.business.api.commands.Command;
import TD5.q2.business.api.structure.identification.FileId;
import TD5.q2.business.api.structure.identification.UserId;
import TD5.q2.business.impl.structure.files.FileSystem;

/**
 * Commande de création de répertoire.
 */
public class DirectoryCreation implements Command<Optional<FileId>> {

    private FileSystem s; // le contexte de la commande
    private String name;
    private UserId owner;
    private FileId parent;

    public DirectoryCreation(FileSystem s, String name, UserId owner, FileId parent) {
        assert s != null;
        assert name != null && !name.isEmpty();
        assert parent != null;
        // autres vérifications déléguées
        this.s = s;
        this.name = name;
        this.owner = owner;
        this.parent = parent;
    }

    public DirectoryCreation(FileSystem s, String name, FileId parent) {
        // vérifications déléguées à l'autre constructeur
        this(s, name, null, parent);
    }

    /**
     * Exécute la commande et renvoie le résultat.
     * Ici on délègue au contexte.
     */
    @Override
    public Optional<FileId> execute() {
        if (this.owner != null)
            return s.createDirectory(name, owner, parent);
        else
            return s.createDirectory(name, parent);
    }

}
