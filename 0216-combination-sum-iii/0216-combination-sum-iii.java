class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        backtracking(k, n, 1, list, ans);
        return ans;
    }

    void backtracking(int k, int n, int start, List<Integer> list, List<List<Integer>> ans) {
        if (list.size() == k) {
            if (n == 0) {
                ans.add(new ArrayList(list));
                return;
            } else {
                return;
            }
        }
        for (int i = start; i <= 9; i++) {
            if (n - i < 0)
                continue;
            list.add(i);
            backtracking(k, n - i, i + 1, list, ans);
            list.remove(list.size() - 1);
        }
    }
}