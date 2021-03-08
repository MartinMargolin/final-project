package models;

public class Board
{
    String name = "Player"; // default

    public void setName(String in) {
        System.out.println("Your player name is: " + in);
        this.name = in;
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

    if(board[x-1][y-1] == "○")
    {
        board[x-1][y-1] = "X";
        System.out.println("You Have Hit!");
        return true;

    }
    else
    {
        System.out.println("You Have Missed!");
        return false;
    }

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
        int shift = 0;
        for(int i = 0; i < pieceSize; i++)
        {
            switch (rotationFromCenter)
            {
                case 1:
                    board[y - shift][x] = "○";
                    break;
                case 2:
                    board[y + shift][x] = "○";
                    break;
                case 3:
                    board[y][x - shift] = "○";
                    break;
                case 4:
                    board[y][x + shift] = "○";
                    break;
            }
            shift++;

        }

    }

    public boolean checkPieceOK(int pieceSize, int rotationFromCenter, int x, int y)
    {
        int shift = 0;
        for(int i = 0; i < pieceSize; i++)
        {

           // System.out.println(i);
           // System.out.println(shift);
            try {
                switch (rotationFromCenter) {
                    case 1:
                        if (board[y - shift][x] == "○") {
                            return false;

                        } else {
                            break;
                        }


                    case 2:
                        if (board[y + shift][x] == "○") {
                            return false;

                        } else {
                            break;
                        }
                    case 3:
                        if (board[y][x - shift] == "○") {
                            return false;
                        } else {
                            break;
                        }

                    case 4:
                        if (board[y][x + shift] == "○") {
                            return false;

                        } else {
                            break;
                        }
                }
            } catch(Exception e)
            {
                //System.out.println("This caught an out of bounds piece check");
                return false;

            }
            shift++;
        }
        return true;
    }

}
