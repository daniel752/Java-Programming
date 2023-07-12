package afterTDD;
import java.util.*;

public class TicTacToe
{
    static String[] board;
    static String turn;
    static String winner = null;

    public static void initBoard()
    {
        board = new String[9];
        turn = "X";
        for (int i = 0; i < 9; i++)
        {
            board[i] = String.valueOf(i + 1);
        }
        System.out.println("Welcome to 3x3 Tic Tac Toe.");
        printBoard();
    }
    public static void play()
    {
        int numInput;
        Scanner in = new Scanner(System.in);
        // Exception handling.
        // numInput will take input from user like from 1 to 9.
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

        // This game has two player x and O.
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

            TicTacToe.printBoard();
            winner = TicTacToe.checkWinner();
        }
        else {
            System.out.println(
                    "Slot already taken; re-enter slot number:");
        }
    }
    public static String checkWinner()
    {
        for (int a = 0; a < 8; a++) {
            String line = null;

            switch (a) {
                case 0:
                    line = board[0] + board[1] + board[2];
                    break;
                case 1:
                    line = board[3] + board[4] + board[5];
                    break;
                case 2:
                    line = board[6] + board[7] + board[8];
                    break;
                case 3:
                    line = board[0] + board[3] + board[6];
                    break;
                case 4:
                    line = board[1] + board[4] + board[7];
                    break;
                case 5:
                    line = board[2] + board[5] + board[8];
                    break;
                case 6:
                    line = board[0] + board[4] + board[8];
                    break;
                case 7:
                    line = board[2] + board[4] + board[6];
                    break;
            }
            //For X winner
            if (line.equals("XXX")) {
                winner = "X";
                return winner;
            }

            // For O winner
            else if (line.equals("OOO")) {
                winner = "O";
                return winner;
            }
        }
        for (int i = 0; i < 9; i++) {
            if (Arrays.asList(board).contains(String.valueOf(i + 1))) {
                break;
            }
            else if (i == 8) {
                winner = "draw";
                return winner;
            }
        }
        // To enter the X Or O at the exact place on board.
        System.out.println(turn + "'s turn; enter a slot number to place " + turn + " in:");
        return winner;
    }

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

    public static String[] getBoard()
    {
        return board;
    }

    public static String getTurn()
    {
        return turn;
    }

    public static String getWinner()
    {
        return winner;
    }

    public static void setBoard(String[] board)
    {
        TicTacToe.board = board;
    }

    public static void setTurn(String turn)
    {
        TicTacToe.turn = turn;
    }

    public static void setWinner(String winner)
    {
        TicTacToe.winner = winner;
    }
}
