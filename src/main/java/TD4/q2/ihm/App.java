package TD4.q2.ihm;

import TD4.q2.api.Ampoule;
import io.vavr.control.Option;

import java.util.function.Consumer;

public class App {

    private static final Consumer<String> afficheur = System.out::println;

    public static void main(String[] args) {
        Ampoule a;
        Option<Integer> lumens;

        // cas qui va bien
        a = new Ampoule(afficheur);
        lumens = a.allumer();
        System.out.println(lumens + " lumens");
        a.eteindre();

        // cas qui pose problème 1
        a = new Ampoule(afficheur);
        lumens = a.allumer();
        System.out.println(lumens + " lumens");
        a.allumer();

        // cas qui pose problème 2
        a = new Ampoule(afficheur);
        lumens = a.allumer();
        System.out.println(lumens + " lumens");
        a.eteindre();

        // cas qui pose problème 3
        a = new Ampoule(afficheur);
        lumens = a.allumer();
        System.out.println(lumens + " lumens");
        a.eteindre();
        a.eteindre();
    }
}
