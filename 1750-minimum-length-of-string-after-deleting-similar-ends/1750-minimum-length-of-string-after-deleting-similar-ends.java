class Solution {
    public int minimumLength(String s) {
        char[] arr = s.toCharArray();
        int l = 0, r = arr.length - 1;
        while (l < r) {
            if (arr[l] != arr[r])
                break;
            while (l + 1 < r && arr[l] == arr[l + 1])
                l++;
            while (l + 1 < r && arr[r - 1] == arr[r])
                r--;
            l++;
            r--;
        }
        return r - l + 1;
    }
}