class Solution {
    public int dietPlanPerformance(int[] calories, int k, int lower, int upper) {
        int res = 0;
        int n = calories.length;
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += calories[i];
        }
        for (int i = 0; i < n - k + 1; i++) {
            if (sum < lower)
                res--;
            else if (sum > upper)
                res++;
            sum -= calories[i];
            if (i + k < n)
                sum += calories[i + k];
        }
        return res;
    }
}