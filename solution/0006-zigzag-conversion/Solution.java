class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1)
            return s;
        String ans = "";
        int numInSubgroup = 2 * numRows - 2;
        int groups = s.length() / numInSubgroup + (s.length() % numInSubgroup == 0 ? 0 : 1);
        int col = (numRows - 1) * groups;
        char[][] arr = new char[numRows][col];

        int pos = 0, r = 0, c = 0;
        while (pos < s.length()) {
            // full column
            for (r = 0; r < numRows && pos < s.length(); r++) {
                arr[r][c] = s.charAt(pos);
                pos++;
            }
            r -= 2;
            c += 1;
            while (r >= 1 && pos < s.length()) {
                arr[r--][c++] = s.charAt(pos++);
            }
        }

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < col; j++) {
                if (arr[i][j] != 0)
                    ans += arr[i][j];
            }
        }

        return ans;
    }
}
