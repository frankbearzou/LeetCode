class Solution {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        List<int[]> list = new ArrayList<>();
        int i = 0, j = 0;
        while (i < A.length && j < B.length) {
            int[] arr = new int[2];

            // first bit
            if (A[i][0] >= B[j][0] && A[i][0] <= B[j][1]) {
                arr[0] = A[i][0];
            } else if (B[j][0] >= A[i][0] && B[j][0] <= A[i][1]) {
                arr[0] = B[j][0];
            } else {
                if (A[i][1] < B[j][0]) {
                    i++;
                    continue;
                } else if (A[i][0] > B[j][1]) {
                    j++;
                    continue;
                }
            }

            // second bit
            if (A[i][1] < B[j][1]) {
                arr[1] = A[i][1];
                i++;
            } else if (A[i][1] > B[j][1]) {
                arr[1] = B[j][1];
                j++;
            } else {
                arr[1] = A[i][1];
                i++;
                j++;
            }

            list.add(arr);
        }
        
        int[][] ans = new int[list.size()][2];
        for (int k = 0; k < ans.length; k++)
            ans[k] = list.get(k);
        
        return ans;
    }
}
