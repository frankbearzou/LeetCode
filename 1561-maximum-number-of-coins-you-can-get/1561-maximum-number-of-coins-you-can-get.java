class Solution {
    public int maxCoins(int[] piles) {
        int ans = 0;
        int n = piles.length;
        Arrays.sort(piles);
        for (int i = n - 2, j = 0; j < n / 3; i -= 2, j++) {
            ans += piles[i];
        }
        return ans;
    }
}