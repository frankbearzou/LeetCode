class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> map = new HashMap<>();
        HashMap<Character, Integer> mag = new HashMap<>();
        
        for (Character c : ransomNote.toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);
        
        for (Character c : magazine.toCharArray())
            mag.put(c, mag.getOrDefault(c, 0) + 1);
        
        for (Character c : map.keySet()) {
            if (!mag.containsKey(c))
                return false;
            if (map.get(c) > mag.get(c))
                return false;
        }
        
        return true;
    }
}
