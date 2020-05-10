class Solution {
    public int findJudge(int N, int[][] trust) {
        if (trust.length < N - 1)
            return -1;
        
        int[] arr = new int[N + 1];
        for (int i = 0; i < trust.length; i++) {
            arr[trust[i][0]]--;
            arr[trust[i][1]]++;
        }
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == N - 1)
                return i;
        }
        return -1;
    }
}
