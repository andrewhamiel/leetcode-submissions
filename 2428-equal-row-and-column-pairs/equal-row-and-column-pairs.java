class Solution {
    public int equalPairs(int[][] grid) {
        Map<String, Integer> map = new HashMap<>();
        //Put rows into map
        for(int[] row : grid) {
            StringBuilder sb = new StringBuilder();
            for(int col = 0; col < row.length; col++) sb.append(row[col]).append(',');
            map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + 1);
        }

        int count = 0;
        //Check cols for matches
        for(int col = 0; col < grid[0].length; col++) {
            StringBuilder sb = new StringBuilder();
            for(int row = 0; row < grid.length; row++) sb.append(grid[row][col]).append(',');
            count+= map.getOrDefault(sb.toString(), 0);
        }
        return count;
    }
}