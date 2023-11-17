class Solution {
    public int minTotalDistance(int[][] grid) {
        List<Integer> rows = getRows(grid), cols = getCols(grid);
        int row = rows.get(rows.size()/2), col = cols.get(cols.size()/2);

        return get1DDistance(row, rows) + get1DDistance(col, cols);
    }

    private List<Integer> getRows(int[][] grid){
        List<Integer> rows = new ArrayList<>();
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1) rows.add(i);
            }
        }
        return rows;
    }

    private List<Integer> getCols(int[][] grid){
        List<Integer> cols = new ArrayList<>();
        for(int col = 0; col < grid[0].length; col++){
            for(int row = 0; row < grid.length; row++){
                if(grid[row][col] == 1) cols.add(col);
            }
        }
        return cols;
    }

    private int get1DDistance(int mid, List<Integer> nums){
        int sum = 0;
        for(int num : nums) sum+= Math.abs(mid - num);
        return sum;
    }
}