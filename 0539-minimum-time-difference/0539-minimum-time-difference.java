class Solution {
    public int findMinDifference(List<String> timePoints) {
        int diff = Integer.MAX_VALUE;
        int n = timePoints.size();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            String s = timePoints.get(i);
            int h = (s.charAt(0) - '0') * 10 + (s.charAt(1) - '0');
            int m = (s.charAt(3) - '0') * 10 + (s.charAt(4) - '0');
            arr[i] = h * 60 + m;
        }
        Arrays.sort(arr);
        for (int i = 0; i < n - 1; i++) {
            if (arr[i + 1] - arr[i] < diff) {
                diff = arr[i + 1] - arr[i];
            }
        }
        int first = arr[0] + 24 * 60;
        if (first - arr[n - 1] < diff) {
            diff = first - arr[n - 1];
        }
        return diff;
    }
}