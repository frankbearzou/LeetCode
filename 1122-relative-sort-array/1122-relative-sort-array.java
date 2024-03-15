class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] res = new int[arr1.length];
        int[] map = new int[1001];
        for (int num : arr1) {
            map[num]++;
        }
        int index = 0;
        for (int num : arr2) {
            if (map[num] > 0) {
                while (map[num]-- > 0) {
                    res[index++] = num;
                }
            }
        }
        for (int i = 0; i < 1001; i++) {
            if (map[i] > 0) {
                while (map[i]-- > 0) {
                    res[index++] = i;
                }
            }
        }
        return res;
    }
}