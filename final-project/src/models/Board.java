package models;

public class Board {
    String name = "Player"; // default

    // Piece Initialization for multi-method use
    Piece P1 = new Piece(5);
    Piece P2 = new Piece(4);
    Piece P3 = new Piece(3);
    Piece P4 = new Piece(3);
    Piece P5 = new Piece(2);

    int totalHealth = 17;

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

    public boolean checkForHit(int x, int y) {
        int c = 1;
        do {
            switch (c) {
                case 1:

                    if (board[y - 1][x - 1] == "○") {
                        board[y - 1][x - 1] = "!!";
                        System.out.println("You Have Hit!");
                        totalHealth--;
                        c = 0;


                    } else {
                        System.out.println("You Have Missed!");
                        return false;
                    }

            }

        } while (c == 1);
        return true;
    }

    public boolean checkAtkBoard(int x, int y) {
        if (atkBoard[y - 1][x - 1] == "X" || atkBoard[y-1][x-1] == "!!" ) {
            System.out.println("You have already attacked here, try again.");
            return false;
        } else {
            atkBoard[y - 1][x - 1] = "X";
            return true;
        }
    }

    public void atkBoardHit(int x, int y) {
        atkBoard[y - 1][x - 1] = "!!";
    }


    public void printAtkBoard() {
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

    public int getTotalHealth() {

        return this.totalHealth;

    }
}