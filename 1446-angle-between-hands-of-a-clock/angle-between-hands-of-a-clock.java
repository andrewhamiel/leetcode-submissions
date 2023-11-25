class Solution {
    private static double NUM_HOURS = 12.0, NUM_MINUTES = 60.0;
    private static double ANGLE_HOURS = 30.0, ANGLE_MINUTES = 6.0;
    public double angleClock(int hour, int minutes) {
        double minuteAngle = (minutes % NUM_MINUTES) * ANGLE_MINUTES;
        double hourAngle = ((minutes/NUM_MINUTES + hour) % NUM_HOURS) * ANGLE_HOURS;
        double diff = Math.abs(hourAngle - minuteAngle);
        return Math.min(diff, 360 - diff);
    }
}