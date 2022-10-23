class Solution {
    public boolean exist(char[][] board, String word) {
        // boolean[][] visited = new boolean[board.length][board[0].length];
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == word.charAt(0) && dfs(i, j, board, word)) return true;
            }
        }
        return false;
    }
    
    private boolean dfs(int i, int j, char[][] board, String word){
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(0)) return false;
        if(word.length() == 1) return true;
        board[i][j] = ' ';
        boolean hasWord = false;
        if(dfs(i, j-1, board, word.substring(1))
        || dfs(i, j+1, board, word.substring(1))
        || dfs(i-1, j, board, word.substring(1))
        || dfs(i+1, j, board, word.substring(1))){
            hasWord = true;
        }
        board[i][j] = word.charAt(0);
        return hasWord;
    }
}