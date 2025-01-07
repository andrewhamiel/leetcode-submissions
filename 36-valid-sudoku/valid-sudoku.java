class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> seen = new HashSet<>();

        for(int row = 0; row < board.length; row++) {
            for(int col = 0; col < board[0].length; col++) {
                char val = board[row][col];
                if(val != '.' && 
                    ((!seen.add(board[row][col] + "r" + row)
                    || (!seen.add(board[row][col] + "c" + col)
                    || (!seen.add(board[row][col] + "m" + row/3 + ":" + col/3)))))) return false;
            }
        }
        return true;
    }
}