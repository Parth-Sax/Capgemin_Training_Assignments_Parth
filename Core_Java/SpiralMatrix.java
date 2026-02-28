import java.util.*;
public class SpiralMatrix {
    public static void printSpiral(int matrix[][]) {
        int sr = 0;
        int er = matrix.length - 1;
        int sc = 0;
        int ec = matrix[0].length - 1;

        while(sr <= er && sc <= ec) {
            for(int j=sc; j<=ec; j++) {
                System.out.print(matrix[sr][j] + " ");
            }

            for(int i=sr+1; i<=er; i++) {
                System.out.print(matrix[i][ec] + " ");
            }

            for(int j=ec-1; j>=sc; j--) {
                System.out.print(matrix[er][j] + " ");
            }

            for(int i=er-1; i>=sr+1; i--) {
                System.out.print(matrix[i][sc] + " ");
            }

            sr++;
            sc++;
            er--;
            ec--;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of rows in the matrix");
        int n = sc.nextInt();

        System.out.println("Enter the number of colummns in the matrix");
        int m = sc.nextInt();

        int matrix[][] = new int[n][m];

        System.out.println("Enter the elements in the matrix");
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        printSpiral(matrix);
    }
}
