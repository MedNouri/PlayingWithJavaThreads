
public class Compte {
    private int solde = 0;

    public synchronized void ajouter(int somme) {
        solde += somme;
        System.out.println(" Ajoute  " + somme);
    }

    public synchronized void retirer(int somme) {
        solde -= somme;
        System.out.println(" Retire  " + somme);
    }

    public synchronized void operationNulle(int somme) {
        solde += somme;
        System.out.println(" Ajoute  " + somme);
        solde -= somme;
        System.out.println(" Retire  " + somme);
    }

    public synchronized int getSolde() {
        return solde;
    }
}
