public class Main {


    public static void main(String[]args) throws InterruptedException {

        Matrix mm = new Matrix();
        mm.setV(1);
        Matrix mm1 = new Matrix();
        mm1.setV(2);

        for(int i=0;i<2;i++) {
            for(int j=0;j<2;j++) {
                ProduitThread mul = new ProduitThread(i,j,mm,mm1);
                mul.start();
                mul.join();
            }
        }

        for(int i=0;i<2;i++) {
            for(int j=0;j<2;j++) {
                System.out.println("VALUE: "+ResMatrix.arrres[i][j]);
            }
        }


    }

}