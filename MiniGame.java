package uttt;

public class MiniGame {
    int rRow;
    int rCol;
    int[][] board;

    int winner;

    public MiniGame () { 
        board = new int[3][3];
    }

    public boolean checkWin() {
        boolean rowCheck = board[rCol][0] == board[rCol][1] && board[rCol][1] == board[rCol][2];
        boolean colCheck = board[0][rRow] == board[1][rRow] && board[1][rRow] == board[2][rRow];
        
        boolean diagonalCheck1 = false;
        boolean diagonalCheck2 = false;
        if ((rRow + rCol)%2 == 0) { 
            diagonalCheck1 = board[0][0] == board[1][1] && board[1][1] == board[2][2];
            diagonalCheck2 = board[0][2] == board[1][1] && board[1][1] == board[2][0];
        }

        return rowCheck || colCheck || diagonalCheck1 || diagonalCheck2;
    }

    public void setWinner(int player) {
        winner = player;
    }

    public int getWinner() {
        return winner;
    }

    public int getPosition(int row, int col) {
        return board[row][col];
    }

    public void setPosition (int row, int col, int player) {
        rRow = row;
        rCol = col;
        board[row][col] = player;
    }

    public String[] getStringArray() {
        char[] boardChars = new char[9];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == 0) {
                    boardChars[i*3 + j] = '-';  
                } else if (board[i][j] == 1) {
                    boardChars[i*3 + j] = 'X';  
                } else if (board[i][j] == 2) {
                    boardChars[i*3 + j] = 'O';  
                }
            }
        }
        String boardString = String.format(
            "     |     |     \r\n" +
            "  %c  |  %c  |  %c  \r\n" + 
            "_____|_____|_____\r\n" + 
            "     |     |     \r\n" + 
            "  %c  |  %c  |  %c  \r\n" + 
            "_____|_____|_____\r\n" + 
            "     |     |     \r\n" + 
            "  %c  |  %c  |  %c  \r\n" + 
            "     |     |     " +
            ""
            , boardChars[0], boardChars[1], boardChars[2], boardChars[3], boardChars[4], boardChars[5], boardChars[6], boardChars[7], boardChars[8]);
        
        return boardString.split("\n", 9);
    }
}
