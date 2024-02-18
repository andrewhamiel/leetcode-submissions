class Solution {
    public int mostBooked(int n, int[][] meetings) {
        long[] minTimeAvailable = new long[n];
        int[] meetingCount = new int[n];
        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);
        
        for(int[] meeting : meetings){
            int start = meeting[0], end = meeting[1];
            long minRoomAvailableTime = Long.MAX_VALUE;
            int minMeetingRoom = 0;
            boolean isRoomFound = false;

            for(int i = 0; i < n; i++){
                if(minTimeAvailable[i] <= start){
                    minTimeAvailable[i] = end;
                    meetingCount[i]++;
                    isRoomFound = true;
                    break;
                }

                if(minRoomAvailableTime > minTimeAvailable[i]){
                    minRoomAvailableTime = minTimeAvailable[i];
                    minMeetingRoom = i;
                }
            }

            if(!isRoomFound){
                minTimeAvailable[minMeetingRoom]+= end - start;
                meetingCount[minMeetingRoom]++;
            }
        }

        int maxMeetingCount = 0, maxMeetingRoom = 0;
        for(int i = 0; i < n; i++){
            if(meetingCount[i] > maxMeetingCount){
                maxMeetingCount = meetingCount[i];
                maxMeetingRoom = i;
            }
        }
        return maxMeetingRoom;
    }
}