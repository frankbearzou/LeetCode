class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> path = new ArrayList<>();
        backtracking(s, 0, path, ans);
        return ans;
    }

    void backtracking(String s, int start, List<String> path, List<List<String>> ans) {
        if (start >= s.length()) {
            ans.add(new ArrayList(path));
            return;
        }
        for (int i = start; i < s.length(); i++) {
            String temp = s.substring(start, i + 1);
            if (!isPalindrome(temp))
                continue;
            path.add(temp);
            backtracking(s, i + 1, path, ans);
            path.remove(path.size() - 1);
        }
    }

    boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r))
                return false;
            l++; r--;
        }
        return true;
    }
}