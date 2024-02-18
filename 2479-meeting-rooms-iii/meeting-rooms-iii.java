class Solution {
    public int mostBooked(int n, int[][] meetings) {
        long[] minTimeAvailable = new long[n];
        int[] meetingCount = new int[n];
        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);

        for(int[] meeting : meetings){
            int start = meeting[0], end = meeting[1];
            long minAvailableRoomTime = Long.MAX_VALUE;
            int minAvailableRoom = 0;
            boolean isRoomFound = false;

            for(int i = 0; i < n; i++){
                if(minTimeAvailable[i] <= start){
                    minTimeAvailable[i] = end;
                    meetingCount[i]++;
                    isRoomFound = true;
                    break;
                }

                if(minAvailableRoomTime > minTimeAvailable[i]){
                    minAvailableRoomTime = minTimeAvailable[i];
                    minAvailableRoom = i;
                }
            }

            if(!isRoomFound){
                minTimeAvailable[minAvailableRoom]+= end - start;
                meetingCount[minAvailableRoom]++;
            }
        }

        int maxRoomCount = 0, maxRoom = 0;
        for(int i = 0; i < n; i++){
            if(meetingCount[i] > maxRoomCount){
                maxRoomCount = meetingCount[i];
                maxRoom = i;
            }
        }
        return maxRoom;
    }
}