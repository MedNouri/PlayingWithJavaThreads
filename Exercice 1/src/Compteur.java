/**
 * Created by mohamed Nouri on 06/03/2019.
 */
public class Compteur  extends Thread {

    String number;

    public Compteur(String number) {
        this.number = number;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            try {
                sleep((int) (Math.random() * 5000));
            } catch (InterruptedException e) {
                System.err.println(number + " a ete interrompu.");
            }
            System.out.println(number + " : " + i);
        }
        System.out.println("Toto  " + number + " a fini de compter jusqu'à " + 10);
    }

}
