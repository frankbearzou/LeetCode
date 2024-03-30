class Solution {
    public String finalString(String s) {
        int n = s.length(), index = 0;
        char[] arr = new char[n];
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) != 'i') {
                arr[index] = s.charAt(i);
                index++;
            } else {
                int l = 0, r = index - 1;
                while (l < r) {
                    char c = arr[l];
                    arr[l] = arr[r];
                    arr[r] = c;
                    l++;
                    r--;
                }
            }
        }
        return new String(arr, 0, index);
    }
}