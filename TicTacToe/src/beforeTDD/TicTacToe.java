package beforeTDD;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TicTacToe
{
    static String[] board;
    static String turn;
    static String winner = null;

    /*
    public static void initBoard()
    {
        method to be implemented with TDD
    }
     */
    public static void play()
    {
        int numInput;
        Scanner in = new Scanner(System.in);
        // Exception handling.
        // User can input in range of 1 to 9.
        // If it is not in range from 1 to 9.
        // then it will show you an error "Invalid input."
        try {
            numInput = in.nextInt();
            if (!(numInput > 0 && numInput <= 9)) {
                System.out.println("Invalid input; re-enter slot number:");
                return;
            }
        }
        catch (InputMismatchException e) {
            System.out.println("Invalid input; re-enter slot number:");
            return;
        }

        // This game has two players x and O.
        // Here is the logic to decide the turn.
        if (TicTacToe.board[numInput - 1].equals(
                String.valueOf(numInput))) {
            TicTacToe.board[numInput - 1] = TicTacToe.turn;

            if (TicTacToe.turn.equals("X")) {
                TicTacToe.turn = "O";
            }
            else {
                TicTacToe.turn = "X";
            }

            beforeTDD.TicTacToe.printBoard();
            //winner = beforeTDD.TicTacToe.checkWinner();
        }
        else {
            System.out.println("Slot already taken; re-enter slot number:");
        }
    }
    /*
    static String checkWinner()
    {
        method to be implemented with TDD
    }
     */

    // To print out the board.
	/* |---|---|---|
	   | 1 | 2 | 3 |
	   |-----------|
	   | 4 | 5 | 6 |
	   |-----------|
	   | 7 | 8 | 9 |
       |---|---|---|*/

    public static void printBoard()
    {
        System.out.println("|---|---|---|");
        System.out.println("| " + board[0] + " | " + board[1] + " | " + board[2] + " |");
        System.out.println("|-----------|");
        System.out.println("| " + board[3] + " | " + board[4] + " | " + board[5] + " |");
        System.out.println("|-----------|");
        System.out.println("| " + board[6] + " | " + board[7] + " | " + board[8] + " |");
        System.out.println("|---|---|---|");
    }
}
