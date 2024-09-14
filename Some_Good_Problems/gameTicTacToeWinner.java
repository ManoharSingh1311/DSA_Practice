/*
Problem Statement
Two players, player1 ('X') and player2 ('O'), play tic-tac-toe on a 3x3 grid. Given a list of moves, where each
move is a (row, column) pair, simulate the game.

player1 starts and alternates with player2.
The game ends when a player wins (three in a row, column, or diagonal), or all positions are filled.
Return:
"player1" if player1 wins.
"player2" if player2 wins.
"uncertain" if no winner yet and positions are still empty.
"draw" if all positions are filled with no winner.

 */
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

    public static String ticTacToeWinner(ArrayList<ArrayList<Integer>> moves, int n) {
        char[][] board = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }

        for (int i = 0; i < n; i++) {
            int row = moves.get(i).get(0);
            int col = moves.get(i).get(1);
            char player = (i % 2 == 0) ? 'X' : 'O';
            board[row][col] = player;
            if (checkWinner(board, player)) {
                return (player == 'X') ? "player1" : "player2";
            }
        }

        return (n == 9) ? "draw" : "uncertain";
    }

    private static boolean checkWinner(char[][] board, char player) {
        for (int i = 0; i < 3; i++) {
            if ((board[i][0] == player && board[i][1] == player && board[i][2] == player) ||
                (board[0][i] == player && board[1][i] == player && board[2][i] == player)) {
                return true;
            }
        }
        return (board[0][0] == player && board[1][1] == player && board[2][2] == player) ||
               (board[0][2] == player && board[1][1] == player && board[2][0] == player);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); // Number of test cases
        while (t-- > 0) {
            int n = sc.nextInt(); // Number of moves
            ArrayList<ArrayList<Integer>> moves = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                int row = sc.nextInt();
                int col = sc.nextInt();
                ArrayList<Integer> move = new ArrayList<>();
                move.add(row);
                move.add(col);
                moves.add(move);
            }
            String result = ticTacToeWinner(moves, n);
            System.out.println(result);
        }
        sc.close();
    }
}
