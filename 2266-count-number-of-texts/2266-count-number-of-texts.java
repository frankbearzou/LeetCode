class Solution {
    public int countTexts(String pressedKeys) {
        int len = pressedKeys.length() + 1;
        if (len < 3)
            return 1;
        

        int mod = (int)1e9 + 7;
        
        long[] f = new long[len];
        long[] g = new long[len];

        f[0] = g[0] = 1;
        f[1] = g[1] = 1;
        f[2] = g[2] = 2;
        f[3] = g[3] = 4;
        for (int i = 4; i < len; i++) {
            f[i] = (f[i - 1] + f[i - 2] + f[i - 3]) % mod;
            g[i] = (g[i - 1] + g[i - 2] + g[i - 3] + g[i - 4]) % mod;
        }

        long ans = 1;
        int count = 0;
        for (int i = 0; i < pressedKeys.length(); i++) {
            count++;
            if (i == pressedKeys.length() - 1 || pressedKeys.charAt(i) != pressedKeys.charAt(i + 1)) {
                char c = pressedKeys.charAt(i);
                ans = ans * (c == '7' || c == '9' ? g[count] : f[count]) % mod;
                count = 0;
            }
        }
        return (int)ans;
    }
}