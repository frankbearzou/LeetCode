class Solution {
    public boolean checkOnesSegment(String s) {
        char[] arr = s.toCharArray();
        int n = arr.length;
        int i = 0;
        int count = 0;
        while (i < n && arr[i] == '1') {
            i++;
        }
        while (i < n && arr[i] == '0') {
            i++;
        }
        return i == n;
    }
}