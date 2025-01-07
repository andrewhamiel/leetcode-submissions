class Solution {
    public int equalPairs(int[][] grid) {
        Map<String, Integer> map = new HashMap<>();
        //1. Look at rows
        for(int row = 0; row < grid.length; row++) {
            StringBuilder sb = new StringBuilder();
            for(int col = 0; col < grid[0].length; col++) sb.append(grid[row][col]).append(',');
            map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + 1);
        }

        //2. Compare to cols
        int count = 0;
        for(int col = 0; col < grid[0].length; col++) {
            StringBuilder sb = new StringBuilder();
            for(int row = 0; row < grid.length; row++) sb.append(grid[row][col]).append(',');
            count+= map.getOrDefault(sb.toString(), 0);
        }
        return count;
    }
}