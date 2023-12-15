class Solution {
    public int minTotalDistance(int[][] grid) {
        List<Integer> rows = getRows(grid);
        List<Integer> cols = getCols(grid);

        return get1DDistance(rows) + get1DDistance(cols);
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
        for(int j = 0; j < grid[0].length; j++){
            for(int i = 0; i < grid.length; i++){
                if(grid[i][j] == 1) cols.add(j);
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