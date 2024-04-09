class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int res = tickets[k];
        for (int i = 0; i < tickets.length; i++) {
            if (i == k)
                continue;
            res += Math.min(tickets[i], tickets[k]);
        }
        return res;
    }
}