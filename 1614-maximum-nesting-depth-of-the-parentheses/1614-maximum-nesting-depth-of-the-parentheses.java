class Solution {
    public int maxDepth(String s) {
        int res = 0;
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == '(')
                res = Math.max(res, ++count);
            else if (c == ')')
                count--;
        }
        return res;
    }
}