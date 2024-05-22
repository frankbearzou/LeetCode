class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> path = new ArrayList<>();
        backtracking(s, 0, path, res);
        return res;
    }

    void backtracking(String s, int start, List<String> path, List<List<String>> res) {
        if (start == s.length()) {
            res.add(new ArrayList(path));
            return;
        }
        for (int i = start; i < s.length(); i++) {
            if (!isPalindrome(s, start, i))
                continue;
            path.add(s.substring(start, i + 1));
            backtracking(s, i + 1, path, res);
            path.remove(path.size() - 1);
        }
    }

    boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }
}