class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        backtracking(ans, new ArrayList<Integer>(), nums, new boolean[nums.length]);
        return ans;
    }
    
    private void backtracking(List<List<Integer>> ans, List<Integer> list, int[] nums, boolean[] used) {
        if (list.size() == nums.length) {
            ans.add(new ArrayList<>(list));
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (used[i] || i > 0 && nums[i] == nums[i - 1] && !used[i - 1])
                continue;
            used[i] = true;
            list.add(nums[i]);
            backtracking(ans, list, nums, used);
            used[i] = false;
            list.remove(list.size() - 1);
        }
    }
}
