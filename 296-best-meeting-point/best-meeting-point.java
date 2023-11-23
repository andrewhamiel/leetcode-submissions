class Solution {
    public int minTotalDistance(int[][] grid) {
        List<Integer> rows = getRows(grid);
        List<Integer> cols = getCols(grid);

        return get1DDistance(rows) + get1DDistance(cols);
    }

    private List<Integer> getRows(int[][] grid){
        List<Integer> rows = new ArrayList<>();
        for(int row = 0; row < grid.length; row++){
            for(int col = 0; col < grid[0].length; col++){
                if(grid[row][col] == 1) rows.add(row);
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

    private int get1DDistance(List<Integer> points){
        int left = 0, right = points.size() - 1, distance = 0;
        while(left < right) distance+= points.get(right--) - points.get(left++);
        return distance;
    }
}