class Solution {
    public int findMinDifference(List<String> timePoints) {
        List<Integer> minutes = new ArrayList<>();
        for(String time : timePoints) {
            int mins = calculateMins(time);
            minutes.add(mins);
        }

        Collections.sort(minutes);

        int minDifference = Integer.MAX_VALUE;
        for(int i = 1; i < minutes.size(); i++) {
            minDifference = Math.min(minDifference, minutes.get(i) - minutes.get(i - 1));
        }
        //Compare first and last minutes
        int minutesFromMidnight = calculateMins("24:00") - minutes.get(minutes.size() - 1);
        minDifference = Math.min(minDifference, minutesFromMidnight + minutes.get(0));

        return minDifference;
    }

    private int calculateMins(String time) {
        String[] split = time.split(":");
        return Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
    }
}