class Solution {
    public int longestMountain(int[] arr) {
        int max = 0;
        int n = arr.length;
        for (int i = 1; i < n - 1; i++) {
            if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
                int left = i - 1;
                while (left > 0 && arr[left] > arr[left - 1])
                    left--;
                int right = i + 1;
                while (right < n - 1 && arr[right] > arr[right + 1])
                    right++;
                max = Math.max(max, right - left + 1);
            }
        }
        return max;
    }
}