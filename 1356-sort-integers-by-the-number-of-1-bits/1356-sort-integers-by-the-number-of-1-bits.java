class Solution {
    public int[] sortByBits(int[] arr) {
        int[] ans = new int[arr.length];
        TreeMap<Integer, Queue<Integer>> map = new TreeMap<>();
        for (int num : arr) {
            int key = count(num);
            map.putIfAbsent(key, new PriorityQueue());
            map.get(key).add(num);
        }
        int i = 0;
        for (Queue<Integer> queue : map.values()) {
            while (!queue.isEmpty()) {
                ans[i++] = queue.poll();
            }
        }
        return ans;
    }

    int count(int num) {
        int count = 0;
        while (num > 0) {
            count += num & 1;
            num >>= 1;
        }
        return count;
    }
}