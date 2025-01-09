class Solution {
    List<List<String>> res = new ArrayList<>();
    List<String> path = new ArrayList<>();
    String s;
    int n;

    public List<List<String>> partition(String s) {
        this.s = s;
        n = s.length();
        dfs(0);
        return res;
    }

    void dfs(int start) {
        if (start == n) {
            res.add(new ArrayList(path));
            return;
        }
        for (int i = start; i < n; i++) {
            if (isPalindrome(start, i)) {
                path.add(s.substring(start, i + 1));
                dfs(i + 1);
                path.removeLast();
            }
        }
    }

    boolean isPalindrome(int l, int r) {
        while (l < r) {
            if (s.charAt(l) != s.charAt(r))
                return false;
            l++;
            r--;
        }
        return true;
    }
}