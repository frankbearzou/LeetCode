class Solution {
    public boolean isThree(int n) {
        for (int i = 2; i < n - 1; i++) {
            if (n % i == 0) {
                if (i * i == n)
                    return true;
                else
                    return false;
            }
        }
        return false;
    }
}