class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        List<Integer> list = new ArrayList<>();
        int rows = nums.size();
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0});
        while(!q.isEmpty()) {
            int[] cell = q.poll();
            int row = cell[0], col = cell[1];
            int cols = nums.get(row).size();

            list.add(nums.get(row).get(col));

            if(row + 1 < rows && col == 0) q.add(new int[]{row + 1, col});
            if(col + 1 < cols) q.add(new int[]{row, col + 1});
        }

        int[] result = new int[list.size()];
        for(int i = 0; i < result.length; i++) result[i] = list.get(i);
        return result;
    }
}