class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int n = arr1.length;
        int[] res = new int[n];
        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        Queue<Integer> queue = new PriorityQueue<>();
        for (int num : arr2) {
            set.add(num);
        }
        for (int num : arr1) {
            if (set.contains(num))
                map.put(num, map.getOrDefault(num, 0) + 1);
            else
                queue.offer(num);
        }
        int index = 0;
        for (int num : arr2) {
            int count = map.get(num);
            while (count-- > 0) {
                res[index++] = num;
            }
        }
        while (!queue.isEmpty()) {
            res[index++] = queue.poll();
        }
        return res;
    }
}