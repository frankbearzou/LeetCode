class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        if (s.length() < p.length())
            return List.of();
        
        int l = 0, r = p.length();
        List<Integer> ans = new ArrayList<>();
        int[] mapS = new int[26];
        int[] mapP = new int[26];

        for (char c : p.toCharArray()) {
            mapP[c - 'a']++;
        }

        for (int i = 0; i < p.length(); i++) {
            mapS[s.charAt(i) - 'a']++;
        }

        if (same(mapS, mapP))
            ans.add(l);

        char[] arr = s.toCharArray();
        int len = arr.length;
        while (r < len) {
            mapS[arr[r] - 'a']++;
            mapS[arr[l++] - 'a']--;
            if (same(mapS, mapP)) {
                ans.add(l);
            }
            r++;
        }
        return ans;
    }

    private boolean same(int[] mapS, int[] mapP) {
        for (int i = 0; i < mapS.length; i++) {
            if (mapS[i] != mapP[i]) {
                return false;
            }
        }
        return true;
    }
}