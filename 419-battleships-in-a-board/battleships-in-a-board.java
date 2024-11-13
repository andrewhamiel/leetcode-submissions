class Solution {
    public int countBattleships(char[][] board) {
        int battleships = 0;
        for(int row = 0; row < board.length; row++) {
            for(int col = 0; col < board[0].length; col++) {
                if((board[row][col] == 'X') 
                    && (row == 0 || board[row - 1][col] == '.')
                    && (col == 0 || board[row][col - 1] == '.')) battleships++;
            }
        }
        return battleships;
    }
}