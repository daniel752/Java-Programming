package tests;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class TicTacToeTest
{

    //Method 1: initBoard() TDDs
//    @Test
//    public void checkBoardType()
//    {
//        String[] board = new String[9];
//        assertEquals(String[].class.arrayType(), board.getClass().arrayType());
//    }
//    @Test
//    public void checkBoardSize()
//    {
//        int numSlots = 9;
//        String[] board = new String[numSlots];
//        assertEquals(numSlots, board.length);
//    }
//
//    @Test
//    public void checkTurn()
//    {
//        String turn = "X";
//        assertEquals("X", turn);
//    }

    @Test
    public void checkInitBoard()
    {
        int numSlots = 9;
        String[] board = new String[numSlots];
        for (int i = 0; i < 9; i++)
        {
            board[i] = String.valueOf(i+1);
        }
        for (int i = 0; i < 9; i++)
        {
            assertEquals(String.valueOf(i+1), board[i]);
        }
    }

    //Method 2: checkWinner TDDs
//    @Test
//    public void checkXLine()
//    {
//        String line = "XXX";
//        assertEquals("XXX", line);
//    }
//
//    @Test
//    public void checkWinnerXLine()
//    {
//        String line = null;
//        String[] board = new String[9];
//        board[0] = "X";
//        board[1] = "X";
//        board[2] = "X";
//        line = board[0] + board[1] + board[2];
//        assertEquals("XXX", line);
//    }
//
//    @Test
//    public void checkWinnerXLineDiagonal()
//    {
//        String line = null;
//        int numSlots = 9;
//        String[] board = new String[numSlots];
//        for (int i = 0; i < 9; i++)
//        {
//            board[i] = String.valueOf(i + 1);
//        }
//        board[0] = "X";
//        board[4] = "X";
//        board[8] = "X";
//        line = board[0] + board[4] + board[8];
//        assertEquals("XXX", line);
//    }

    @Test
    public void checkDrawSituation()
    {
        String line = null;
        String expected = "draw";
        String actual = "";
        int numSlots = 9;
        String[] board = new String[numSlots];
        for (int i = 0; i < 9; i++)
        {
            board[i] = String.valueOf(i + 1);
        }
        board[0] = "X";
        board[1] = "X";
        board[2] = "O";
        board[3] = "X";
        board[4] = "X";
        board[5] = "O";
        board[6] = "O";
        board[7] = "O";
        board[8] = "X";
        for (int a = 0; a < 8; a++)
        {
            switch (a)
            {
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
            if (!line.equals("XXX") && !line.equals("OOO"))
            {
                actual = "draw";
            }
            assertEquals(expected, actual);
        }
    }
}