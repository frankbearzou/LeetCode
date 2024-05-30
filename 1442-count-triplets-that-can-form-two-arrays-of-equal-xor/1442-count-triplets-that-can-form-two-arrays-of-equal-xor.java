class Solution {
    public int countTriplets(int[] arr) {
        int count = 0;
        int n = arr.length + 1;
        int[] prefix = new int[n];
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] ^ arr[i - 1];
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (prefix[i] == prefix[j]) {
                    count += j - i -1;
                }
            }
        }
        return count;
    }
}