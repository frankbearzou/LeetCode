class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        if (s.length() < 4 || s.length() > 16)
            return ans;
        List<String> path = new ArrayList<>();
        backtracking(s, 0, path, ans);
        return ans;
    }

    void backtracking(String s, int start, List<String> path, List<String> ans) {
        if (path.size() == 3) {
            if (isValid(s, start, s.length() - 1)) {
                String temp = "";
                for (String t : path) {
                    temp += t + ".";
                }
                temp += s.substring(start);
                ans.add(temp);
            }
            return;
        }
        for (int i = start; i < s.length() && i < start + 3; i++) {
            if (!isValid(s, start, i))
                continue;
            path.add(s.substring(start, i + 1));
            backtracking(s, i + 1, path, ans);
            path.remove(path.size() - 1);
        }
    }

    boolean isValid(String s, int start, int end) {
        if (start >= s.length())
            return false;
        if (start < end && s.charAt(start) == '0')
            return false;
        int num = 0;
        for (int i = start; i <= end; i++) {
            num = num * 10 + (s.charAt(i) - '0');
        }
        return num >= 0 && num <=255;
    }
}