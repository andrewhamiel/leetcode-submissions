class Solution {
    public int minMeetingRooms(int[][] intervals) {
        PriorityQueue<Integer> startTimes = new PriorityQueue<>(), endTimes = new PriorityQueue<>();
        for(int[] interval : intervals) {
            startTimes.add(interval[0]);
            endTimes.add(interval[1]);
        }

        int roomsRequired = 0;
        while(!startTimes.isEmpty()) {
            int startTime = startTimes.poll();
            roomsRequired++;
            int endTime = endTimes.peek();
            if(startTime >= endTime) {
                roomsRequired--;
                endTimes.poll();
            }
        }
        return roomsRequired;
    }
}