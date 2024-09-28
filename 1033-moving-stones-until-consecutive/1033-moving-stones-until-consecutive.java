class Solution {
    public int[] numMovesStones(int a, int b, int c) {
        int[] ans = new int[2];
        int x = Math.min(a, Math.min(b, c));
        int z = Math.max(a, Math.max(b, c));
        int y = a;
        if (b != x && b != z)
            y = b;
        else if (c != x && c != z)
            y = c;
        
        if (y - x == 1 && z - y == 1)
            ans[0] = 0;
        else if (y - x == 1 || z - y == 1)
            ans[0] = 1;
        else if (y - x == 2 || z - y == 2)
            ans[0] = 1;
        else
            ans[0] = 2;
        
        ans[1] = z - x - 2;
        return ans;
    }
}