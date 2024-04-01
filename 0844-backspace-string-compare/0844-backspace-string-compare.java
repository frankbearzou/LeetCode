class Solution {
    public boolean backspaceCompare(String s, String t) {
        int i = s.length(), j = t.length();
        while (i >= 0 && j >= 0) {
            int back = 0;
            i--;
            j--;
            while (i >= 0) {
                if (s.charAt(i) == '#') {
                    back++;
                    i--;
                } else if (back > 0) {
                    back--;
                    i--;
                } else
                    break;
            }
            back = 0;
            while (j >= 0) {
                if (t.charAt(j) == '#') {
                    back++;
                    j--;
                } else if (back > 0) {
                    back--;
                    j--;
                } else
                    break;
            }
            if (i >= 0 && j >= 0 && s.charAt(i) != t.charAt(j))
                break;
        }
        return i == -1 && j == -1;
    }
}