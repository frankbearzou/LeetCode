class Solution {
    public int minimumDeletions(String s) {
        int n = s.length();
        int count = n;
        int countA = 0, countB = 0;
        int[] arrB = new int[n], arrA = new int[n];
        for (int i = 0; i < n; i++) {
            arrB[i] = countB;
            if (s.charAt(i) == 'b')
                countB++;
        }
        for (int i = n - 1; i >= 0; i--) {
            arrA[i] = countA;
            if (s.charAt(i) == 'a')
                countA++;
        }
        for (int i = 0; i < n; i++) {
            count = Math.min(count, arrA[i] + arrB[i]);
        }
        return count;
    }
}