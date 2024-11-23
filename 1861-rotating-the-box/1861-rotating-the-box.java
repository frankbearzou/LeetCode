class Solution {
    public char[][] rotateTheBox(char[][] box) {
        int m = box.length;
        int n = box[0].length;
        char[][] ans = new char[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(ans[i], '.');
        }
        for (int i = 0; i < m; i++) {
            int ni = n - 1;
            int nj = m - i - 1;
            for (int j = n - 1; j >= 0; j--) {
                if (box[i][j] == '#') {
                    ans[ni][nj] = '#';
                    ni--;
                } else if (box[i][j] == '*') {
                    ans[j][nj] = '*';
                    ni = j - 1;
                }
            }
        }
        return ans;
    }
}