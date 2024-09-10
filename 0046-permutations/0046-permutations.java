class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    Set<Integer> set = new HashSet<>();
    int[] nums;
    int n;

    public List<List<Integer>> permute(int[] nums) {
        this.nums = nums;
        n = nums.length;
        dfs();
        return res;
    }

    void dfs() {
        if (path.size() == n) {
            res.add(new ArrayList(path));
            return;
        }
        for (int num : nums) {
            if (set.contains(num))
                continue;
            set.add(num);
            path.add(num);
            dfs();
            set.remove(num);
            path.removeLast();
        }
    }
}