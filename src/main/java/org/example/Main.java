package org.example;

import java.util.Scanner;

public class Main {
    public static  void printBoard(char[][] board)
    {
        for (int i = 0; i < 3; i++) {
            for(int j=0;j<3;j++) {
                System.out.print(board[i][j] + "  ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public static  boolean checkForEmpty (char[][] board)
    {
        for (int i = 0; i < 3; i++) {
            for(int j=0;j<3;j++) {
                if(board[i][j] == '-')
                    return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        char[][] board = {{'-','-','-'},{'-','-','-'},{'-','-','-'}};

        boolean o = true;
        int row = -1, col = -1;
            while (checkForEmpty(board)) {
                printBoard(board);
                System.out.println("Ваш хід: ");

                if (sc.hasNext("q"))
                    break;

                try {
                    row = sc.nextInt();
                    col = sc.nextInt();

                    if (row < 0 || row > 2 || col < 0 || col > 2) {
                        System.out.println("You're out of board.\nEnter number between 0 and 2.");
                        continue;
                    }

                    if (board[row][col] != '-') {
                        System.out.println("This place is already taken.");
                        continue;
                    }
                    board[row][col] = o ? 'o' : 'x';
                    o = !o;
                } catch (Exception e) {
                    System.out.println("Please enter 2 numbers divided by space (row column).");
                }

            }
            System.out.println("Game is finished!");
        }
}