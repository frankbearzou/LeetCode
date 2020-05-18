class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        backtracking(ans, new ArrayList<Integer>(), n, k, 1);
        return ans;
    }
    
    private void backtracking(List<List<Integer>> ans, List<Integer> list, int n, int k, int start) {
        if (list.size() == k) {
            ans.add(new ArrayList<>(list));
            return;
        }
        
        for (int i = start; i <= n; i++) {
            list.add(i);
            backtracking(ans, list, n, k, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
