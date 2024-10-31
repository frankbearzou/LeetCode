class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[][] arr = new int[trips.length * 2][2];
        int i = 0;
        for (int[] trip : trips) {
            arr[i++] = new int[]{trip[1], trip[0]};
            arr[i++] = new int[]{trip[2], -trip[0]};
        }
        Arrays.sort(arr, (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
        int count = 0;
        for (int[] trip : arr) {
            count += trip[1];
            if (count > capacity)
                return false;
        }
        return true;
    }
}