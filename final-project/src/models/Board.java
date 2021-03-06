package models;

public class Board
{
    String name = "Player"; // default

    public void setName(String in) {
        System.out.println("Your player name is: " + in);
        name = in;
    }

    public String getName() {
        return name;
    }

    String[][] board = new String[][]
            {
                    {"~", "~", "~", "~", "~", "~", "~", "~"},
                    {"~", "~", "~", "~", "~", "~", "~", "~"},
                    {"~", "~", "~", "~", "~", "~", "~", "~"},
                    {"~", "~", "~", "~", "~", "~", "~", "~"},
                    {"~", "~", "~", "~", "~", "~", "~", "~"},
                    {"~", "~", "~", "~", "~", "~", "~", "~"},
                    {"~", "~", "~", "~", "~", "~", "~", "~"},
                    {"~", "~", "~", "~", "~", "~", "~", "~"},

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

    public void setPiece(int pieceSize, int rotationFromCenter, int x, int y)
    {


    }

    public boolean checkPieceOK(int pieceSize, int rotationFromCenter, int x, int y)
    {
        for(int i = 0; i < pieceSize; i++)
        {
            int shift = 1;

            switch(rotationFromCenter) {
                case 1:
                    if (board[x][y + shift] == "○")
                    {
                        return false;

                    }
                    else
                    {
                        break;
                    }

                case 2:
                    if (board[x][y - shift] == "○")
                    {
                        return false;

                    }
                    else
                    {
                        break;
                    }
                case 3:
                    if (board[x - shift][y] == "○")
                    {
                        return false;
                    }

                    else
                    {
                        break;
                    }

                case 4:
                    if (board[x + shift][y] == "○")
                    {
                        return false;

                    }
                    else
                    {
                        break;
                    }
            }
        }
        return true;
    }

}
