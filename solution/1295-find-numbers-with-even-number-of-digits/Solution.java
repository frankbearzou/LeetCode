class Solution {
    public int findNumbers(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res += digit(num);
        }
        return res;
    }
    
    private int digit(int num) {
        int d = 0;
        while (num != 0) {
            num /= 10;
            d++;
        }
        return d % 2 == 0 ? 1 : 0;
    }
}
