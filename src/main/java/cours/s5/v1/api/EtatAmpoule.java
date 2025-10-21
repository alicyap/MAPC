package cours.s5.v1.api;

public interface EtatAmpoule {
    EtatAmpoule allumer() throws ActionIllegale;
    EtatAmpoule eteindre() throws ActionIllegale;
}
