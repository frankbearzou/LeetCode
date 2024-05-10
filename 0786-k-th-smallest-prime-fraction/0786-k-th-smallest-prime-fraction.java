class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        PriorityQueue<Pair> queue = new PriorityQueue<>((a, b) -> Double.compare(b.d, a.d));
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                queue.offer(new Pair(1.0 * arr[j] / arr[i], new int[]{arr[j], arr[i]}));
                if (queue.size() > k)
                    queue.poll();
            }
        }
        return queue.poll().arr;
    }
}

class Pair {
    double d;
    int[] arr;
    Pair(double d, int[] arr) {
        this.d = d;
        this.arr = arr;
    }
}