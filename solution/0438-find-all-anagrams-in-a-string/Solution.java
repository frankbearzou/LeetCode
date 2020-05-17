class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int[] sArr = new int[26];
        int[] pArr = new int[26];
        int left = 0, right = 0;
        List<Integer> ans = new ArrayList<>();
        if (s.length() < p.length())
            return ans;

        // fill the window
        while (right < p.length()) {
            sArr[s.charAt(right) - 'a']++;
            pArr[p.charAt(right) - 'a']++;
            right++;
        }
        right--;

        while (right < s.length()) {
            if (Arrays.equals(sArr, pArr))
                ans.add(left);
            right++;
            if (right < s.length())
                sArr[s.charAt(right) - 'a']++;
            sArr[s.charAt(left) - 'a']--;
            left++;
        }

        return ans;
    }
}
