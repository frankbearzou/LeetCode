class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        // int[]: 0: value, 1: row, 2: col
        int max = -100_001;
        Queue<int[]> queue = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (int i = 0; i < nums.size(); i++) {
            queue.add(new int[]{nums.get(i).get(0), i, 0});
            max = Math.max(max, nums.get(i).get(0));
        }
        int minRange = -100_001;
        int maxRange = 100_001;
        while (true) {
            int[] arr = queue.remove();
            int val = arr[0], row = arr[1], col = arr[2];
            if (max - val < maxRange - minRange || ((max - val == maxRange - minRange && val < minRange))) {
                minRange = val;
                maxRange = max;
            }
            if (col + 1 < nums.get(row).size()) {
                queue.add(new int[]{nums.get(row).get(col + 1), row, col + 1});
                max = Math.max(max, nums.get(row).get(col + 1));
            } else
                break;
        }
        return new int[]{minRange, maxRange};
    }
}