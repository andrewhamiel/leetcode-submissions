class Solution {
    
    //DFS + Backtracking. Time: O(N*3^L), N = num cells, L = Length of word to be matched
    //Space: O(L)
    public boolean exist(char[][] board, String word) {
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == word.charAt(0) && dfs(i, j, board, word)) return true;
            }
        }
        return false;
    }
    
    private boolean dfs(int i, int j, char[][] board, String word){
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || word.charAt(0) != board[i][j]) return false;
        if(word.length() == 1) return true;
        board[i][j] = ' ';
        boolean isWord = dfs(i, j-1, board, word.substring(1))
        || dfs(i, j+1, board, word.substring(1))
        || dfs(i-1, j, board, word.substring(1))
        || dfs(i+1, j, board, word.substring(1));
        board[i][j] = word.charAt(0);
        return isWord;
    }
}