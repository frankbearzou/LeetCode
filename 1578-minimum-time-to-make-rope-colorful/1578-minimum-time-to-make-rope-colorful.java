class Solution {
    public int minCost(String colors, int[] neededTime) {
        int ans = 0;
        int l = 0, r = 1;
        char[] arr = colors.toCharArray();
        while (r < neededTime.length) {
            while (r < neededTime.length && arr[l] == arr[r]) {
                if (neededTime[l] < neededTime[r]) {
                    ans += neededTime[l];
                    l = r;
                    r++;
                } else {
                    ans += neededTime[r];
                    r++;
                }
            }
            if (r - l == 1) {
                l++;
                r++;
            } else {
                l = r;
                r++;
            }
        }
        return ans;
    }
}