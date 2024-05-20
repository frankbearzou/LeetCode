class Solution {
    public boolean canThreePartsEqualSum(int[] arr) {
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }
        if (sum % 3 != 0)
            return false;
        int avg = sum / 3;
        int count = 0;
        int sub = 0;
        for (int i : arr) {
            sub += i;
            if (sub == avg) {
                count++;
                sub = 0;
            }
        }
        return count == 3;
    }
}