class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int[] arr = new int[n + 1];
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int a = A[i];
            int b = B[i];
            int count = 0;
            arr[a]++;
            if (arr[a] == 2)
                count++;
            arr[b]++;
            if (arr[b] == 2)
                count++;
            ans[i] = i == 0 ? count : ans[i - 1] + count;
        }
        return ans;
    }
}