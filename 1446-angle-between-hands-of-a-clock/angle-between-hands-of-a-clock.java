class Solution {
    private static final int ONE_HOUR_ANGLE = 30, ONE_MIN_ANGLE = 6;
    private static final double NUM_HOURS = 12.0, NUM_MINUTES = 60.0;

    public double angleClock(int hour, int minutes) {
        double minutesAngle = minutes * ONE_MIN_ANGLE;
        double hoursAngle = (hour % NUM_HOURS + minutes/NUM_MINUTES) * ONE_HOUR_ANGLE;
        double diff = Math.abs(hoursAngle - minutesAngle);
        return Math.min(diff, 360 - diff);
    }
}