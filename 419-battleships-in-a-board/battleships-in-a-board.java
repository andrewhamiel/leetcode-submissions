class Solution {
    public int countBattleships(char[][] board) {
        int battleships = 0;
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == 'X' &&
                    (j == board[0].length - 1 || board[i][j + 1] == '.')
                    && (i == board.length - 1 || board[i + 1][j] == '.')) battleships++;
            }
        }
        return battleships;
    }
}