class Solution {
    public String generateTheString(int n) {
        StringBuilder res = new StringBuilder();
        int r = n;
        if (n % 2 == 0) {
            r = n - 1;
        }
        for (int i = 0; i < r; i++)
            res.append('a');
        if (r < n)
            res.append('b');
        return res.toString();
    }
}