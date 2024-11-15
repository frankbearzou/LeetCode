class Solution {
    public int findLengthOfShortestSubarray(int[] arr) {
        int n = arr.length;
        int left = 0, right = n - 1;
        for (int i = 0; i < n - 1; i++) {
            if (arr[left] <= arr[left + 1])
                left++;
        }
        if (left == n - 1)
            return 0;
        for (int i = n - 1; i > 0; i--) {
            if (arr[right - 1] <= arr[right])
                right--;
        }
        int ans = Math.min(n - left - 1, right); // remove all after left or remove all before right
        int i = 0, j = right;
        while (i <= left && j < n) {
            if (arr[i] <= arr[j]) {
                ans = Math.min(ans, j - i - 1);
                i++;
            } else
                j++;
        }
        return ans;
    }
}