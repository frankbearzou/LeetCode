class Solution {
    private String compare(String S) {
        StringBuilder s = new StringBuilder(S);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '#') {
                s.delete(i - 1 >= 0 ? i - 1 : 0, i + 1);
                i = i - 2 <= -1 ? -1 : 0;
            }
        }
        return s.toString();
    }

    public boolean backspaceCompare(String S, String T) {
        return compare(S).equals(compare(T));
    }
}
