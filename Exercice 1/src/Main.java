/**
 * Created by mohamed Nouri on 06/03/2019.
 */

public class Main {

    public static void main(String[] args) {
        Thread  compteur2 = new Compteur("1");
        Thread  compteur1 = new Compteur("2");
        Thread  compteur = new Compteur("3");
        Thread  compteur4 = new Compteur("3");

        Thread[] compteurs = {compteur,compteur1,compteur2,compteur4};
        for (Thread comp:
             compteurs) {
            comp.start();
        }
    }
}
