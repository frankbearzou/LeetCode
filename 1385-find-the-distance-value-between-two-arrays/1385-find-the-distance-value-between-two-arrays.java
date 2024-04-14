class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int res = 0;
        for (int i : arr1) {
            boolean dis = true;
            for (int j : arr2) {
                if (Math.abs(i - j) <= d) {
                    dis = false;
                    break;
                }
            }
            if (dis)
                res++;
        }
        return res;
    }
}