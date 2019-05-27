class Solution {
    public String removeOuterParentheses(String S) {
        int i = 0;
        StringBuilder sb = new StringBuilder();
        
        for (char c : S.toCharArray()) {
            if (c == '(') {
                if (i > 0) {
                    sb.append('(');
                }
                ++i;
            } else {
                if (i != 1) {
                    sb.append(')');
                }
                --i;
            }
        }
        
        return sb.toString();
    }
}
