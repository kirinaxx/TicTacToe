package mechanicsBE;

import java.util.InputMismatchException;
import java.util.Scanner;

public class slTTTBoard
{
    char[][] board;
    public slTTTBoard()
    {
        board = new char[][]{{'-', '-', '-'}, {'-', '-', '-'}, {'-', '-', '-'}};
    }
    public void printBoard()
    {
        for (int i = 0; i < 3; i++) {
            for(int j=0;j<3;j++) {
                System.out.print(this.board[i][j] + "  ");
            }
            System.out.println();
        }
        System.out.println();
    }
    private static  boolean checkForEmpty (char[][] board)
    {
        for (int i = 0; i < 3; i++) {
            for(int j=0;j<3;j++) {
                if(board[i][j] == '-')
                    return true;
            }
        }
        return false;
    }
    public void play()
    {
        Scanner sc = new Scanner(System.in);
        boolean o = true;
        int row = -1, col = -1;
        while (checkForEmpty(this.board)) {
            System.out.print("Enter the row and column for your entry (space seperated): ");

            if (sc.hasNext("q"))
                break;

            try {
                row = sc.nextInt();
                col = sc.nextInt();

                if (row < 0 || row > 2 || col < 0 || col > 2) {
                    System.out.println("You're out of board.\nEnter number between 0 and 2.\n Try again! ");
                    continue;
                }

                if (this.board[row][col] != '-') {
                    System.out.println("This place is already taken.\n Try again! ");
                    continue;
                }
                this.board[row][col] = o ? 'o' : 'x';
                o = !o;
                printBoard();
            } catch (InputMismatchException ex) {
                System.out.println("Please enter 2 numbers divided by space (row column).");
                sc.nextLine();
            }

        }
        System.out.println("Game is finished!");
    }
}