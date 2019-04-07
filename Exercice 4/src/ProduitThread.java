/**
 * Created by moham on 08/03/2019.
 */
class ProduitThread extends Thread {
    public int row;
    public int col;
    Matrix m;
    Matrix m1;

    ProduitThread(int row, int col, Matrix m, Matrix m1) {
        this.row = row;
        this.col = col;
        this.m = m;
        this.m1 = m1;
    }

    public void run() {

        int tmp = 0;
        for (int i = 0; i < 2; i++) {
            tmp = tmp + this.m.getV()[row][i] * this.m1.getV()[i][col];
        }
        ResMatrix.arrres[row][col] = tmp;

    }

}