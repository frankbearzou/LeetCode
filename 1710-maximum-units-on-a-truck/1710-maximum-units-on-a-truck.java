class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        int ans = 0;
        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);
        for (int[] box : boxTypes) {
            int take = Math.min(box[0], truckSize);
            ans += take * box[1];
            truckSize -= take;
            if (truckSize <= 0)
                break;
        }
        return ans;
    }
}