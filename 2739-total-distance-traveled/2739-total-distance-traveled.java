class Solution {
    public int distanceTraveled(int mainTank, int additionalTank) {
        int total = 0;
        while (mainTank >= 5) {
            mainTank -= 5;
            if (additionalTank > 0) {
                mainTank += 1;
                additionalTank--;
            }
            total += 5;
        }
        return (total + mainTank) * 10;
    }
}