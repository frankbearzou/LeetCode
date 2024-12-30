class Solution {
    public int maximumScore(int a, int b, int c) {
        int count = 0;
        Queue<Integer> queue = new PriorityQueue<>((x, y) -> y - x);
        queue.add(a);
        queue.add(b);
        queue.add(c);
        while (queue.size() > 1) {
            int x = queue.remove();
            int y = queue.remove();
            x--;
            y--;
            if (x > 0)
                queue.add(x);
            if (y > 0)
                queue.add(y);
            count++;
        }
        return count;
    }
}