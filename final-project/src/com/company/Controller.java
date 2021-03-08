package com.company;

import models.Board;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Controller {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    int turnRotation;
    int turn;
    int piecePlacement1;
    int piecePlacement2;
    Board B1 = new Board();
    Board B2 = new Board();

    public void run() {
        Board board = new Board();
        board.printBoard("a", "b");
        if (board.checkPieceOK(3, 2, 3, 5)) {

        }


        mainMenu();
    }

    public void playerVPlayer() {
        String in;

        System.out.println("Player one enter name ");

        in = input();
        if (!in.equals("")) {
            B1.setName(in);
        } else {
            B1.setName("PLayer1");
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


        /*board.printBoard(B1.getName(), B2.getName());*/
        /*startingPlayer(P1.getName(), P2.getName());*/
        do {

            switch (turnRotation) {

                case 1:
                    B2.printBoard(B1.getName(), B2.getName());
                    turn = promptForInt("\n\n" + B1.getName() + " drop a bomb!! (///): ", 1, 8);

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
                    B1.printBoard(B1.getName(), B2.getName());
                    turn = promptForInt("\n\n" + B2.getName() + " drop a bomb!! (///): ", 1, 8);

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
                    /*playerVPlayer();*/
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


    public void placePiece(int turn) {
                switch(turn)
                {
                    case 1:
                        System.out.println(B1.getName() + "'s turn.");

                    case 2:
                        System.out.println(B2.getName() + "'s turn");
                }
                promptForInt("Placing piece size: " + ,);

    }
}