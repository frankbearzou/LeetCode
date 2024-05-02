class Solution {
    public int getLucky(String s, int k) {
        StringBuilder sb = new StringBuilder();
        int l = 0;
        for (char c : s.toCharArray()) {
            sb.append((int)(c - 'a' + 1));
        }
        String str = sb.toString();
        for (char c : str.toCharArray()) {
            l += c - '0';
        }
        k--;
        while (k-- > 0) {
            int res = 0;
            while (l > 0) {
                res += l % 10;
                l /= 10;
            }
            if (res < 10)
                return res;
            l = res;
        }
        return l;
    }
}