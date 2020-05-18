class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s2.length() == 0 || s1.length() > s2.length())
            return false;
        int[] s1Arr = new int[26];
        int[] s2Arr = new int[26];
        int begin = 0, end = 0;
        
        for (char c : s1.toCharArray()) {
            s1Arr[c - 'a']++;
        }
        
        while (end < s1.length()) {
            s2Arr[s2.charAt(end) - 'a']++;
            end++;
        }
        end--;
        
        while (end < s2.length()) {
            if (Arrays.equals(s1Arr, s2Arr))
                return true;
            s2Arr[s2.charAt(begin) - 'a']--;
            begin++;
            end++;
            if (end < s2.length())
                s2Arr[s2.charAt(end) - 'a']++;
        }
        
        return false;
    }
}
