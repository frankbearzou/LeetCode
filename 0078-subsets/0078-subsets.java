class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        backtracking(ans, new ArrayList<Integer>(), nums, 0);
        return ans;
    }
    
    private void backtracking(List<List<Integer>> ans, List<Integer> list, int[] nums, int start) {
        ans.add(new ArrayList<>(list));
        
        for (int i = start; i < nums.length; i++) {
            list.add(nums[i]);
            backtracking(ans, list, nums, i + 1);
            list.remove(list.size() - 1);
        }
    }
}