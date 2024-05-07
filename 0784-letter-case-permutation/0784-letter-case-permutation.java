class Solution {
    List<String> res = new ArrayList<>();

    public List<String> letterCasePermutation(String s) {
        backtracking(s, 0);
        return res;
    }

    void backtracking(String s, int start) {
        res.add(s);
        for (int i = start; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9')
                continue;
            if (c >= 'A' && c <= 'Z') {
                c = (char)(c + 32);
            } else {
                c = (char)(c - 32);
            }
            backtracking(s.substring(0, i) + c + s.substring(i + 1), i + 1);
        }
    }
}