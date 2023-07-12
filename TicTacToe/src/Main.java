import afterTDD.TicTacToe;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        afterTDD.TicTacToe.initBoard();
        System.out.println("X will play first. Enter a slot number to place X in:");
        while (afterTDD.TicTacToe.getWinner() == null)
        {
            afterTDD.TicTacToe.play();
        }
        if(afterTDD.TicTacToe.getWinner().equals("draw"))
            System.out.println("It's a draw");
        else
            System.out.println("The winner is " + afterTDD.TicTacToe.getWinner());
    }
}
