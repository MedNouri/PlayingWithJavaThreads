public class Trieur extends Thread {

    private int[] t;
    private int start, fin;
    private Trieur parent;
    private int nbNotify = 0;

    public Trieur(int[] t) {
        this(null, t, 0, t.length - 1);
    }

    public Trieur(Trieur f, int[] t, int s, int e) {
        this.parent = f;
        this.t = t;
        this.start = s;
        this.fin = e;
        start();
    }

    public synchronized void notifier() {

        this.nbNotify++;
        this.notifyAll();
    }

    public void run() {
        if (fin - start < 2) {
            if (t[start] > t[fin]) {
                echanger(start, fin);
            }
        }
        else {
            int milieu = start + (fin - start) / 2;
             new Trieur(this, t, start, milieu);
             new Trieur(this, t, milieu + 1, fin);

            synchronized(this) {
                try {

                    while (nbNotify < 2) {
                        wait();
                    }
                }
                catch(InterruptedException e) {
                    System.out.print(e);
                }
            }
            triFusion(start, fin);
        }
        if (parent != null) {
            parent.notifier();
        }
    }

    /**
     * Echanger t[i] et t[j]
     */
    private void echanger(int i, int j) {
        int valeur = t[i];
        t[i] = t[j];
        t[j] = valeur;
    }

    /**
     * Fusionne 2 tranches déjà triées du tableau t.
     *   - 1ère tranche : de anInt à milieu
     *   - 2ème tranche : de milieu + 1 à fin
     * @param milieu indique le dernier indice de la 1ère tranche
     */
    private void triFusion(int debut, int fin) {
        // tableau où va aller la fusion
        int[] tFusion = new int[fin - debut + 1];
        int milieu = (debut + fin) / 2;
        // Indices des éléments à comparer
        int i1 = debut,
                i2 = milieu + 1;
        // indice de la prochaine case du tableau tFusion à remplir
        int iFusion = 0;
        while (i1 <= milieu && i2 <= fin) {
            if (t[i1] < t[i2]) {
                tFusion[iFusion++] = t[i1++];
            }
            else {
                tFusion[iFusion++] = t[i2++];
            }
        }
        if (i1 > milieu) {
            // la 1ère tranche est épuisée
            for (int i = i2; i <= fin; ) {
                tFusion[iFusion++] = t[i++];
            }
        }
        else {

            for (int i = i1; i <= milieu; ) {
                tFusion[iFusion++] = t[i++];
            }
        }

        for (int i = 0, j = debut; i <= fin - debut; ) {
            t[j++] = tFusion[i++];
        }
    }
    public static void main(String[] args) {
        int[] t = {5, 8, 3, 2, 7, 10, 1};
        Trieur trieur = new Trieur(t);
        try {
            trieur.join();
        }
        catch(InterruptedException e) {}
        for (int i = 0; i <t.length; i++) {
            System.out.println(t[i] );
        }
        System.out.println();
    }

}
