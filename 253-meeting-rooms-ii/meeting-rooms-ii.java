class Solution {
    public int minMeetingRooms(int[][] intervals) {
        TreeMap<Integer, Integer> startTimes = new TreeMap<>(), endTimes = new TreeMap<>();
        for(int[] interval : intervals) {
            startTimes.put(interval[0], startTimes.getOrDefault(interval[0], 0) + 1);
            endTimes.put(interval[1], endTimes.getOrDefault(interval[1], 0) - 1);
        }

        Integer usedRooms = 0, startKey = startTimes.firstKey(), endKey = endTimes.firstKey();
        int startCount = startTimes.get(startKey), endCount = endTimes.get(endKey);
        while(startKey != null) {
            if(startKey >= endKey) {
                usedRooms--;
                
                endCount++;
                if(endCount == 0) {
                    endKey = endTimes.higherKey(endKey);
                    if(endKey != null) endCount = endTimes.get(endKey);
                }
            }
            usedRooms++;
            startCount--;
            if(startCount == 0) {
                startKey = startTimes.higherKey(startKey);
                if(startKey != null) startCount = startTimes.get(startKey);
            }
        }
        return usedRooms;
    }
}