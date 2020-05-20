class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        backtracking(ans, new ArrayList<Integer>(), k, n, 1);
        return ans;
    }
    
    private void backtracking(List<List<Integer>> ans, List<Integer> list, int k, int remains, int start) {
        if (k == 0 && remains == 0) {
            ans.add(new ArrayList<>(list));
            return;
        }
        
        for (int i = start; i <= 9; i++) {
            list.add(i);
            backtracking(ans, list, k - 1, remains - i, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
