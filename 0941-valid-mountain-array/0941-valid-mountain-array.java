class Solution {
    public boolean validMountainArray(int[] arr) {
        if (arr.length < 3)
            return false;
        int l = 0, r = arr.length - 1;
        if (arr[l] >= arr[l + 1])
            return false;
        if (arr[r - 1] <= arr[r])
            return false;
        while (l < arr.length) {
            if (arr[l] < arr[l + 1]) {
                l++;
            } else {
                break;
            }
        }
        while (r > 0) {
            if (arr[r - 1] > arr[r]) {
                r--;
            } else {
                break;
            }
        }
        return l == r;
    }
}