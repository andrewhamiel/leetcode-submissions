class Solution {
    public int countBattleships(char[][] board) {
        //DFS
        int battleships = 0;
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == 'X'){
                    battleships+= dfs(i, j, board);
                } 
            }
        }
        return battleships;
    }

    private int dfs(int i, int j, char[][] board){
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != 'X') return 0;

        board[i][j] = '.';
        int left = dfs(i, j - 1, board);
        int right = dfs(i, j + 1, board);
        int down = dfs(i + 1, j, board);
        int up = dfs(i - 1, j, board);
        return Math.max(1, left + right + down + up);
    }
}