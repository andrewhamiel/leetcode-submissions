class Solution {
    public int[][] merge(int[][] intervals) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int[] interval : intervals) {
            map.put(interval[0], map.getOrDefault(interval[0], 0) - 1);
            map.put(interval[1], map.getOrDefault(interval[1], 0) + 1);
        }

        int currCount = 0, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        List<int[]> list = new ArrayList<>();
        for(int key : map.keySet()) {
            currCount+= map.get(key);
            min = Math.min(min, key);
            max = Math.max(max, key);
            if(currCount == 0) {
                list.add(new int[]{min, max});
                min = Integer.MAX_VALUE;
                max = Integer.MIN_VALUE;
            }
        }
        
        int[][] result = new int[list.size()][2];
        for(int i = 0; i < result.length; i++) result[i] = list.get(i);
        return result;
    }
}