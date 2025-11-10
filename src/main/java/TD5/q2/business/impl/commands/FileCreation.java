package TD5.q2.business.impl.commands;

import java.util.Optional;

import TD5.q2.business.api.commands.Command;
import TD5.q2.business.api.structure.identification.FileId;
import TD5.q2.business.api.structure.identification.UserId;
import TD5.q2.business.impl.structure.files.FileSystem;

/**
 * Commande de création de fichier simple.
 */
public class FileCreation implements Command<Optional<FileId>> {

    private FileSystem s; // le contexte de la commande
    private String name;
    private UserId owner;
    private FileId parent;
    private String contents;

    public FileCreation(FileSystem s, String name, UserId owner, FileId parent, String contents) {
        assert s != null;
        assert name != null && !name.isEmpty();
        assert parent != null;
        assert contents != null;
        this.s = s;
        this.name = name;
        this.owner = owner;
        this.parent = parent;
        this.contents = contents;
    }

    public FileCreation(FileSystem s, String name, FileId parent, String contents) {
        this(s, name, null, parent, contents);
    }

    /**
     * Exécute la commande de création de fichier.
     * Ici on délègue au contexte.
     */
    @Override
    public Optional<FileId> execute() {
        if (this.owner != null)
            return s.createFile(name, owner, parent, contents);
        else
            return s.createFile(name, parent, contents);
    }

}
