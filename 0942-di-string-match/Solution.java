class Solution {
    public int[] diStringMatch(String S) {
        int N = S.length();
        int low = 0, high = N;
        int[] result = new int[N + 1];
        
        for (int i = 0; i < N; i++) {
            if (S.charAt(i) == 'I') {
                result[i] = low++;
            } else {
                result[i] = high--;
            }
        }
        result[N] = high;
        
        return result;
    }
}
