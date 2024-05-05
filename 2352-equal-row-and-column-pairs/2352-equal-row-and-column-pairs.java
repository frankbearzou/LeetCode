class Solution {
    public int equalPairs(int[][] grid) {
        int count = 0;
        Map<String, Integer> map = new HashMap<>();
        for (int[] row : grid) {
            List<Integer> list = new ArrayList<>();
            for (int i : row) {
                list.add(i);
            }
            String hash = getHash(list);
            map.put(hash, map.getOrDefault(hash, 0) + 1);
        }
        for (int j = 0; j < grid.length; j++) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < grid.length; i++) {
                list.add(grid[i][j]);
            }
            String hash = getHash(list);
            count += map.getOrDefault(hash, 0);
        }
        return count;
    }

    String getHash(List<Integer> list) {
        StringBuilder res = new StringBuilder();
        for (int i : list) {
            res.append(i).append("_");
        }
        return res.toString();
    }
}