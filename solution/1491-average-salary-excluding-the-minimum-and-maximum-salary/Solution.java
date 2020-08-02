class Solution {
    public double average(int[] salary) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        int sum = 0;
        for (int val : salary) {
            min = Math.min(min, val);
            max = Math.max(max, val);
            sum += val;
        }
        return 1.0 * (sum - min - max) / (salary.length - 2);
    }
}
