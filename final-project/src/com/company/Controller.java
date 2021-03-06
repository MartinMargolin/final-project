package com.company;

import models.Board;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Controller {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    int turnRotation;
    Board B1 = new Board();
    Board B2 = new Board();

    // Rotation from center 1,2,3,4
    // 1 = up
    // 2 = down
    // 3 = left
    // 4 = right

    public void run() {
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

        int xAxis = 0;
        int yAxis = 0;

        // Method to place pieces
        playerPlacePieces();

        System.out.println("\n\n" + B1.getName() + " goes first!");
        turnRotation = 1;
        do {

            switch (turnRotation) {

                // Hits
                // 1 - hit
                // 2 - missed
                // 3 - repeat atk

                case 1:
                    System.out.println("\n\n" + B1.getName() + " time to attack!");

                    B1.printAtkBoard();

                    xAxis = promptForInt("\n\n" + B1.getName() + " drop a bomb!! (1-8) x-axis: ", 1, 8);
                    yAxis = promptForInt("\n\n" + B1.getName() + " drop a bomb!! (1-8) y-axis: ", 1, 8);
                    if (B1.checkAtkBoard(xAxis, yAxis) == true) {
                        if (B2.checkForHit(xAxis, yAxis) == true) {
                            B1.atkBoardHit(xAxis, yAxis);
                            if (B2.getTotalHealth() == 0) {
                                System.out.println(B1.getName() + " has sunk " + B2.getName() + "'s battleships!");
                                game = 0;

                            }

                            turnRotation = 1;
                        } else if (B2.checkForHit(xAxis, yAxis) == false) {
                            /*System.out.println("You missed!");*/
                            turnRotation = 2;
                        }
                    } else {
                        turnRotation = 1;
                    }
                    break;

                    /*try {
                        board.placePiece(P1.getColor(), turn);
                    } catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
                        System.out.println("Your move was invalid. " + "\n" + "Try again!!");
                    }

                    if (board.checkWinner(P1.getColor())) {
                        System.out.println("Player:" + P1.getName() + " has won the game!");
                        game = 0;
                        break;
                    }

                    turnRotation = 2;
                    break;*/

                case 2:
                    System.out.println("\n\n" + B2.getName() + " time to attack!");

                    B2.printAtkBoard();

                    xAxis = promptForInt("\n\n" + B2.getName() + " drop a bomb!! (1-8) x-axis: ", 1, 8);
                    yAxis = promptForInt("\n\n" + B2.getName() + " drop a bomb!! (1-8) y-axis: ", 1, 8);
                    if (B2.checkAtkBoard(xAxis, yAxis) == true) {
                        if (B1.checkForHit(xAxis, yAxis) == true) {

                            B2.atkBoardHit(xAxis, yAxis);
                            if (B1.getTotalHealth() == 0) {
                                System.out.println(B2.getName() + " has sunk " + B1.getName() + "'s battleships!");
                                game = 0;

                            }
                            turnRotation = 2;
                        } else if (B1.checkForHit(xAxis, yAxis) == false) {
                            turnRotation = 1;
                        }
                    } else {
                        turnRotation = 2;
                    }
                    break;

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
                    userChoice = 0;
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

    public void playerPlacePieces() {
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
                    break;
                case 6:
                    // Place 5 Piece
                    xAxis = 0;
                    yAxis = 0;
                    System.out.println("\n" + B2.getName() + " place your 5-length ship!");

                    B2.printBoard(B1.getName(), B2.getName());
                    System.out.println("\n" + "Choose which way your ship faces.");
                    position = positionMenu();
                    xAxis = promptForInt("\n\n" + B2.getName() + " place your piece (1-8) x-axis: ", 1, 8);
                    yAxis = promptForInt("\n\n" + B2.getName() + " place your piece (1-8) y-axis: ", 1, 8);

                    if (B2.checkPieceOK(5, position, xAxis, yAxis)) {
                        B2.setPiece(5, position, xAxis, yAxis);

                        B2.printBoard(B1.getName(), B2.getName());

                        turnRotation = 7;
                    } else {
                        System.out.println("Invalid piece place!" + "\n" + "Try again.");
                        turnRotation = 6;
                        B2.printBoard(B1.getName(), B2.getName());
                    }
                    break;
                case 7:
                    // Place 4 Piece
                    System.out.println("\n" + B2.getName() + " place your 4-length ship!");

                    System.out.println("\n" + "Choose which way your ship faces.");
                    position = positionMenu();
                    xAxis = promptForInt("\n\n" + B2.getName() + " place your piece (1-8) x-axis: ", 1, 8);
                    yAxis = promptForInt("\n\n" + B2.getName() + " place your piece (1-8) y-axis: ", 1, 8);

                    if (B2.checkPieceOK(4, position, xAxis, yAxis)) {
                        B2.setPiece(4, position, xAxis, yAxis);

                        B2.printBoard(B1.getName(), B2.getName());

                        turnRotation = 8;
                    } else {
                        System.out.println("Invalid piece place!" + "\n" + "Try again.");
                        turnRotation = 7;
                        B2.printBoard(B1.getName(), B2.getName());
                    }
                    break;
                case 8:
                    // Place 3 Piece
                    System.out.println("\n" + B2.getName() + " place your 3-length ship!");

                    System.out.println("\n" + "Choose which way your ship faces.");
                    position = positionMenu();
                    xAxis = promptForInt("\n\n" + B2.getName() + " place your piece (1-8) x-axis: ", 1, 8);
                    yAxis = promptForInt("\n\n" + B2.getName() + " place your piece (1-8) y-axis: ", 1, 8);

                    if (B2.checkPieceOK(3, position, xAxis, yAxis)) {
                        B2.setPiece(3, position, xAxis, yAxis);

                        B2.printBoard(B1.getName(), B2.getName());

                        turnRotation = 9;
                    } else {
                        System.out.println("Invalid piece place!" + "\n" + "Try again.");
                        turnRotation = 8;
                        B2.printBoard(B1.getName(), B2.getName());
                    }
                    break;
                case 9:
                    // Place 3 Piece
                    System.out.println("\n" + B2.getName() + " place your 3-length ship!");

                    System.out.println("\n" + "Choose which way your ship faces.");
                    position = positionMenu();
                    xAxis = promptForInt("\n\n" + B2.getName() + " place your piece (1-8) x-axis: ", 1, 8);
                    yAxis = promptForInt("\n\n" + B2.getName() + " place your piece (1-8) y-axis: ", 1, 8);

                    if (B2.checkPieceOK(3, position, xAxis, yAxis)) {
                        B2.setPiece(3, position, xAxis, yAxis);

                        B2.printBoard(B1.getName(), B2.getName());

                        turnRotation = 10;
                    } else {
                        System.out.println("Invalid piece place!" + "\n" + "Try again.");
                        turnRotation = 9;
                        B2.printBoard(B1.getName(), B2.getName());
                    }
                    break;
                case 10:
                    // Place 2 Piece
                    System.out.println("\n" + B2.getName() + " place your 2-length ship!");

                    System.out.println("\n" + "Choose which way your ship faces.");
                    position = positionMenu();
                    xAxis = promptForInt("\n\n" + B2.getName() + " place your piece (1-8) x-axis: ", 1, 8);
                    yAxis = promptForInt("\n\n" + B2.getName() + " place your piece (1-8) y-axis: ", 1, 8);

                    if (B2.checkPieceOK(2, position, xAxis, yAxis)) {
                        B2.setPiece(2, position, xAxis, yAxis);

                        B2.printBoard(B1.getName(), B2.getName());

                        game = 0;
                    } else {
                        System.out.println("Invalid piece place!" + "\n" + "Try again.");
                        turnRotation = 10;
                        B2.printBoard(B1.getName(), B2.getName());
                    }
                    break;
            }
        } while (game == 1);
    }
}
