class Solution {
    public long pickGifts(int[] gifts, int k) {
        List<Integer> list = new ArrayList<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        for (int gift : gifts)
            queue.add(gift);
        long ans = 0;
        while (k-- > 0) {
            int top = queue.remove();
            queue.add((int)(Math.sqrt(top)));
        }
        while (!queue.isEmpty()) {
            ans += queue.remove();
        }
        return ans;
    }
}