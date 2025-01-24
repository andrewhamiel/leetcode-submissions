class Solution {
    public int minMeetingRooms(int[][] intervals) {
        PriorityQueue<Integer> startTimes = new PriorityQueue<>(), endTimes = new PriorityQueue<>();
        for(int[] interval : intervals) {
            startTimes.add(interval[0]);
            endTimes.add(interval[1]);
        }

        int usedRooms = 0;
        while(!startTimes.isEmpty()) {
            int startTime = startTimes.poll(), endTime = endTimes.peek();
            usedRooms++;
            if(startTime >= endTime) {
                endTimes.poll();
                usedRooms--;
            }
        }
        return usedRooms;
    }
}