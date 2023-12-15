class Solution {
    public String reverseStr(String s, int k) {
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i += k * 2) {
            int l = i;
            int r = i + k - 1;
            if (r >= arr.length) {
                r = arr.length - 1;
            }
            while (l < r) {
                char t = arr[l];
                arr[l] = arr[r];
                arr[r] = t;
                l++;
                r--;
            }
        }
        return new String(arr);
    }
}