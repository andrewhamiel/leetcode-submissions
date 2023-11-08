class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int left = 0, right = matrix.length - 1;
        while(left <= right){
            int mid = left + (right - left)/2;
            if(matrix[mid][0] == target) return true;
            else if(matrix[mid][0] < target) left = mid + 1;
            else right = mid - 1;
        }
        
        int row = left == 0 ? 0 : left - 1;
        left = 0; right = matrix[0].length - 1;
        while(left <= right){
            int mid = left + (right - left)/2;
            if(matrix[row][mid] == target) return true;
            else if(matrix[row][mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return false;
    }
}