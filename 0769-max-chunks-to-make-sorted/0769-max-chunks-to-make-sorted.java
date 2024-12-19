class Solution {
    public int maxChunksToSorted(int[] arr) {
        int count = 0;
        int n = arr.length;
        int index = 0;
        for (int i = 0; i < n; i++) {
            index = Math.max(index, arr[i]);
            if (index == i) {
                count++;
            }
        }
        return count;
    }
}