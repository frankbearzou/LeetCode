class Solution {
    public int numSplits(String s) {
        int count = 0;
        Map<Character, Integer> left = new HashMap<>();
        Map<Character, Integer> right = new HashMap<>();
        
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            right.put(ch, right.getOrDefault(ch, 0) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            Character ch = s.charAt(i);
            left.put(ch, left.getOrDefault(ch, 0) + 1);
            if (right.get(ch) == 1) {
                right.remove(ch);
            } else {
                right.put(ch, right.get(ch) - 1);
            }
            
            if (left.size() == right.size())
                count++;
        }
        return count;
    }
}
