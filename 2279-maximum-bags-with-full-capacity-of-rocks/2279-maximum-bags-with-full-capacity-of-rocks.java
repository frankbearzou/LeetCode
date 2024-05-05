class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int count = 0;
        Queue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < capacity.length; i++) {
            queue.offer(capacity[i] - rocks[i]);
        }
        while (!queue.isEmpty() && queue.peek() <= additionalRocks) {
            additionalRocks -= queue.poll();
            count++;
        }
        return count;
    }
}