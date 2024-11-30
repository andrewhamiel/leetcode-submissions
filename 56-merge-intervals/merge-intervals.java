class Solution {
    public int[][] merge(int[][] intervals) {
        TreeMap<Integer, Integer> count = new TreeMap<>();
        for(int[] interval : intervals) {
            count.put(interval[0], count.getOrDefault(interval[0], 0) + 1);
            count.put(interval[1], count.getOrDefault(interval[1], 0) - 1);
        }

        List<int[]> list = new ArrayList<>();
        int currCount = 0, left = Integer.MAX_VALUE, right = Integer.MIN_VALUE;
        for(int key : count.keySet()) {
            currCount+= count.get(key);
            left = Math.min(left, key);
            right = Math.max(right, key);
            
            if(currCount == 0) {
                list.add(new int[]{left, right});
                left = Integer.MAX_VALUE;
                right = Integer.MIN_VALUE;
            }
        }
        
        int[][] result = new int[list.size()][2];
        for(int i = 0; i < result.length; i++) result[i] = list.get(i);
        return result;
    }
}