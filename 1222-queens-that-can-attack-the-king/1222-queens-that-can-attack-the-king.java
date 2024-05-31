class Solution {
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        List<List<Integer>> res = new ArrayList<>();
        int[] dirs = {-1, 0, 1};
        boolean[][] queenSet = new boolean[8][8];
        for (int[] queen : queens) {
            queenSet[queen[0]][queen[1]] = true;
        }
        for (int dr : dirs) {
            for (int dc : dirs) {
                 if (dr == 0 && dc == 0)
                    continue;
                int r = king[0];
                int c = king[1];
                while (r + dr >= 0 && r + dr < 8 && c + dc >= 0 && c + dc < 8) {
                    r = r + dr;
                    c = c + dc;
                    if (queenSet[r][c]) {
                        res.add(List.of(r, c));
                        break;
                    }
                }
            }
        }
        return res;
    }
}