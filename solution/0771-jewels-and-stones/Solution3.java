class Solution {
    public int numJewelsInStones(String J, String S) {
        Set<Character> set = new HashSet<>();
        int ans = 0;
        
        for (Character c : J.toCharArray())
            set.add(c);
        
        for (Character c : S.toCharArray()) {
            if (set.contains(c))
                ans++;
        }
        
        return ans;
    }
}
