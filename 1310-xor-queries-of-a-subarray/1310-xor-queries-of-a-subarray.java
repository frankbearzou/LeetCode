class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        // prefix xor, running xor
        int n = queries.length;
        int[] prefix = new int[n];
        prefix[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            prefix[i] = prefix[i - 1] ^ arr[i];
        }
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int left = queries[i][0];
            int right = queries[i][1];
            ans[i] = prefix[right];
            if (left > 0)
                ans[i] = ans[i] ^ prefix[left - 1];
        }
        return ans;
    }
}