package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random random = new Random();
        boolean game = true;
        boolean compIn = true;
        int userNum1 = random.nextInt(11) + 1;
        System.out.println("Your first card is a " + userNum1);
        int userNum2 = random.nextInt(11) + 1;
        System.out.println("Your second card is a " + userNum2);
        int compNum1 = random.nextInt(11) + 1;
        int compNum2 = random.nextInt(11) + 1;
        int compTotal = compNum1 + compNum2;
        int userTotal = userNum1 + userNum2;
        System.out.println("Your total is " + userTotal);
        if ((compTotal == 21) && (userTotal == 21)) {
            System.out.println("It is a tie");
            game = false;
        }
        if ((compTotal == 21) && (userTotal != 21)) {
            System.out.println("Computer wins");
            game = false;
        }
        if ((compTotal != 21) && (userTotal == 21)) {
            System.out.println("You win");
            game = false;
        }
        if ((compTotal > 21) && (userTotal > 21)) {
            System.out.println("Both are over. Its a tie");
            game = false;
        }
        if ((userTotal > 21) && (compTotal <= 21)) {
            System.out.println("Computer wins");
            game = false;
        }
        if ((compTotal > 21) && (userTotal <= 21)) {
            System.out.println("You win");
            game = false;
        } else {
            while (game == true) {
                    System.out.println("Do you want another card? y/n");
                    String anotherCard = input.next();

                    if (anotherCard.equals("y")) {
                        int userNewNum = random.nextInt(11) + 1;
                        System.out.println("Your new card is a " + userNewNum);
                        userTotal = userTotal + userNewNum;
                        System.out.println("Your new total is " + userTotal);
                        if ((userTotal > 21) && (compTotal <= 21)) {
                            System.out.println("Computer had " + compTotal + " and you had " + userTotal + ". So the computer wins");
                            game = false;
                            compIn = false;
                        }
                    }
                    if (compIn == true) {
                        int compChance = random.nextInt(21 - compTotal) + 1;
                        if (compChance != 1) {
                            System.out.println("Computer is taking another card");
                            int compNewNum = random.nextInt(11) + 1;;
                            compTotal = compTotal + compNewNum;
                            if ((compTotal > 21) && (userTotal <= 21)) {
                                System.out.println("Computer had " + compTotal + " and you had " + userTotal + ". So you win");
                                game = false;
                            }
                        }
                        else {
                            System.out.println("Computer isn't taking any more cards");
                            compIn = false;
                        }
                    }
                    if ((anotherCard.equals("n")) && (compIn == false)){
                        if ((userTotal > 21) && (compTotal <= 21)) {
                            System.out.println("Computer had " + compTotal + " and you had " + userTotal + ". So the computer wins");
                            game = false;
                        }
                        if ((compTotal > 21) && (userTotal <= 21)) {
                            System.out.println("Computer had " + compTotal + " and you had " + userTotal + ". So you win");
                            game = false;
                        }
                        if (userTotal == compTotal) {
                            System.out.println("Computer had " + compTotal + " and you had " + userTotal + ". So its a tie");
                            game = false;
                        }
                        if ((userTotal != 21) && (compTotal == 21)) {
                            System.out.println("Computer had " + compTotal + " and you had " + userTotal + ". So the computer wins");
                            game = false;
                        }
                        if ((compTotal != 21) && (userTotal == 21)) {
                            System.out.println("Computer had " + compTotal + " and you had " + userTotal + ". So you win");
                            game = false;
                        }
                        else {
                            if (userTotal < compTotal) {
                                System.out.println("Computer had " + compTotal + " and you had " + userTotal + ". So the computer wins");
                                game = false;
                            }
                            if (compTotal < userTotal) {
                                System.out.println("Computer had " + compTotal + " and you had " + userTotal + ". So you win");
                                game = false;
                            }
                        }
                    }
                }
            }
        }
    }

