class Solution {
    public String reversePrefix(String word, char ch) {
        char[] arr = word.toCharArray();
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == ch) {
                index = i;
                break;
            }
        }
        if (index == -1)
            return word;
        int l = 0, r = index;
        while (l < r) {
            char c = arr[l];
            arr[l] = arr[r];
            arr[r] = c;
            l++;
            r--;
        }
        return new String(arr);
    }
}