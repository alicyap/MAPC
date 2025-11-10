package TD5.q2.business.api.structure.files;

import java.util.Iterator;

public interface CompositeFile extends Iterable<File> {

    boolean add(File f);

    public Iterator<File> iterator();
}
