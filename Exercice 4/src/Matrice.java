/**
 * Created by moham on 08/03/2019.
 */
class ResMatrix{

    static int[][] arrres = new int[2][2];
}

class Matrix{

    int [][] arr = new int[2][2];

    void setV(int v) {
        //int tmp = v;
        for(int i=0;i<2;i++) {
            for(int j=0;j<2;j++) {
                arr[i][j] = v;
                v = v + 1;
            }
        }
    }
    int [][] getV(){
        return arr;
    }
}



