package TD5.q2.business.impl.structure.files;

import java.util.List;

import TD5.q2.business.api.structure.files.File;
import TD5.q2.business.api.structure.identification.FileId;
import TD5.q2.business.api.structure.identification.UserId;

public class SimpleFile extends AbstractFile {

    private String contenu;

    SimpleFile(FileId parent, FileId id, String name, UserId owner, String contents) {
        super(parent, id, name, owner);
        this.contenu = contents;
    }

    @Override
    public String toString() {
        return String.format("file %s:%s (%s)", id(), name(), owner());
    }

    @Override
    public int size() {
        return contenu.length();
    }

    @Override
    public List<File> contents() {
        return List.of(this);
    }

}
