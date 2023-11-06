class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        backtracking(candidates, 0, new ArrayList<Integer>(), ans, target);
        return ans;
    }

    private void backtracking(int[] candidates, int index, List<Integer> list, List<List<Integer>>ans, int target) {
        if (target == 0) {
            ans.add(new ArrayList<>(list));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (target - candidates[i] < 0)
                break;
            list.add(candidates[i]);
            backtracking(candidates, i, list, ans, target - candidates[i]);
            list.remove(list.size() - 1);
        }
    }
}