class Solution {
    public int minMeetingRooms(int[][] intervals) {
        PriorityQueue<Integer> startTimes = new PriorityQueue<>(), endTimes = new PriorityQueue<>();
        for(int[] interval : intervals) {
            startTimes.add(interval[0]);
            endTimes.add(interval[1]);
        }

        int roomsUsed = 0;
        while(!startTimes.isEmpty()) {
            int startTime = startTimes.poll();
            roomsUsed++;
            int endTime = endTimes.peek();
            if(startTime >= endTime) {
                endTimes.poll();
                roomsUsed--;
            }
        }
        return roomsUsed;
    }
}