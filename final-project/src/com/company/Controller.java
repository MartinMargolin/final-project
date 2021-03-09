package com.company;

import models.Board;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Controller {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    int turnRotation;
    int turn;
    Board B1 = new Board();
    Board B2 = new Board();

    // Rotation from center 1,2,3,4
    //1 = up
    //2 = down
    //3 = left
    //4 = right

    public void run() {
        /*Board board = new Board();
        board.printBoard("a", "b");
        board.setPiece(5, 1, 4, 4);
        board.printBoard("a", "b");
        System.out.println(board.checkPieceOK(5, 4, 4, 7));*/

        mainMenu();
    }

    public void playerVPlayer() {
        String in;

        System.out.println("Player one enter name ");

        in = input();
        if (!in.equals("")) {
            B1.setName(in);
        } else {
            B1.setName("Player1");
        }

        System.out.println("Player two enter name ");

        in = input();
        if (!in.equals("")) {
            B2.setName(in);
        } else {
            B2.setName("Player2");
        }

        int game = 1;

        // Create Method to place pieces and call it here
        player1PlacePieces();
        player2PlacePieces();

        do {

            switch (turnRotation) {

                case 1:
                    /*B2.printBoard(B1.getName(), B2.getName());
                    turn = promptForInt("\n\n" + B1.getName() + " drop a bomb!! (///): ", 1, 8);*/

                    /*try {
                        board.placePiece(P1.getColor(), turn);
                    } catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
                        System.out.println("Your move was invalid. " + "\n" + "Try again!!");
                    }

                    if (board.checkWinner(P1.getColor())) {
                        System.out.println("Player:" + P1.getName() + " has won the game!");
                        game = 0;
                        break;
                    }*/

                    turnRotation = 2;
                    break;

                case 2:
                    /*B1.printBoard(B1.getName(), B2.getName());
                    turn = promptForInt("\n\n" + B2.getName() + " drop a bomb!! (///): ", 1, 8);*/

                    /*try {
                        board.placePiece(P2.getColor(), turn);
                    } catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
                        System.out.println("Your move was invalid. " + "\n" + "Try again!!");
                    }

                    if (board.checkWinner(P2.getColor())) {
                        System.out.println("Player:" + P2.getName() + " has won the game!");
                        game = 0;
                        break;
                    }*/

                    turnRotation = 1;
                    break;
            }
        } while (game == 1);
    }

    public void mainMenu() {
        System.out.println("\n\n");
        String mainMenu = new StringBuilder("Main Menu\n\n").
                append("1) Player vs. Player\n").
                append("0) Exit\n\n").append("Enter the number of your selection: ").toString();
        int minOption = 0;
        int maxOption = 1;
        int userChoice;


        do {
            userChoice = promptForInt(mainMenu, minOption, maxOption);
            switch (userChoice) {
                case 1:
                    playerVPlayer();
                    /*prompt =  promptForInt("Would you like to play again? \n 1: Yes    0: No \n", 0,1);
                    if(prompt == 0)
                    {
                        userChoice = 0;
                        break;
                    } else
                    {
                        break;
                    }*/
            }
        } while (userChoice > 0);
    }

    public int positionMenu() {
        System.out.println("\n\n");
        String mainMenu = new StringBuilder("Position Menu\n\n").
                append("1) Up\n").
                append("2) Down\n").
                append("3) Left\n").
                append("4) Right\n").
                append("0) Exit\n\n").append("Enter the number of your selection: ").toString();
        int minOption = 0;
        int maxOption = 4;

        return promptForInt(mainMenu, minOption, maxOption);
    }

    private int promptForInt(String prompt, int min, int max) {
        if (min > max) {
            throw new IllegalArgumentException("The min cannot be greater than the max. min: " + min + ", max: " + max);
        }

        int userNum = -1;
        String input = null;
        boolean isInvalid = true;

        do {
            System.out.print(prompt);
            try {
                input = bufferedReader.readLine();
                userNum = Integer.parseInt(input);
                isInvalid = userNum < min || userNum > max;
            } catch (IOException ioe) {
                System.out.println("Whoa! Something technical went wrong. Let's try that again.");
            } catch (NumberFormatException nfe) {

            }

            if (isInvalid) {
                System.out.println("You entered an invalid value. Please, try again.");
            }
        } while (isInvalid);

        return userNum;
    }

    public String input() {
        System.out.print("Input: ");
        String input = "";
        try {
            input = bufferedReader.readLine();
        } catch (Exception e) {
            System.out.println("Slow down there pal lets try that again...");
        }
        System.out.println(input);
        return input;
    }

    public void player1PlacePieces() {
        int xAxis = 0;
        int yAxis = 0;
        int game = 1;
        turnRotation = 1;
        do {

            switch (turnRotation) {

                case 1:
                    // Place 5 Piece
                    System.out.println("\n" + B1.getName() + " place your 5-length ship!");

                    B1.printBoard(B1.getName(), B2.getName());
                    System.out.println("\n" + "Choose which way your ship faces.");
                    int position = positionMenu();
                    xAxis = promptForInt("\n\n" + B1.getName() + " place your piece (1-8) x-axis: ", 1, 8);
                    yAxis = promptForInt("\n\n" + B1.getName() + " place your piece (1-8) y-axis: ", 1, 8);
                    if (B1.checkPieceOK(5, position, xAxis, yAxis)) {
                        B1.setPiece(5, position, xAxis, yAxis);

                        B1.printBoard(B1.getName(), B2.getName());

                        turnRotation = 2;
                    } else {
                        System.out.println("Invalid piece place!" + "\n" + "Try again.");
                        turnRotation = 1;
                    }
                    break;

                case 2:
                    // Place 4 Piece
                    System.out.println("\n" + B1.getName() + " place your 4-length ship!");

                    System.out.println("\n" + "Choose which way your ship faces.");
                    position = positionMenu();
                    xAxis = promptForInt("\n\n" + B1.getName() + " place your piece (1-8) x-axis: ", 1, 8);
                    yAxis = promptForInt("\n\n" + B1.getName() + " place your piece (1-8) y-axis: ", 1, 8);

                    if (B1.checkPieceOK(4, position, xAxis, yAxis)) {
                        B1.setPiece(4, position, xAxis, yAxis);

                        B1.printBoard(B1.getName(), B2.getName());

                        turnRotation = 3;
                    } else {
                        System.out.println("Invalid piece place!" + "\n" + "Try again.");
                        turnRotation = 2;
                        B1.printBoard(B1.getName(), B2.getName());
                    }
                    break;
                case 3:
                    // Place 3 Piece
                    System.out.println("\n" + B1.getName() + " place your 3-length ship!");

                    System.out.println("\n" + "Choose which way your ship faces.");
                    position = positionMenu();
                    xAxis = promptForInt("\n\n" + B1.getName() + " place your piece (1-8) x-axis: ", 1, 8);
                    yAxis = promptForInt("\n\n" + B1.getName() + " place your piece (1-8) y-axis: ", 1, 8);

                    if (B1.checkPieceOK(3, position, xAxis, yAxis)) {
                        B1.setPiece(3, position, xAxis, yAxis);

                        B1.printBoard(B1.getName(), B2.getName());

                        turnRotation = 4;
                    } else {
                        System.out.println("Invalid piece place!" + "\n" + "Try again.");
                        turnRotation = 3;
                        B1.printBoard(B1.getName(), B2.getName());
                    }
                    break;
                case 4:
                    // Place 3 Piece
                    System.out.println("\n" + B1.getName() + " place your 3-length ship!");

                    System.out.println("\n" + "Choose which way your ship faces.");
                    position = positionMenu();
                    xAxis = promptForInt("\n\n" + B1.getName() + " place your piece (1-8) x-axis: ", 1, 8);
                    yAxis = promptForInt("\n\n" + B1.getName() + " place your piece (1-8) y-axis: ", 1, 8);

                    if (B1.checkPieceOK(3, position, xAxis, yAxis)) {
                        B1.setPiece(3, position, xAxis, yAxis);

                        B1.printBoard(B1.getName(), B2.getName());

                        turnRotation = 5;
                    } else {
                        System.out.println("Invalid piece place!" + "\n" + "Try again.");
                        turnRotation = 4;
                        B1.printBoard(B1.getName(), B2.getName());
                    }
                    break;
                case 5:
                    // Place 2 Piece
                    System.out.println("\n" + B1.getName() + " place your 2-length ship!");

                    System.out.println("\n" + "Choose which way your ship faces.");
                    position = positionMenu();
                    xAxis = promptForInt("\n\n" + B1.getName() + " place your piece (1-8) x-axis: ", 1, 8);
                    yAxis = promptForInt("\n\n" + B1.getName() + " place your piece (1-8) y-axis: ", 1, 8);

                    if (B1.checkPieceOK(2, position, xAxis, yAxis)) {
                        B1.setPiece(2, position, xAxis, yAxis);

                        B1.printBoard(B1.getName(), B2.getName());

                        turnRotation = 6;
                    } else {
                        System.out.println("Invalid piece place!" + "\n" + "Try again.");
                        turnRotation = 5;
                        B1.printBoard(B1.getName(), B2.getName());
                    }
            }
        } while (game == 1);
    }

    public void player2PlacePieces() {
        // Place 5 Piece
        int xAxis = 0;
        int yAxis = 0;
        System.out.println("\n" + B2.getName() + " place your 5-length ship!");

        B2.printBoard(B1.getName(), B2.getName());
        System.out.println("\n" + "Choose which way your ship faces.");
        int position = positionMenu();
        xAxis = promptForInt("\n\n" + B2.getName() + " place your piece (1-8) x-axis: ", 1, 8);
        yAxis = promptForInt("\n\n" + B2.getName() + " place your piece (1-8) y-axis: ", 1, 8);

        if (B2.checkPieceOK(5, position, xAxis, yAxis)) {
            B2.setPiece(5, position, xAxis, yAxis);
        } else {
            System.out.println("Invalid piece place!" + "\n" + "Try again.");
        }
        B2.printBoard(B1.getName(), B2.getName());

        // Place 4 Piece
        System.out.println("\n" + B2.getName() + " place your 4-length ship!");

        System.out.println("\n" + "Choose which way your ship faces.");
        position = positionMenu();
        xAxis = promptForInt("\n\n" + B2.getName() + " place your piece (1-8) x-axis: ", 1, 8);
        yAxis = promptForInt("\n\n" + B2.getName() + " place your piece (1-8) y-axis: ", 1, 8);

        if (B2.checkPieceOK(4, position, xAxis, yAxis)) {
            B2.setPiece(4, position, xAxis, yAxis);
        } else {
            System.out.println("Invalid piece place!" + "\n" + "Try again.");
        }
        B2.printBoard(B1.getName(), B2.getName());

        // Place 3 Piece
        System.out.println("\n" + B2.getName() + " place your 3-length ship!");

        System.out.println("\n" + "Choose which way your ship faces.");
        position = positionMenu();
        xAxis = promptForInt("\n\n" + B2.getName() + " place your piece (1-8) x-axis: ", 1, 8);
        yAxis = promptForInt("\n\n" + B2.getName() + " place your piece (1-8) y-axis: ", 1, 8);

        if (B2.checkPieceOK(3, position, xAxis, yAxis)) {
            B2.setPiece(3, position, xAxis, yAxis);
        } else {
            System.out.println("Invalid piece place!" + "\n" + "Try again.");
        }
        B2.printBoard(B1.getName(), B2.getName());

        // Place 3 Piece
        System.out.println("\n" + B2.getName() + " place your 3-length ship!");

        System.out.println("\n" + "Choose which way your ship faces.");
        position = positionMenu();
        xAxis = promptForInt("\n\n" + B2.getName() + " place your piece (1-8) x-axis: ", 1, 8);
        yAxis = promptForInt("\n\n" + B2.getName() + " place your piece (1-8) y-axis: ", 1, 8);

        if (B2.checkPieceOK(3, position, xAxis, yAxis)) {
            B2.setPiece(3, position, xAxis, yAxis);
        } else {
            System.out.println("Invalid piece place!" + "\n" + "Try again.");
        }
        B2.printBoard(B1.getName(), B2.getName());

        // Place 2 Piece
        System.out.println("\n" + B2.getName() + " place your 2-length ship!");

        System.out.println("\n" + "Choose which way your ship faces.");
        position = positionMenu();
        xAxis = promptForInt("\n\n" + B2.getName() + " place your piece (1-8) x-axis: ", 1, 8);
        yAxis = promptForInt("\n\n" + B2.getName() + " place your piece (1-8) y-axis: ", 1, 8);

        if (B2.checkPieceOK(2, position, xAxis, yAxis)) {
            B2.setPiece(2, position, xAxis, yAxis);
        } else {
            System.out.println("Invalid piece place!" + "\n" + "Try again.");
        }
        B2.printBoard(B1.getName(), B2.getName());
    }
}
