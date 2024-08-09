class Solution {
    public int numDifferentIntegers(String word) {
        boolean isDigit = false;
        int start = -1;
        int n = word.length();
        char[] arr = word.toCharArray();
        Set<Integer> set = new HashSet<>();
        int num = 0;
        for (int i = 0; i < n; i++) {
            char c = arr[i];
            if (c >= '0' && c <= '9') {
                isDigit = true;
                num = num * 10 + (int)(c - '0');
            } else {
                if (isDigit)
                    set.add(num);
                isDigit = false;
                num = 0;
            }
        }
        if (isDigit) {
            set.add(num);
        }
        return set.size();
    }
}