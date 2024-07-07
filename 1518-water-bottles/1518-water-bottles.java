class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int count = numBottles;
        while (numBottles >= numExchange) {
            int remainder = numBottles % numExchange;
            numBottles /= numExchange;
            count += numBottles;
            numBottles += remainder;
        }
        return count;
    }
}