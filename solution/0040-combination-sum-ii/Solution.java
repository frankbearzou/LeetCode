class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        backtracking(ans, new ArrayList<Integer>(), candidates, target, 0);
        return ans;
    }
    
    private void backtracking(List<List<Integer>> ans, List<Integer> list, int[] candidates, int remains, int start) {
        if (remains == 0) {
            ans.add(new ArrayList<>(list));
            return;
        }
        
        for (int i = start; i < candidates.length; i++) {
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }
            if (candidates[i] > remains)
                return;
            list.add(candidates[i]);
            backtracking(ans, list, candidates, remains - candidates[i], i + 1);
            list.remove(list.size() - 1);
        }
    }
}
