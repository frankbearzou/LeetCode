class Solution {
    public int[][] indexPairs(String text, String[] words) {
        List<int[]> list = new ArrayList<>();
        Set<String> set = new HashSet<>();
        for (String word : words)
            set.add(word);
        int n = text.length();
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (set.contains(text.substring(i, j + 1)))
                    list.add(new int[]{i, j});
            }
        }
        int[][] res = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++)
            res[i] = list.get(i);
        return res;
    }
}