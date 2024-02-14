class Solution {
    public int firstUniqChar(String s) {
        Map<Character, Boolean> map = new HashMap<>();
        char[] arr = s.toCharArray();
        for (char c : arr) {
            map.put(c, map.containsKey(c));
        }
        for (int i = 0; i < arr.length; i++) {
            if (!map.get(arr[i]))
                return i;
        }
        return -1;
    }
}