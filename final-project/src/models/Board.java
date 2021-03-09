package models;

public class Board {
    String name = "Player"; // default

    // Piece Initialization for multi-method use
    Piece P1 = new Piece(5);
    Piece P2 = new Piece(4);
    Piece P3 = new Piece(3);
    Piece P4 = new Piece(3);
    Piece P5 = new Piece(2);

    // Noting which piece to use next;
    int pNum = 1;


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

    String[][] atkBoard = new String[][]
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

    public int checkForHit(int x, int y) {
        int c = 1;
        do {
            switch (c)
            {
                case 1:
                    if (atkBoard[x - 1][y - 1] != "X")
                    {
                        atkBoard[x - 1][y - 1] = "X";
                        if (board[x - 1][y - 1] == "○")
                        {
                            board[x - 1][y - 1] = "X";
                            System.out.println("You Have Hit!");
                            c = 0;


                        } else {
                            System.out.println("You Have Missed!");
                            return 2;
                        }

                    }
                    else
                    {
                        System.out.println("You can't attack there, please try again.");
                        return 3;
                    }
            }
        }while(c == 1);
        return 1;
    }

    public void printAtkBoard()
    {
        System.out.println("---------------");
        System.out.println("          Attack          ");
        for (int a = 0; a < 8; a++) {
            System.out.println();
            for (int i = 0; i < 8; i++) {
                System.out.print("[" + atkBoard[a][i] + "] ");
            }
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

    public void setPiece(int pieceSize, int rotationFromCenter, int x, int y) {
        switch (pNum) {
            case 1:
                P1.setStats(pieceSize, rotationFromCenter, x, y);
            case 2:
                P2.setStats(pieceSize, rotationFromCenter, x, y);
            case 3:
                P3.setStats(pieceSize, rotationFromCenter, x, y);
            case 4:
                P4.setStats(pieceSize, rotationFromCenter, x, y);
            case 5:
                P5.setStats(pieceSize, rotationFromCenter, x, y);
        }
        x--;
        y--;
        int shift = 0;
        for (int i = 0; i < pieceSize; i++) {
            switch (rotationFromCenter) {
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

    public boolean checkPieceOK(int pieceSize, int rotationFromCenter, int x, int y) {
        x--;
        y--;
        int shift = 0;
        for (int i = 0; i < pieceSize; i++) {

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
            } catch (Exception e) {
                //System.out.println("This caught an out of bounds piece check");
                return false;

            }
            shift++;
        }
        return true;
    }

    public void atkFindPiece(int x, int y)
    {
        int pieceSize = 0;
        int rotationFromCenter = 0;
        x--;
        y--;
        int shift = 0;
        int a = 1;

        do{
            switch(a)
            {
                case 1:
                    if(P1.getX() == x && P1.getY() == y) {
                        pieceSize = P1.getPieceSize();
                        rotationFromCenter = P1.getRotationFromCenter();
                        a = 0;
                        break;
                    }
                    else
                    {
                        a++;
                        break;
                    }
                case 2:
                    if(P2.getX() == x && P2.getY() == y) {
                        pieceSize = P2.getPieceSize();
                        rotationFromCenter = P2.getRotationFromCenter();
                        a = 0;
                        break;
                    }
                case 3:
                    if(P3.getX() == x && P3.getY() == y) {
                        pieceSize = P3.getPieceSize();
                        rotationFromCenter = P3.getRotationFromCenter();
                        a = 0;
                        break;
                    } else
                    {
                        a++;
                        break;
                    }
                case 4:
                    if(P4.getX() == x && P4.getY() == y) {
                        pieceSize = P4.getPieceSize();
                        rotationFromCenter = P4.getRotationFromCenter();
                        a = 0;
                        break;
                    } else
                    {
                        a++;
                        break;
                    }
                case 5:
                    if(P5.getX() == x && P5.getY() == y) {
                        pieceSize = P5.getPieceSize();
                        rotationFromCenter = P5.getRotationFromCenter();
                        a = 0;
                        break;
                    } else
                    {
                        a++;
                        break;
                    }
            }

        }while(a != 0);

    }

    public void atkRecordPiece(int x, int y, int rotation, int size)
    {

    }

}
