class TicTacToe {
    int[] rows, cols;
    int diag = 0, antiDiag = 0, n = 0;

    public TicTacToe(int n) {
        rows = new int[n];
        cols = new int[n];
        this.n = n;
    }
    
    public int move(int row, int col, int player) {
        int playerVal = player == 1 ? 1 : -1;
        rows[row]+= playerVal;
        cols[col]+= playerVal;
        if(row == col) diag+= playerVal;
        if(rows.length - 1 - row == col) antiDiag+= playerVal;

        if(Math.abs(rows[row]) == n || Math.abs(cols[col]) == n || Math.abs(diag) == n || Math.abs(antiDiag) == n){
            return playerVal == 1 ? 1 : 2;
        }
        return 0;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */