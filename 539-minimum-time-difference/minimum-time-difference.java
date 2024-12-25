class Solution {
    public int findMinDifference(List<String> timePoints) {
        boolean[] minutes = new boolean[24 * 60];
        int firstTime = Integer.MAX_VALUE;
        for(String time : timePoints) {
            int mins = calculateMins(time);
            if(minutes[mins]) return 0;
            minutes[mins] = true;
            firstTime = Math.min(firstTime, mins);
        }

        int minDifference = Integer.MAX_VALUE, maxTime = firstTime, prevTime = firstTime;
        for(int currTime = firstTime + 1; currTime < minutes.length; currTime++) {
            if(minutes[currTime]) {
                minDifference = Math.min(minDifference, currTime - prevTime);
                prevTime = currTime;
                maxTime = currTime;
            }
        }

        //Calculate difference between last and first time
        int minsFromMidnight = calculateMins("24:00") - maxTime;
        minDifference = Math.min(minDifference, minsFromMidnight + firstTime);
        return minDifference;
    }

    private int calculateMins(String time) {
        String[] split = time.split(":");
        return Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
    }
}