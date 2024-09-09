class Solution {
    List<Integer> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    int n;
    int k;

    public int[] numsSameConsecDiff(int n, int k) {
        this.n = n;
        this.k = k;
        dfs(0);
        int[] arr = new int[res.size()];
        for (int i = 0; i < arr.length; i++)
            arr[i] = res.get(i);
        return arr;
    }

    void dfs(int start) {
        if (start == n) {
            int v = 0;
            for (int p : path) {
                v = v * 10 + p;
            }
            res.add(v);
            return;
        }
        
        if (path.isEmpty()) {
            for (int i = 1; i <= 9; i++) {
                path.add(i);
                dfs(start + 1);
                path.removeLast();
            }
        } else {
            int last = path.getLast();
            if (last - k >= 0) {
                path.add(last - k);
                dfs(start + 1);
                path.removeLast();
            }
            if (last + k <= 9 && k != 0) {
                path.add(last + k);
                dfs(start + 1);
                path.removeLast();
            }
        }
    }
}