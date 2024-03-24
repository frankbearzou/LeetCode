class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        long[] num = new long[n];
        for (int i = 0; i < n; i++)
            num[i] = nums[i];
        Arrays.sort(num);
        for (int a = 0; a < n - 3; a++) {
            if (a > 0 && num[a - 1] == num[a])
                continue;
            for (int b = a + 1; b < n - 2; b++) {
                if (b - a > 1 && num[b - 1] == num[b])
                    continue;
                if (num[a] + num[b] + num[b + 1] + num[b + 2] > target)
                    break;
                if (num[a] + num[b] + num[n - 2] + num[n - 1] < target)
                    continue;
                int c = b + 1, d = n - 1;
                while (c < d) {
                    long sum = num[a] + num[b] + num[c] + num[d];
                    if (sum < target) {
                        c++;
                        while (c < d && num[c - 1] == num[c])
                            c++;
                    } else if (sum > target) {
                        d--;
                        while (c < d && num[d] == num[d + 1])
                            d--;
                    } else {
                        res.add(List.of((int)num[a], (int)num[b], (int)num[c], (int)num[d]));
                        c++;
                        while (c < d && num[c - 1] == num[c])
                            c++;
                        d--;
                        while (c < d && num[d] == num[d + 1])
                            d--;
                    }
                }
            }
        }
        return res;
    }
}