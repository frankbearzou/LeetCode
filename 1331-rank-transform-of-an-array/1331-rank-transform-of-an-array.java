class Solution {
    public int[] arrayRankTransform(int[] arr) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        Queue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            if (!map.containsKey(arr[i])) {
                map.put(arr[i], new ArrayList());
                pq.offer(arr[i]);
            }
            map.get(arr[i]).add(i);
        }
        int count = 1;
        int[] res = new int[arr.length];
        while (!pq.isEmpty()) {
            int top = pq.poll();
            for (int index : map.get(top)) {
                res[index] = count;
            }
            count++;
        }
        return res;
    }
}