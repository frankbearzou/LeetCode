class Solution {
    public int minFlips(String target) {
        int count = 0;
        char last = '0';
        for (char c : target.toCharArray()) {
            if (c != last) {
                count++;
                last = last == '0' ? '1' : '0';
            }
        }
        return count;
    }
}