class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int n = arr.length;
        if (n == 0)
            return new int[0];
        int[] array = Arrays.copyOf(arr, n);
        Arrays.sort(array);
        int rank = 1;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(array[0], rank);
        for (int i = 1; i < n; i++) {
            if (array[i - 1] != array[i]) {
                map.put(array[i], ++rank);
            }
        }
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = map.get(arr[i]);
        }
        return ans;
    }
}