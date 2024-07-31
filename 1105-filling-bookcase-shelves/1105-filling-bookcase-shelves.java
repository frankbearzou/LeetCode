class Solution {
    public int minHeightShelves(int[][] books, int shelfWidth) {
        int[] cache = new int[books.length];
        Arrays.fill(cache, -1);
        return dp(books, shelfWidth, 0, cache);
    }

    int dp(int[][] books, int shelfWidth, int index, int[] cache) {
        if (index == books.length)
            return 0;
        if (cache[index] != -1)
            return cache[index];
        int res = Integer.MAX_VALUE;
        int curH = 0, curW = 0;
        for (int i = index; i < books.length; i++) {
            int w = books[i][0], h = books[i][1];
            if (curW + w > shelfWidth)
                break;
            curW += w;
            curH = Math.max(curH, h);
            res = Math.min(res, curH + dp(books, shelfWidth, i + 1, cache));
        }
        return cache[index] = res;
    }
}