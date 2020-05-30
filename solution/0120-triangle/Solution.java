class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() == 0)
            return 0;

        for (int i = 1; i < triangle.size(); i++) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                int upLeft = triangle.get(i - 1).get(Math.max(0, j - 1));
                int up = triangle.get(i - 1).get(Math.min(j, triangle.get(i - 1).size() - 1));
                triangle.get(i).set(j, triangle.get(i).get(j) + Math.min(upLeft, up));
            }
        }

        int min = triangle.get(triangle.size() - 1).get(0);
        for (int i = 1; i < triangle.get(triangle.size() - 1).size(); i++) {
            if (triangle.get(triangle.size() - 1).get(i) < min)
                min = triangle.get(triangle.size() - 1).get(i);
        }

        return min;
    }
}
