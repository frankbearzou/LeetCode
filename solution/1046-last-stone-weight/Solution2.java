class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>(Collections.reverseOrder());
        for (int i : stones) {
            heap.add(i);
        }
        while (heap.size() > 1) {
            int a = heap.poll();
            int b = heap.poll();
            int c = Math.abs(a - b);
            if (c != 0)
                heap.add(c);
        }
        if (heap.size() == 1)
            return heap.poll();
        else
            return 0;
    }
}
