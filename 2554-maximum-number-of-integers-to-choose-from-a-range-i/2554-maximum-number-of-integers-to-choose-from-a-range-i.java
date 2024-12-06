class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        int count = 0;
        Set<Integer> ban = new HashSet<>();
        for (int b : banned) {
            ban.add(b);
        }
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            if (ban.contains(i))
                continue;
            if (sum + i <= maxSum) {
                sum += i;
                count++;
            } else
                break;
        }
        return count;
    }
}