class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) return new int[0][0];
        List<int[]> list = new ArrayList<>();
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int[] itv : intervals){
            map.put(itv[0], map.getOrDefault(itv[0], 0)+1);
            map.put(itv[1], map.getOrDefault(itv[1], 0)-1);
        }
        int count = 0, start = Integer.MAX_VALUE, end = Integer.MIN_VALUE;
        for (int k : map.keySet()){
            count+=map.get(k);
            start = Math.min(start, k);
            end = Math.max(end, k);
            if (count==0){
                list.add(new int[]{start, end});
                start = Integer.MAX_VALUE;
                end = Integer.MIN_VALUE;
            }
        }
        return list.toArray(new int[list.size()][2]);
    }
}