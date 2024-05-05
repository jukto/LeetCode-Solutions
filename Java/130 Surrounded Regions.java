class Solution {
    public void solve(char[][] board) {
        for (int x = 0; x < board.length; x++) {
            if(board[x][0] == 'O')
                flag(board, x, 0);
            if(board[x][board[0].length - 1] == 'O')
                flag(board, x, board[0].length - 1);
        }

        for (int y = 1; y < board[0].length - 1; y++) {
            if(board[0][y] == 'O')
                flag(board, 0, y);
            if(board[board.length - 1][y] == 'O')
                flag(board, board.length - 1, y);
        }

        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board[0].length; y++) {
                if (board[x][y] == 'o') board[x][y] = 'O';
                else board[x][y] = 'X';
            }
        }
    }

    private void flag(char[][] board, int x, int y) {
        board[x][y] = 'o';

        if (x > 0 && board[x - 1][y] == 'O') flag(board, x - 1, y);
        if (x < board.length - 1 && board[x + 1][y] == 'O') flag(board, x + 1, y);

        if (y > 0 && board[x][y - 1] == 'O') flag(board, x, y - 1);
        if (y < board[0].length - 1 && board[x][y + 1] == 'O') flag(board, x, y + 1);
    }
}
