class Solution {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        for (int pile : piles) {
            queue.add(pile);
        }
        for (int i = 0; i < k; i++) {
            int top = queue.remove();
            top = (int)Math.ceil(1.0 * top / 2);
            queue.add(top);
        }
        int sum = 0;
        while (!queue.isEmpty()) {
            sum += queue.remove();
        }
        return sum;
    }
}