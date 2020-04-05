class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        if (strs.length == 1) return strs[0];
        int len = strs[0].length();
        for (int k = 1; k < strs.length; k++) {
            int curLen = strs[k].length();
            if (curLen < len) len = curLen;
        }
        
        int i = 0;
        for (i = 0; i < len; i++) {
            for (int j = 1; j < strs.length; j++) {
                if (strs[0].charAt(i) != strs[j].charAt(i)) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0].substring(0, i);
    }
}
