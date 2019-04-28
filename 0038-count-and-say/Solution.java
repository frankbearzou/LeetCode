class Solution {
    public String countAndSay(int n) {
        if (n == 1)
            return "1";
        String pre = countAndSay(n - 1);

        StringBuilder sb = new StringBuilder();
        char c = pre.charAt(0);
        int count = 1;
        for (int i = 1; i < pre.length(); i++) {
            if (pre.charAt(i) == c) {
                ++count;
            } else {
                sb.append(count).append(c);
                c = pre.charAt(i);
                count = 1;
            }
        }
        sb.append(count).append(c);
        return sb.toString();
    }
}
