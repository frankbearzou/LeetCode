class Solution {
    public long minimumSteps(String s) {
        long ans = 0;
        long cur = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '1')
                cur++;
            else
                ans += cur;
        }
        return ans;
    }
}