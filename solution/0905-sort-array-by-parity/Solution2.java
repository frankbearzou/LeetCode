class Solution {
    public int[] sortArrayByParity(int[] A) {
        int odd = A.length;
        // find first odd position
        for (int i = 0; i < A.length; i++) {
            if (A[i] % 2 == 1) {
                odd = i;
                break;
            }
        }
        
        for (int i = odd + 1; i < A.length; i++) {
            if (A[i] % 2 == 0) {
                // swap odd and pos i
                int t = A[odd];
                A[odd] = A[i];
                A[i] = t;
                odd++;
            }
        }
        
        return A;
    }
}
