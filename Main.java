package uttt;

import java.util.Scanner;
import java.util.Stack;

class Main {

    public static boolean validTurn = true;
    public static boolean gameEnded = false;
    public static void main(String[] args) {
        BigGame bigGame = new BigGame();
        Scanner scanner = new Scanner(System.in);

        Stack<String> moveStack = new Stack<>();
        String move;

        int turn = 1;
        
        System.out.print("\033[H\033[2J");  
        System.out.flush(); 

        String nextGame = ""; 
        do { 
            System.out.print("Enter move (QUIT to leave; UNDO to undo): ");
            move = scanner.nextLine();
            System.out.println();
            if (move.toUpperCase().equals("QUIT")) break;

            System.out.print("\033[H\033[2J");  
            System.out.flush(); 
            
            if (move.toUpperCase().equals("UNDO")) {
                if (moveStack.empty()) {
                    nextGame = "";
                    System.out.println("No moves left to go back to.");
                } else {
                    nextGame = moveStack.peek().substring(0, 2);
                    bigGame.playMove(moveStack.pop(), 0);
                    validTurn = false;
                }
                System.out.println(bigGame);
            } else {
                if (move.substring(0, 2).equals(nextGame) || nextGame.equals("")) {
                    bigGame.playMove(move, turn);
                    System.out.println(bigGame);
                    nextGame = move.substring(2, 4);

                    validTurn = true;
                } else {   
                    System.out.println(bigGame);
                    System.out.println("You must play in the " + nextGame + " board this turn.");
                    validTurn = false;
                }
            }

            if (validTurn) {
                moveStack.push(move);
                turn = ((turn - 1) ^ 1) + 1;
            }
            if (turn == 1) {
                System.out.println("Turn : X\n");
            } else if (turn == 2) {
                System.out.println("Turn : O\n");
            }
        } while (!gameEnded);
    
        
        System.out.println("byeeee");
        scanner.close();
    }
}