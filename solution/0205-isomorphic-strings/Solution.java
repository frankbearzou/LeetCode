class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
        	char cur = s.charAt(i);
        	if (map.containsKey(cur)) {
        		if (map.get(cur) != t.charAt(i))
        			return false;
        	} else {
        		if (map.containsValue(t.charAt(i)))
        			return false;
        		map.put(cur, t.charAt(i));
        	}
        }
        return true;
    }
}
