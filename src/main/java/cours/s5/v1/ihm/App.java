package cours.s5.v1.ihm;

import cours.s5.v1.api.ActionIllegale;
import cours.s5.v1.api.Ampoule;

public class App {
    public static void main(String[] args) {
        // cas qui va bien
        Ampoule a = new Ampoule();
        try {
            a.allumer();
            a.eteindre();
        } catch (ActionIllegale e){
            System.out.println(e.getMessage());
        }
        // cas qui pose problème 1
        a = new Ampoule();
        try {
            a.allumer();
            a.allumer();
        } catch (ActionIllegale e){
            System.out.println(e.getMessage());
        }
        // cas qui pose problème 2
        a = new Ampoule();
        try {
            a.allumer();
            a.eteindre();
            a.eteindre();
        } catch (ActionIllegale e){
            System.out.println(e.getMessage());
        }
    }
}
