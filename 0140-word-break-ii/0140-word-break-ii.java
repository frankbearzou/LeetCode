class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> res = new ArrayList<>();
        Set<String> set = new HashSet<>(wordDict);
        List<String> path = new ArrayList<>();
        backtracking(s, set, path, res, 0);
        return res;
    }

    void backtracking(String s, Set<String> set, List<String> path, List<String> res, int start) {
        if (start == s.length()) {
            res.add(String.join(" ", path));
            return;
        }
        for (int i = start + 1; i <= s.length(); i++) {
            String word = s.substring(start, i);
            if (set.contains(word)) {
                path.add(word);
                backtracking(s, set, path, res, i);
                path.remove(path.size() - 1);
            }
        }
    }
}