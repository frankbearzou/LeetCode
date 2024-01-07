class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int ans = 0;
        int n = nums.length;
        List<Map<Long, Integer>> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            Map<Long, Integer> cur = new HashMap<>();
            for (int j = 0; j < i; j++) {
                long d = (long)nums[i] - nums[j];
                int count = cur.getOrDefault(d, 0);
                Map<Long, Integer> pre = list.get(j);
                count += pre.getOrDefault(d, 0);
                count++;
                cur.put(d, count);
            }
            list.add(cur);
        }
        for (var map : list) {
            for (var v : map.values()) {
                ans += v;
            }
        }
        return ans - (n - 1) * n / 2;
    }
}