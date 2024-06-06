class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0)
            return false;
        Map<Integer, Integer> map = new HashMap<>();
        Queue<Integer> queue = new PriorityQueue<>();
        for (int i : hand) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        for (int key : map.keySet()) {
            queue.offer(key);
        }
        while (!queue.isEmpty()) {
            int size = groupSize;
            List<Integer> list = new ArrayList<>();
            while (!queue.isEmpty() && size-- > 0) {
                int top = queue.poll();
                if (list.isEmpty()) {
                    list.add(top);
                } else {
                    if (list.get(list.size() - 1) + 1 != top)
                        return false;
                    list.add(top);
                }
                if (map.get(top) == 1) {
                    map.remove(top);
                } else {
                    map.put(top, map.get(top) - 1);
                }
            }
            for (int i : list) {
                if (map.containsKey(i)) {
                    queue.offer(i);
                }
            }
        }
        return true;
    }
}