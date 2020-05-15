class Solution {
    public int coinChange(int[] coins, int amount) {
        return coinChange(coins, amount, new HashMap<Integer, Integer>());
    }

    private int coinChange(int[] coins, int amount, Map<Integer, Integer> map) {
        if (amount < 0)
            return -1;
        if (amount == 0)
            return 0;
        if (map.containsKey(amount))
            return map.get(amount);
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = coinChange(coins, amount - coin, map);
            if (res >= 0)
                min = Math.min(min, res + 1);
        }
        if (min < Integer.MAX_VALUE)
            map.put(amount, min);
        else
            map.put(amount, -1);
        return map.get(amount);
    }
}
