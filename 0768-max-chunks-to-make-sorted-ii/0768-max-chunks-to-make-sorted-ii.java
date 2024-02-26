class Solution {
    public int maxChunksToSorted(int[] arr) {
        int count = 0;
        int[] sorted = arr.clone();
        Arrays.sort(sorted);
        int suma = 0, sums = 0;
        for (int i = 0; i < arr.length; i++) {
            suma += arr[i];
            sums += sorted[i];
            if (suma == sums) {
                count++;
            }
        }
        return count;
    }
}