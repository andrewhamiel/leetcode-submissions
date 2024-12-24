class Solution {
    public int findMinDifference(List<String> timePoints) {
        boolean[] minutes = new boolean[24 * 60];
        int minMins = Integer.MAX_VALUE;
        for(String time : timePoints) {
            int mins = calculateMins(time);
            if(minutes[mins]) return 0;
            minutes[mins] = true;
            minMins = Math.min(minMins, mins);
        }

        int left = minMins, right = left + 1, maxMins = left, minDifference = Integer.MAX_VALUE;
        while(right < minutes.length) {
            if(minutes[right]) {
                minDifference = Math.min(minDifference, right - left);
                maxMins = right;
                left = right;
            }
            right++;
        }

        //Calculate between first and last element 
        int minsFromMidnight = calculateMins("24:00") - maxMins;
        minDifference = Math.min(minDifference, minsFromMidnight + minMins);
        return minDifference;
    }

    private int calculateMins(String time) {
        String[] split = time.split(":");
        return 60 * Integer.parseInt(split[0]) + Integer.parseInt(split[1]);
    }
}