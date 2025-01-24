class Solution {
    public int minMeetingRooms(int[][] intervals) {
        int[] startTimes = new int[intervals.length], endTimes = new int[intervals.length];
        for(int i = 0; i < intervals.length; i++) {
            startTimes[i] = intervals[i][0];
            endTimes[i] = intervals[i][1];
        }
        Arrays.sort(startTimes);
        Arrays.sort(endTimes);

        int startInd = 0, endInd = 0, usedRooms = 0;
        while(startInd < intervals.length) {
            //A meeting ended before this meeting started
            if(startTimes[startInd] >= endTimes[endInd]) {
                usedRooms--;
                endInd++;
            }
            usedRooms++;
            startInd++;
        }
        return usedRooms;
    }
}