package src.Matrix;

public class MATRIXDiagonally {
    static void printMatrixDiagonal(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int i,j;

        for(int k=0;k<=m-1;k++) {
            i = k;
            j = 0;

            while(i>=0) {
                System.out.print(mat[i][j] + " ");
                i = i-1;
                j = j+1;
            }
        }

        for(int k=1;k<=n-1;k++){
            j = k;
            i = m-1;

            while(j<=n-1) {
                System.out.print(mat[i][j] + " ");
                i = i-1;
                j = j+1;
            }
        }
    }

    public static void main(String[] args) {
        int mat[][] = { { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 } };

        printMatrixDiagonal(mat);
    }
}
