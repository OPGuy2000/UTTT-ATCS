package uttt;

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        BigGame bigGame = new BigGame();
        Scanner scanner = new Scanner(System.in);

        String move;

        int turn = 1;
        do {
            System.out.print("Enter move (QUIT to leave): ");
            move = scanner.nextLine();
            System.out.println();

            if (move.equals("QUIT")) break;

            bigGame.playMove(move, turn);
            System.out.println(bigGame);

            turn = ((turn - 1) ^ 1) + 1;
            System.out.println(turn);
        } while (true);
    
        
        System.out.println("byeeee");
        scanner.close();
    }
}