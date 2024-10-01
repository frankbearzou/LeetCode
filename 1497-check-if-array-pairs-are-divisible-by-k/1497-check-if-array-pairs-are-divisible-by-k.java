class Solution {
    public boolean canArrange(int[] arr, int k) {
        int[] array = new int[k];
        for (int i : arr) {
            int mod = ((i % k) + k) % k;
            array[mod]++;
        }
        int l = 1, r = k - 1;
        while (l < r) {
            if (array[l] != array[r])
                return false;
            l++;
            r--;
        }
        return true;
    }
}