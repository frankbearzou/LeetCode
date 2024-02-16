class Solution {
    public int longestString(int x, int y, int z) {
        int sum = Math.min(x, y);
        sum *= 2;
        if (x != y) {
            sum += 1;
        }
        sum += z;
        return sum * 2;
    }
}