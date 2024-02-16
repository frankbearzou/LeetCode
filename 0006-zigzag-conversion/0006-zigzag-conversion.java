class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1)
            return s;
        StringBuilder[] sb = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            sb[i] = new StringBuilder();
        }
        int row = 0;
        int flag = -1;
        for (char c : s.toCharArray()) {
            sb[row].append(c);
            if (row == 0 || row == numRows - 1) {
                flag = -flag;
            }
            row += flag;
        }
        StringBuilder ans = new StringBuilder();
        for (StringBuilder line : sb) {
            ans.append(line);
        }
        return ans.toString();
    }
}