class Solution {
    public int mostBooked(int n, int[][] meetings) {
        long[] roomAvailabilityTime = new long[n];
        int[] meetingCount = new int[n];
        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);

        for(int[] meeting : meetings){
            int start = meeting[0], end = meeting[1];
            long minAvailabilityTime = Long.MAX_VALUE;
            int minAvailableRoom = 0;
            boolean isRoomFound = false;

            for(int i = 0; i < n; i++){
                if(roomAvailabilityTime[i] <= start){
                    roomAvailabilityTime[i] = end;
                    meetingCount[i]++;
                    isRoomFound = true;
                    break;
                }

                if(minAvailabilityTime > roomAvailabilityTime[i]){
                    minAvailabilityTime = roomAvailabilityTime[i];
                    minAvailableRoom = i;
                }
            }

            if(!isRoomFound){
                roomAvailabilityTime[minAvailableRoom]+= end - start;
                meetingCount[minAvailableRoom]++;
            }
        }

        int maxMeetingCount = 0, maxMeetingCountRoom = 0;
        for(int i = 0; i < n; i++){
            if(meetingCount[i] > maxMeetingCount){
                maxMeetingCount = meetingCount[i];
                maxMeetingCountRoom = i;
            }
        }
        return maxMeetingCountRoom;
    }
}