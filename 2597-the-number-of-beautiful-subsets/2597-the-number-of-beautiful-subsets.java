class Solution {
    int count = 0;

    public int beautifulSubsets(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        backtracking(nums, k, 0, list);
        return count;
    }

    void backtracking(int[] nums, int k, int start, List<Integer> list) {
        if (!list.isEmpty()) {
            count++;
        }
        for (int i = start; i < nums.length; i++) {
            if (contains(list, nums[i], k))
                continue;
            list.add(nums[i]);
            backtracking(nums, k, i + 1, list);
            list.remove(list.size() - 1);
        }
    }

    boolean contains(List<Integer> list, int val, int k) {
        for (int v : list) {
            if (v == val - k || v == val + k)
                return true;
        }
        return false;
    }
}