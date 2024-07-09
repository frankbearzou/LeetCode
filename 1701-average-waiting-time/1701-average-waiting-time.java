class Solution {
    public double averageWaitingTime(int[][] customers) {
        long sum = 0;
        int end = customers[0][0];
        for (int[] customer : customers) {
            sum += Math.max(end, customer[0]) + customer[1] - customer[0];
            end = Math.max(end, customer[0]) + customer[1];
        }
        return 1.0 * sum / customers.length;
    }
}