class Solution {
    public boolean isValid(String S) {
        String res = S;
        int i = S.length();
        int j = S.length();
        do {
            j = i;
            res = res.replaceAll("abc", "");
            i = res.length();
        } while (i < j);

        return res.length() == 0;
    }
}
