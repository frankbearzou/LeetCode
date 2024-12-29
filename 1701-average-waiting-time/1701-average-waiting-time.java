class Solution {
    public double averageWaitingTime(int[][] customers) {
        int n = customers.length;
        long t = 0;
        double sum = 0;
        for (int i = 0; i < n; i++) {
            if (t < customers[i][0]) {
                t = customers[i][0];
            }
            t += customers[i][1];
            sum += t - customers[i][0];
        }
        return sum / n;
    }
}