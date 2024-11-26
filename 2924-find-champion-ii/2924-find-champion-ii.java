class Solution {
    public int findChampion(int n, int[][] edges) {
        int[] inDegree = new int[n];
        for (int[] edge : edges) {
            inDegree[edge[1]]++;
        }
        int ans = -1;
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                if (ans == -1) {
                    ans = i;
                } else {
                    return -1;
                }
            }
        }
        return ans;
    }
}