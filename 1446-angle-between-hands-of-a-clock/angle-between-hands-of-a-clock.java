class Solution { 
    private static final int ONE_MIN_ANGLE = 6, ONE_HOUR_ANGLE = 30;
    private static final double HOURS = 12.0, MINUTES = 60.0;

    public double angleClock(int hour, int minutes) {
        double minutesAngle = minutes * ONE_MIN_ANGLE;
        double hoursAngle = (hour % HOURS + minutes/MINUTES) * ONE_HOUR_ANGLE;
        double diff = Math.abs(hoursAngle - minutesAngle);
        return Math.min(diff, 360 - diff);    
    }
}