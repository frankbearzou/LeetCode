class Solution {
    public boolean isLongPressedName(String name, String typed) {
        int i = 0, j = 0;
        char[] arr = name.toCharArray();
        char[] t = typed.toCharArray();
        if (arr[0] != t[0])
            return false;
        if (arr[arr.length - 1] != t[t.length - 1])
            return false;
        while (i < arr.length && j < t.length) {
            if (arr[i] == t[j]) {
                i++;
                j++;
            } else {
                if (t[j - 1] != t[j])
                    return false;
                else
                    j++;
            }
        }
        if (i < arr.length)
            return false;
        while (j < t.length) {
            if (t[j] != t[j - 1])
                return false;
            j++;
        }
        return true;
    }
}