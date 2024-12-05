class Solution {
    public boolean canChange(String start, String target) {
        int n = start.length();
        int i = 0, j = 0;
        while (i < n && j < n) {
            while (start.charAt(i) == '_')
                i++;
            while (target.charAt(j) == '_')
                j++;
            if (start.charAt(i) != target.charAt(j))
                return false;
            if (start.charAt(i) == 'L' && i < j)
                return false;
            if (start.charAt(i) == 'R' && i > j)
                return false;
            i++;
            j++;
        }
        while (i < n) {
            if (start.charAt(i) != '_')
                return false;
            i++;
        }
        while (j < n) {
            if (target.charAt(j) != '_')
                return false;
            j++;
        }
        return true;
    }
}