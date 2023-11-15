class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length == 0) return new int[0][0];

		//1. Populate Ordered Map
		TreeMap<Integer, Integer> map = new TreeMap<>();
		for(int[] interval : intervals){
			map.put(interval[0], map.getOrDefault(interval[0], 0) + 1);
			map.put(interval[1], map.getOrDefault(interval[1], 0) - 1);
		}

		//2. Merge intervals
		List<int[]> list = new ArrayList<>();
		int count = 0, start = Integer.MAX_VALUE, end = Integer.MIN_VALUE;
		for(int k : map.keySet()){
			count+= map.get(k);
			start = Math.min(start, k);
			end = Math.max(end, k);
			if(count == 0){
				list.add(new int[]{start, end});
				start = Integer.MAX_VALUE;
				end = Integer.MIN_VALUE;
			}
		}

		//3. Build result
		int[][] result = new int[list.size()][2];
		for(int i = 0; i < result.length; i++) result[i] = list.get(i);
		return result;
    }
}