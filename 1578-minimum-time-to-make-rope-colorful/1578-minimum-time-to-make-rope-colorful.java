class Solution {
    public int minCost(String colors, int[] neededTime) {
        int ans = 0;
        int l = 0;
        char[] arr = colors.toCharArray();
        for (int r = 1; r < arr.length; r++) {
            if (arr[l] == arr[r]) {
                if (neededTime[l] < neededTime[r]) {
                    ans += neededTime[l];
                    l = r;
                } else {
                    ans += neededTime[r];
                }
            } else {
                l = r;
            }
        }
        return ans;
    }
}