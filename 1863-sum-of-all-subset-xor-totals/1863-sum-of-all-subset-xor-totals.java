class Solution {
    int sum = 0;

    public int subsetXORSum(int[] nums) {
        List<Integer> path = new ArrayList<>();
        backtracking(nums, 0, path);
        return sum;
    }

    void backtracking(int[] nums, int start, List<Integer> path) {
        int s = 0;
        for (int i : path) {
            s ^= i;
        }
        sum += s;
        
        for (int i = start; i < nums.length; i++) {
            path.add(nums[i]);
            backtracking(nums, i + 1, path);
            path.remove(path.size() - 1);
        }
        
    }
}