class Solution {
    public boolean wordPattern(String pattern, String str) {
        Map<Character, String> map = new HashMap<>();
        
        String[] values = str.split(" ");
        if (pattern.length() != values.length)
            return false;
        for (int i = 0; i < pattern.length(); i++) {
            char key = pattern.charAt(i);
            String value = values[i];
            if (map.containsKey(key) && !value.equals(map.get(key)))
                return false;
            if (!map.containsKey(key) && map.containsValue(value))
                return false;
            if (!map.containsKey(key))
                map.put(key, value);
        }
        
        return true;
    }
}
