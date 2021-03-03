package com.company;

import models.Board;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Controller
{
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public void run()
    {
        new Board().printBoard("Yeuh", "Yeuh");
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
                    /*humanVHuman();*/
                    /*prompt =  promptForInt("Would you like to play again? \n 1: Yes    0: No \n", 0,1);
                    if(prompt == 0)
                    {
                        userChoice = 0;
                        break;
                    } else
                    {
                        break;
                    }*/

                case 2:
                    /*humanVComp();
                    prompt =  promptForInt("Would you like to play again? \n 1: Yes    0: No \n", 0,1);
                    if(prompt == 0)
                    {
                        userChoice = 0;
                        break;
                    } else
                    {
                        break;
                    }*/

                case 3:
                    /*compVComp();
                    prompt =  promptForInt("Would you like to play again? \n 1: Yes    0: No \n", 0,1);
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

}
