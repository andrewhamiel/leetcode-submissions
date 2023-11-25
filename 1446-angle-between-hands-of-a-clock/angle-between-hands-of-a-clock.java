class Solution {
    private static double NUM_HOURS = 12.0, NUM_MINUTES = 60.0;
    private static double ANGLE_HOURS = 30.0, ANGLE_MINUTES = 6.0;

    public double angleClock(int hour, int minutes) {
        double minutesAngle = minutes * ANGLE_MINUTES;
        double hoursAngle = ((hour + (minutes/NUM_MINUTES)) % NUM_HOURS) * ANGLE_HOURS;
        double diff = Math.abs(hoursAngle - minutesAngle);
        return Math.min(diff, 360 - diff);
    }
}