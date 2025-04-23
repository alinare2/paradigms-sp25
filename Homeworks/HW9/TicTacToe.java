import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
    private char[][] board = new char[3][3];
    private Scanner scanner = new Scanner(System.in);
    private Random random = new Random();

    public TicTacToe(){

    }

    public void printBoard() {
        
        for (int i = 0; i < 3; i++) {
            
            for (int j = 0; j < 3; j++) {
                char pos = board[i][j];
                if (pos == '\u0000') pos = ' ';

                if (j==2){
                    System.out.print(" " + pos);
                }
                else {
                    System.out.print(" "+ pos + " |");
                }
            }
            if (i == 2){ 
                System.out.println();
                break;
            }
            System.out.println("\n---+---+---");
        }
    }

    public boolean placeMove(int pos, char player) {
        int row = (pos - 1) / 3;
        int col = (pos - 1) % 3;
        if (pos < 1 || pos > 9 || board[row][col] != '\u0000') {
            return false;
        }
        board[row][col] = player;
        return true;
    }

    public void userMove() {
        int pos;
        while (true) {
            System.out.print("Enter position (1--9): ");
            pos = scanner.nextInt();
            if (placeMove(pos, 'X')) break;
            System.out.println("Invalid move, try again.");
        }
    }

    public void computerMove() {
        int pos;
        while (true) {
            pos = random.nextInt(9) + 1;
            if (placeMove(pos, 'O')) break;
        }
        System.out.println("Computer played " + pos);
    }

    public boolean checkWin(char player) {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player) return true;
            if (board[0][i] == player && board[1][i] == player && board[2][i] == player) return true;
        }
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) return true;
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) return true;
        return false;
    }

    private boolean isDraw() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '\u0000') return false;
            }
        }
        return true;
    }

    private boolean isGameOver(char player){
        if (checkWin(player)) {
            if (player == 'X') System.out.println("Player 1 has won!");
            else System.out.println("Computer has won!");
            return true;
        }
        if (isDraw()) {
            System.out.println("Draw!");
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        TicTacToe main = new TicTacToe();

        main.printBoard();
        while (true) {
            main.userMove();
            main.printBoard();
            if (main.isGameOver('X')) break;
            main.computerMove();
            main.printBoard();
            if(main.isGameOver('O')) break;
        }
    }
}
