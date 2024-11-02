class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> list = new ArrayList<>();
        TreeMap<Integer, Integer> count = new TreeMap<>();
        for(int[] interval : intervals) {
            count.put(interval[0], count.getOrDefault(interval[0], 0) + 1);
            count.put(interval[1], count.getOrDefault(interval[1], 0) - 1);
        }

        int currCount = 0, start = Integer.MAX_VALUE, end = Integer.MIN_VALUE;
        for(int k : count.keySet()) {
            currCount+= count.get(k);
            start = Math.min(start, k);
            end = Math.max(end, k);
            
            if(currCount == 0) {
                list.add(new int[]{start, end});
                start = Integer.MAX_VALUE;
                end = Integer.MIN_VALUE;
            }
        }

        int[][] result = new int[list.size()][2];
        for(int i = 0; i < result.length; i++) result[i] = list.get(i);
        return result;
    }
}