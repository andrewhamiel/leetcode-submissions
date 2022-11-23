class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> seen = new HashSet();
        
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                char val = board[i][j];
                if(val != '.'){
                   if(!seen.add(board[i][j] + "r" + i)
                  || !seen.add(board[i][j] + "c" + j)
                   || !seen.add(board[i][j] + "m" + i/3 + ":" + j/3)) return false; 
                }                
            }
        }
        return true;
    }
    
    
        
}