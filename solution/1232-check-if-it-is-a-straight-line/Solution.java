class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        if (coordinates.length == 2)
            return true;
        int a = coordinates[1][1] - coordinates[0][1];
        int b = coordinates[1][0] - coordinates[0][0];
        for (int i = 1; i < coordinates.length - 1; i++) {
            if (a * (coordinates[i + 1][0] - coordinates[i][0]) != b * (coordinates[i + 1][1] - coordinates[i][1]))
                return false;
        }
        return true;
    }
}
