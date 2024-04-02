class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> mapA = new HashMap<>();
        Map<Character, Character> mapB = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            char b = t.charAt(i);
            if (mapA.containsKey(a) && mapA.get(a) != b)
                return false;
            if (mapB.containsKey(b) && mapB.get(b) != a)
                return false;
            mapA.put(a, b);
            mapB.put(b, a);
        }
        return true;
    }
}