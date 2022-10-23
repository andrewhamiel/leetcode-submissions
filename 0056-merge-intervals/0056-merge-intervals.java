class Solution {
    //O(nlog(n))
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        List<int[]> list = new ArrayList();
        list.add(intervals[0]);
        for(int i = 1; i < intervals.length; i++){
            int[] prev = list.get(list.size() - 1);
            if(intervals[i][0] <= prev[1]) 
                list.set(list.size() - 1, new int[]{Math.min(prev[0], intervals[i][0]), Math.max(prev[1], intervals[i][1])});
            else list.add(intervals[i]);
        }
        
        int[][] merged = new int[list.size()][2];
        for(int i = 0; i < merged.length; i++){
            merged[i] = list.get(i);
        }
        return merged;
    }
}