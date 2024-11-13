class Solution {
    public int countBattleships(char[][] board) {
        int battleships = 0;
        for(int row = 0; row < board.length; row++) {
            for(int col = 0; col < board[0].length; col++) {
                //check for nothing above, nothing to the left 
                if((board[row][col] == 'X') && (col == 0 || board[row][col - 1] == '.')
                    && (row == 0 || board[row - 1][col] == '.')) battleships++;
            }
        }
        return battleships;
    }
}