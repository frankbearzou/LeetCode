class Solution {
    public int findGCD(int[] nums) {
        int min = 1001, max = 0;
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        for (int i = min; i >= 1; i--) {
            if ((max % i == 0) && (min % i == 0))
                return i;
        }
        return 1;
    }
}