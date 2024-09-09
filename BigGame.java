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

    @Override
    public String toString() {
        String boardString = "";

        for (int row = 0; row < 3; row++) {
            for (int i = 0; i < 9; i++) {
                for (int col = 0; col < 3; col++) {
                    boardString += board[row][col].getStringArray()[i];
                }
                boardString += "\n";
            }
            boardString += "\n";
        }

        return boardString;
    }
}
