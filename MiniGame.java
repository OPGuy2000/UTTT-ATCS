package uttt;

public class MiniGame {
    int rRow;
    int rCol;
    int[][] board;

    int winner;

    public MiniGame () { 
        board = new int[3][3];
    }

    public boolean checkWin(int player) {
        boolean rowCheck = board[rRow][1] != 0 && board[rRow][0] == board[rRow][1] && board[rRow][1] == board[rRow][2];
        boolean colCheck = board[1][rCol] != 0 && board[0][rCol] == board[1][rCol] && board[1][rCol] == board[2][rCol];
        
        boolean diagonalCheck1 = false;
        boolean diagonalCheck2 = false;
        if ((rRow + rCol)%2 == 0) { 
            diagonalCheck1 = board[1][1] != 0 && board[0][0] == board[1][1] && board[1][1] == board[2][2];
            diagonalCheck2 = board[1][1] != 0 && board[0][2] == board[1][1] && board[1][1] == board[2][0];
        }
        
        boolean won = rowCheck || colCheck || diagonalCheck1 || diagonalCheck2;
        if (won) {this.setWinner(player);}
        return won;
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

    public void playMove (int row, int col, int player) {
        rRow = row;
        rCol = col;
        board[row][col] = player;

        this.checkWin(player);
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
        String boardString = "";
        if (winner == 0) {
            boardString = String.format(
            "     |     |     \n" +
            "  %c  |  %c  |  %c  \n" + 
            "_____|_____|_____\n" + 
            "     |     |     \n" + 
            "  %c  |  %c  |  %c  \n" + 
            "_____|_____|_____\n" + 
            "     |     |     \n" + 
            "  %c  |  %c  |  %c  \n" + 
            "     |     |     " +
            ""
            , boardChars[0], boardChars[1], boardChars[2], boardChars[3], boardChars[4], boardChars[5], boardChars[6], boardChars[7], boardChars[8]);
        } else if (winner == 1) {
            boardString = 
            "                  \n" +
            "                  \n" + 
            "                  \n" + 
            "                  \n" + 
            "         X        \n" + 
            "                  \n" + 
            "                  \n" + 
            "                  \n" + 
            "                  " +
            "";
        } else if (winner == 2) {
            boardString = 
            "                  \n" +
            "                  \n" + 
            "                  \n" + 
            "                  \n" + 
            "         O        \n" + 
            "                  \n" + 
            "                  \n" + 
            "                  \n" + 
            "                  " +
            "";
        }
        String[] outputArr = boardString.split("\n", 9);
        return outputArr;
    }
}
