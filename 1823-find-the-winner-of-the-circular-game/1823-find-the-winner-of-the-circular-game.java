class Solution {
    public int findTheWinner(int n, int k) {
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }
        while (queue.size() > 1) {
            for (int i = 0; i < k; i++) {
                queue.add(queue.remove());
            }
            queue.removeLast();
        }
        return queue.peek();
    }
}