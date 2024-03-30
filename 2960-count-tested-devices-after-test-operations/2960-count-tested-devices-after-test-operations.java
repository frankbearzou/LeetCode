class Solution {
    public int countTestedDevices(int[] batteryPercentages) {
        int count = 0, dec = 0;
        for (int battery : batteryPercentages) {
            if (battery - dec > 0) {
                count++;
                dec++;
            }
        }
        return count;
    }
}