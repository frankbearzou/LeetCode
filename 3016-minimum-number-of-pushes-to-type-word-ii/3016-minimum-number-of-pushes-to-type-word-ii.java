class Solution {
    public int minimumPushes(String word) {
        int sum = 0;
        int[] map = new int[26];
        for (char c : word.toCharArray()) {
            map[c - 'a']++;
        }
        Arrays.sort(map);
        int times = 0;
        for (int i = 25, j = 0; i >= 0 && map[i] != 0; i--, j++) {
            if (j % 8 == 0)
                times++;
            sum += map[i] * times;
        }
        return sum;
    }
}