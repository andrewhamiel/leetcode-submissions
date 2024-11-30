class Solution {
    public int countBattleships(char[][] board) {
        int result = 0;
        for(int row = 0; row < board.length; row++) {
            for(int col = 0; col < board[0].length; col++) {
                if(board[row][col] == 'X' && ((col + 1 >= board[0].length || board[row][col + 1] == '.')
                && (row + 1 >= board.length || board[row + 1][col] == '.'))) result++;
            }
        }
        return result;
    }
}