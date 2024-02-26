class Solution {
    public int maxChunksToSorted(int[] arr) {
        int count = 0;
        int max = -1;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, arr[i]);
            if (max == i) {
                count++;
            }
        }
        return count;
    }
}