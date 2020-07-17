class Solution {
    public int numTeams(int[] rating) {
        int ans = 0;
        
        for (int i = 1; i < rating.length - 1; i++) {
            // 1. less
            int leftLess = 0, leftGreater = 0, rightGreater = 0, rightLess = 0;
            for (int j = 0; j < rating.length; j++) {
                if (j < i) {
                    if (rating[j] < rating[i])
                        leftLess++;
                    else if (rating[j] > rating[i])
                        leftGreater++;
                } else if (j > i) {
                    if (rating[j] > rating[i])
                        rightGreater++;
                    else if (rating[j] < rating[i])
                        rightLess++;
                }
            }
            ans += leftLess * rightGreater + leftGreater * rightLess;
        }
        
        return ans;
    }
}
