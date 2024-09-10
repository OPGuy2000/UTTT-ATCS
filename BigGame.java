package uttt;

public class BigGame {
    MiniGame[][] board;

    public BigGame() {
        board = new MiniGame[3][3];
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                board[row][col] = new MiniGame();
            }
        }
    }

    public void playMove(String move, int player) {
        String bigMove = move.substring(0, 2);
        String smallMove = move.substring(2, 4);
        
        char bigRow = bigMove.charAt(0);
        int bigCol = Character.getNumericValue(bigMove.charAt(1));

        char smallRow = smallMove.charAt(0);
        int smallCol = Character.getNumericValue(smallMove.charAt(1));
        
        
        board[(int) bigRow - 97][bigCol-1].playMove((int) smallRow - 97, smallCol-1, player);
        board[(int) bigRow - 97][bigCol-1].checkWin(player);
    } 

    @Override
    public String toString() {
        String boardString = "";

        for (int row = 0; row < 3; row++) {
            for (int i = 0; i < 9; i++) {
                for (int col = 0; col < 3; col++) {
                    boardString += board[row][col].getStringArray()[i] + "\t";
                }
                boardString += "\n";
            }
            boardString += "\n";
        }

        return boardString;
    }
}
