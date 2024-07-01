class Solution {
    public double angleClock(int hour, int minutes) {
        double min = 1.0 * minutes / 60 * 360;
        double h = hour == 12 ? 0.0 : 1.0 * hour * 30;
        h = h + 30 * min / 360;
        return Math.min(Math.abs(h - min), 360 - Math.abs(h - min));
    }
}