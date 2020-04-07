class Solution {
    public int numJewelsInStones(String J, String S) {
        int count = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (char c : S.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (char c : J.toCharArray()) {
            count += map.getOrDefault(c, 0);
        }
        return count;
    }
}
