package TD5.q2.business.impl.commands;

import java.util.Optional;

import TD5.q2.business.api.commands.Command;
import TD5.q2.business.api.structure.identification.FileId;
import TD5.q2.business.api.structure.identification.UserId;
import TD5.q2.business.impl.structure.files.FileSystem;

/**
 * Commande de création de lien.
 */
public class LinkCreation implements Command<Optional<FileId>> {

    private FileSystem s; // le contexte de la commande.
    private String name;
    private UserId owner;
    private FileId parent;
    private FileId target;

    public LinkCreation(FileSystem s, String name, UserId owner, FileId parent, FileId target) {
        assert s != null;
        assert name != null && !name.isEmpty();
        assert parent != null;
        assert target != null;
        this.s = s;
        this.name = name;
        this.owner = owner;
        this.parent = parent;
        this.target = target;
    }

    public LinkCreation(FileSystem s, String name, FileId parent, FileId target) {
        this(s, name, null, parent, target);
    }

    /**
     * Exécute la commande et renvoie le résultat.
     * Ici on délègue au contexte.
     */
    @Override
    public Optional<FileId> execute() {
        if (this.owner != null)
            return s.createLink(name, owner, parent, target);
        else
            return s.createLink(name, parent, target);
    }

}
