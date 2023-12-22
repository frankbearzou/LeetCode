class Solution {
    public int maxScore(String s) {
        int ans = 0;
        int l = 0, r = 0;
        char[] arr = s.toCharArray();
        if (arr[0] == '0')
            l = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == '1')
                r++;
        }
        ans = l + r;
        for (int i = 1; i < arr.length - 1; i++) {
            if (arr[i] == '0')
                l++;
            else
                r--;
            ans = Math.max(ans, l + r);
        }
        return ans;
    }
}