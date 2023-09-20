package src.Matrix;

public class MATRIXSpiral {
    static void printMatrixSpiral(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        int minr = 0;
        int minc = 0;
        int maxr = m-1;
        int maxc = n-1;
        int count =0, tne = m*n;

        while(count<tne) {
            //top wall
            for (int j = minc, i = minr; j <=maxc && count<tne ; j++) {
                System.out.print(mat[i][j] + " ");
                count++;
            }
            minr++;

            //right wall
            for (int i = minr, j = maxc; i <=maxr && count<tne ; i++) {
                System.out.print(mat[i][j] + " ");
                count++;
            }
            maxc--;

            //bottom wall
            for (int j = maxc, i = maxr; j >=minc && count<tne ; j--) {
                System.out.print(mat[i][j] + " ");
                count++;
            }
            maxr--;

            //left wall
            for (int i = maxr, j = minc; i >=minr && count<tne ; i--) {
                System.out.print(mat[i][j] + " ");
                count++;
            }
            minc++;
        }
    }

    public static void main(String[] args) {
        int mat[][] = { { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 } };

        int mat1[][] = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};

        printMatrixSpiral(mat);

        System.out.println(" ");

        printMatrixSpiral(mat1);
    }
}
