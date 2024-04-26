class Solution {
    public int findCenter(int[][] edges) {
        int n = edges.length;
        int[] arr = new int[n + 2];
        for (int[] edge : edges) {
            arr[edge[0]]++;
            arr[edge[1]]++;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == n)
                return i;
        }
        return -1;
    }
}