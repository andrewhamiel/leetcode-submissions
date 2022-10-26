class Solution {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0])); // Sort by earliest meeting time
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> Integer.compare(a[1], b[1])); // Earliest end time leaves first for FILO
        minHeap.offer(intervals[0]);
        for(int i = 1; i < intervals.length; i++){
            int[] curr = intervals[i];
            int[] earliestEndTime = minHeap.poll();
            if(curr[0] >= earliestEndTime[1]) //No conflict, can combine in same room
                earliestEndTime[1] = curr[1];
            else minHeap.offer(curr); //Conflict, must book separate rooms
            minHeap.offer(earliestEndTime);
        }
        return minHeap.size();
    }
}