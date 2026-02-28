import java.util.*;
public class TicTacToe {

    public static boolean isCellSafe(char puzzle[][], int r, int c) {
        return puzzle[r][c] == 'N';
    }

    public static void printBoard(char puzzle[][]) {
        for(int i=0; i<3 ; i++){
            for(int j=0 ; j<3; j++){
                System.out.print(puzzle[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        char puzzle[][] = {{'N', 'N', 'N'},
                           {'N', 'N', 'N'},
                           {'N', 'N', 'N'}};
        printBoard(puzzle);
        
        while(true) {
            System.out.println("1st player enter the cell");
            int r1 = sc.nextInt() - 1;
            int c1 = sc.nextInt() - 1;

            if(r1 < 0 || r1 > 2 || c1 < 0 || c1 > 2 || !isCellSafe(puzzle, r1, c1)) {
                System.out.println("Invalid move!");
                continue;
            }

            puzzle[r1][c1] = 'X';
            printBoard(puzzle);

            System.out.println("Player 2 (O) enter row and column (1-3):");
            int r2 = sc.nextInt() - 1;
            int c2 = sc.nextInt() - 1;

            if(r2 < 0 || r2 > 2 || c2 < 0 || c2 > 2 || !isCellSafe(puzzle, r2, c2)) {
                System.out.println("Invalid move!");
                continue;
            }

            puzzle[r2][c2] = 'O';
            printBoard(puzzle);
        }
    }
}
