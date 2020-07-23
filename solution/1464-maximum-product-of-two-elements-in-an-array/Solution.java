class Solution {
    public int maxProduct(int[] nums) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int num : nums) {
            queue.add(num);
            if (queue.size() > 2)
                queue.poll();
        }
        return (queue.poll() - 1) * (queue.poll() - 1);
    }
}
