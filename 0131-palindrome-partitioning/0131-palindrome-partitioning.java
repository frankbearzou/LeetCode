class Solution {
    List<List<String>> res = new ArrayList<>();
    List<String> path = new ArrayList<>();
    String s;
    int n;

    public List<List<String>> partition(String s) {
        this.s = s;
        n = s.length();
        dfs(0, 0);
        return res;
    }

    void dfs(int start, int end) {
        if (end == n) {
            res.add(new ArrayList(path));
            return;
        }
        // extend, not new string
        if (end < n - 1) {
            dfs(start, end + 1);
        }
        
        // make new string
        if (isPalindrome(start, end)) {
            path.add(s.substring(start, end + 1));
            dfs(end + 1, end + 1);
            path.removeLast();
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