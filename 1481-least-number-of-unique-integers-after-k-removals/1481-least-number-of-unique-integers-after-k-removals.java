class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Queue<Integer> queue = new PriorityQueue<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int val : map.values()) {
            queue.offer(val);
        }
        while (k > 0 && !queue.isEmpty()) {
            k -= queue.poll();
        }
        if (k == 0)
            return queue.size();
        else
            return queue.size() + 1;
    }
}