package TD5.q2.business.impl.structure.identification;

import java.util.Optional;

import TD5.q2.business.api.structure.identification.FileId;
import TD5.q2.business.api.structure.identification.IdGenerator;

public class FileIdGenerator implements IdGenerator<FileId> {

    private final int maxfiles;
    private FileId nextId;
    
    public FileIdGenerator(int maxfiles) {
        this.maxfiles = maxfiles;
        this.nextId = new FileIdImpl(0);
    }

    @Override
    public Optional<FileId> createId() {
        FileId result = nextId;
        if (result.id() < this.maxfiles) {
            nextId = new FileIdImpl(result.id() + 1);
            return Optional.of(result);
        } else {
            return Optional.empty();
        }
    }
}
