class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
        int n = nums.length;
        if (n % k != 0)
            return false;
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        Queue<Integer> queue = new PriorityQueue<>(list);
        list = new ArrayList<>();
        while (!queue.isEmpty()) {
            int top = queue.remove();
            int count = 1;
            for (int i = 1; i < k; i++) {
                while (!queue.isEmpty()) {
                    int t = queue.remove();
                    if (t < top + i) {
                        list.add(t);
                    } else if (t == top + i) {
                        count++;
                        break;
                    } else {
                        return false;
                    }
                }
            }
            if (count != k)
                return false;
            queue.addAll(list);
            list = new ArrayList<>();
        }
        return true;
    }
}