package com.company;

import models.Board;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Controller
{
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    int turnRotation;

    public void run()
    {
        // new Board().printBoard("Yeuh", "Yeuh");

        mainMenu();
    }

    public void playerVPlayer() {
        String in;

        System.out.println("Player one enter name ");

        in = input();
        /*if (!in.equals("")) {
            P1.setName(in);
        } else {
            P1.setName("Human1");
        }*/

        System.out.println("Player two enter name ");

        in = input();
        /*if (!in.equals("")) {
            P2.setName(in);
        } else {
            P2.setName("Human2");
        }*/

        Board board = new Board();
        int game = 1;
        /*board.printBoard(P1.getName(), P2.getName());
        startingPlayer(P1.getName(), P2.getName());*/

        /*if (turnRotation == 1) {
            P1.setColor("Y");
            P2.setColor("R");
        } else if (turnRotation == 2) {
            P2.setColor("Y");
            P1.setColor("R");
        }*/

        do {

            switch (turnRotation) {

                case 1:
                    /*board.printBoard(P1.getName(), P2.getName());
                    turn = promptForInt("\n\n" + P1.getName() + " place your piece (1-7): ", 1, 7);
                    try {
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
                    /*board.printBoard(P1.getName(), P2.getName());
                    turn = promptForInt("\n\n" + P2.getName() + " place your piece (1-7): ", 1, 7);

                    try {
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

}
