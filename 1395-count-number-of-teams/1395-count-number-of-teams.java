class Solution {
    public int numTeams(int[] rating) {
        int count = 0;
        int n = rating.length;
        int lSmaller = 0, lGreater = 0, rSmaller = 0, rGreater = 0;
        for (int i = 1; i < n - 1; i++) {
            for (int j = 0; j < i; j++) {
                if (rating[j] < rating[i])
                    lSmaller++;
                else if (rating[j] > rating[i])
                    lGreater++;
            }
            for (int j = i + 1; j < n; j++) {
                if (rating[j] < rating[i])
                    rSmaller++;
                else if (rating[j] > rating[i])
                    rGreater++;
            }
            count += lSmaller * rGreater + lGreater * rSmaller;
            lSmaller = lGreater = rSmaller = rGreater = 0;
        }
        return count;
    }
}