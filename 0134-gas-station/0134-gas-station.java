class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int start = 0, curSum = 0, sum = 0;
        for (int i = 0; i < cost.length; i++) {
            int rest = gas[i] - cost[i];
            curSum += rest;
            sum += rest;
            if (curSum < 0) {
                start = i + 1;
                curSum = 0;
            }
        }
        if (sum < 0)
            return -1;
        return start;
    }
}