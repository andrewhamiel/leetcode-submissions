class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[] rows = new int[board.length], cols = new int[board.length], boxes = new int[board.length];
        for(int row = 0; row < board.length; row++) {
            for(int col = 0; col < board[0].length; col++) {
                //1. Check for number at pos
                if(board[row][col] == '.') continue;

                int val = board[row][col] - '0';
                int pos = 1 << (val - 1);

                //2. Check row
                if((rows[row] & pos) > 0) return false;
                rows[row]|= pos;

                //3. Check col
                if((cols[col] & pos) > 0) return false;
                cols[col]|= pos;

                //4. Check box
                int ind = (row / 3) * 3 + (col / 3);
                if((boxes[ind] & pos) > 0) return false;
                boxes[ind]|= pos;
            }
        }
        return true;
    }
}