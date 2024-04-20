class Solution {
    public int[][] findFarmland(int[][] land) {
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[0].length; j++) {
                if (land[i][j] == 1) {
                    int r = i, c = j;
                    while (r + 1 < land.length && land[r + 1][c] == 1)
                        r++;
                    while (c + 1 < land[0].length && land[r][c + 1] == 1)
                        c++;
                    for (int p = i; p <= r; p++) {
                        for (int q = j; q <= c; q++) {
                            land[p][q] = 0;
                        }
                    }
                    list.add(new int[]{i, j, r, c});
                }
            }
        }
        int[][] res = new int[list.size()][4];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}