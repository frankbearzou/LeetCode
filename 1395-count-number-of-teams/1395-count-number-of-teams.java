class Solution {
    public int numTeams(int[] rating) {
        int count = 0;
        int ls = 0, ll = 0, rs = 0, rl = 0; //l: left, r: right, s:smaller, l: larger
        for (int i = 1; i < rating.length - 1; i++) {
            for (int j = 0; j < i; j++) {
                if (rating[j] < rating[i])
                    ls++;
                else if (rating[j] > rating[i])
                    ll++;
            }
            for (int j = i + 1; j < rating.length; j++) {
                if (rating[j] < rating[i])
                    rs++;
                else if (rating[j] > rating[i])
                    rl++;
            }
            count += ls * rl + ll * rs;
            ls = ll = rs = rl = 0;
        }
        return count;
    }
}