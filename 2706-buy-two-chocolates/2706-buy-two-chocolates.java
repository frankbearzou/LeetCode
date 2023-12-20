class Solution {
    public int buyChoco(int[] prices, int money) {
        int min = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        for (int price : prices) {
            if (price <= min) {
                min2 = min;
                min = price;
            } else if (price < min2) {
                min2 = price;
            }
        }
        int left = money - min - min2;
        return left < 0 ? money : left;
    }
}