class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        backtracking(ans, new ArrayList<Integer>(), nums);
        return ans;
    }
    
    private void backtracking(List<List<Integer>> ans, List<Integer> list, int[] nums) {
        if (list.size() == nums.length) {
            ans.add(new ArrayList<>(list));
            return;
        }
        
        for (int num : nums) {
            if (list.contains(num))
                continue;
            list.add(num);
            backtracking(ans, list, nums);
            list.remove(list.size() - 1);
        }
    }
}
