class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int rows = matrix.length, cols = matrix[0].length;
        int left = 0, right = matrix[0].length - 1, up = 0, down = matrix.length - 1;
        while(result.size() < rows * cols) {
            //1. Left -> Right
            for(int col = left; col <= right; col++) result.add(matrix[up][col]);
            //2. Up -> Down
            for(int row = up + 1; row <= down; row++) result.add(matrix[row][right]);
            //3. Make sure different rows, then right -> left
            if(up != down) {
                for(int col = right - 1; col >= left; col--) result.add(matrix[down][col]);
            }
            //4. Make sure different cols, then down -> up
            if(left != right) {
                for(int row = down - 1; row > up; row--) result.add(matrix[row][left]);
            }

            left++;
            right--;
            up++;
            down--;
        }
        return result;
    }
}