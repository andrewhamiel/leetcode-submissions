class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[] rows = new int[9], cols = new int[9], boxes = new int[9];
        for(int row = 0; row < board.length; row++) {
            for(int col = 0; col < board[0].length; col++) {
                //1. Check val
                if(board[row][col] == '.') continue;
                int val = board[row][col] - '0';
                int pos = 1 << (val - 1);

                //2. Check rows. num & num is 1, so if num present then return false
                if((rows[row] & pos) > 0) return false;
                rows[row]|= pos;

                //3. Check cols
                if((cols[col] & pos) > 0) return false;
                cols[col]|= pos;

                //4. Check boxes
                int ind = (row/3) * 3 + col/3;
                if((boxes[ind] & pos) > 0) return false;
                boxes[ind]|= pos;
            }
        }
        return true;
    }
}