class Solution {
    public int balancedStringSplit(String s) {
        int ans = 0;
        int sub = 0;
        
        for (char ch : s.toCharArray()) {
            if (ch == 'L')
                sub++;
            else
                sub--;
            
            if (sub == 0)
                ans++;
        }
        
        return ans;
    }
}
