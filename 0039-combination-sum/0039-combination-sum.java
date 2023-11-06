class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        backtracking(candidates, 0, new ArrayList<Integer>(), ans, 0, target);
        return ans;
    }

    private void backtracking(int[] candidates, int index, List<Integer> list, List<List<Integer>> ans, int sum, int target) {
        if (index >= candidates.length || sum > target)
            return;
        if (sum == target) {
            ans.add(new ArrayList<>(list));
            return;
        }
        list.add(candidates[index]);
        backtracking(candidates, index, list, ans, sum + candidates[index], target);
        list.remove(list.size() - 1);
        backtracking(candidates, index + 1, list, ans, sum, target);
    }
}