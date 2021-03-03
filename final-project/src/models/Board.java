package models;

public class Board
{

    String[][] board = new String[][]
            {
                    {"0", "0", "0", "0", "0", "0", "0", "0"},
                    {"0", "0", "0", "0", "0", "0", "0", "0"},
                    {"0", "0", "0", "0", "0", "0", "0", "0"},
                    {"0", "0", "0", "0", "0", "0", "0", "0"},
                    {"0", "0", "0", "0", "0", "0", "0", "0"},
                    {"0", "0", "0", "0", "0", "0", "0", "0"},
                    {"0", "0", "0", "0", "0", "0", "0", "0"},
                    {"0", "0", "0", "0", "0", "0", "0", "0"},
            };

    // Pieces: | 5, 4, 3, 3, 2 | ○

    public boolean checkForHit(int x, int y)
    {

    return false;
    }

    public void printBoard(String p1, String p2) {
        System.out.println("---------------");
        System.out.println("     [ " + p1 + " ]" + " -- " + "[ " + p2 + " ]");
        for (int a = 0; a < 8; a++) {
            System.out.println();
            for (int i = 0; i < 8; i++) {
                System.out.print("[" + board[a][i] + "] ");
            }
        }
    }
}
