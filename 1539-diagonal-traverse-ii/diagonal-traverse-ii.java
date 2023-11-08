class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        Queue<Pair<Integer, Integer>> q = new LinkedList<>();
        q.add(new Pair<>(0, 0));
        List<Integer> list = new ArrayList<>();

        while(!q.isEmpty()){
            Pair<Integer, Integer> p = q.poll();
            int row = p.getKey(), col = p.getValue();
            list.add(nums.get(row).get(col));

            if(col == 0 && row + 1 < nums.size()) q.add(new Pair<>(row + 1, col));
            if(col + 1 < nums.get(row).size()) q.add(new Pair<>(row, col + 1));
        }

        int[] result = new int[list.size()];
        for(int i = 0; i < list.size(); i++) result[i] = list.get(i);
        return result;
    }
}