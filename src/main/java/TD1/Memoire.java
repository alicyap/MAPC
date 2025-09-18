package TD1;

import java.util.ArrayList;
import java.util.List;

public class Memoire implements Document {
    private String titre;

//    public Memoire(String titre, List<Chapitre> chapitres){
//        titre = this.titre;
//        chapitres = new ArrayList<Chapitre>();
//    }
    @Override
    public String titre() {
        return this.titre;
    }

    @Override
    public int taille() {
        return 0;
    }
}
