class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n = spells.length;
        int[] res = new int[n];
        Arrays.sort(potions);
        for (int i = 0; i < n; i++) {
            res[i] = binarySearch(potions, spells[i], success);
        }
        return res;
    }

    int binarySearch(int[] potions, int spell, long success) {
        int l = 0, r = potions.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if ((long)potions[m] * spell < success) {
                l = m + 1;
            } else {
                r = m -1;
            }
        }
        return potions.length - l;
    }
}