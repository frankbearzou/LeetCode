class Solution {
    public String tictactoe(int[][] moves) {
        int n = moves.length;
        int[][] grid = new int[3][3];
        int score = 1; // A: 1, B: -1
        for (int[] move : moves) {
            grid[move[0]][move[1]] = score;
            score *= -1;
        }
        // row
        for (int i = 0; i < 3; i++) {
            int sum = 0;
            for (int j = 0; j < 3; j++) {
                sum += grid[i][j];
            }
            if (sum == 3)
                return "A";
            else if (sum == -3)
                return "B";
        }
        // column
        for (int j = 0; j < 3; j++) {
            int sum = 0;
            for (int i = 0; i < 3; i++) {
                sum += grid[i][j];
            }
            if (sum == 3)
                return "A";
            else if (sum == -3)
                return "B";
        }
        // diagonal
        int sum = grid[0][0] + grid[1][1] + grid[2][2];
        if (sum == 3)
            return "A";
        else if (sum == -3)
            return "B";
        sum = grid[0][2] + grid[1][1] + grid[2][0];
        if (sum == 3)
            return "A";
        else if (sum == -3)
            return "B";
        
        if (n == 9)
            return "Draw";
        else
            return "Pending";
    }
}