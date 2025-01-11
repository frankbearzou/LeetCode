class Solution {
    public boolean validTicTacToe(String[] board) {
        int x = 0, o = 0;
        int xwin = 0, owin = 0;
        int[][] arr = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                char c = board[i].charAt(j);
                if (c == 'X') {
                    arr[i][j] = 1;
                    x++;
                } else if (c == 'O') {
                    arr[i][j] = -1;
                    o++;
                }
            }
        }
        if (o > x || x - o > 1)
            return false;
        for (int i = 0; i < 3; i++) {
            int sum = 0;
            for (int j = 0; j < 3; j++) {
                sum += arr[i][j];
            }
            if (sum == 3) {
                xwin++;
            } else if (sum == -3) {
                owin++;
            }
        }
        for (int j = 0; j < 3; j++) {
            int sum = 0;
            for (int i = 0; i < 3; i++) {
                sum += arr[i][j];
            }
            if (sum == 3) {
                xwin++;
            } else if (sum == -3) {
                owin++;
            }
        }
        int sum = arr[0][0] + arr[1][1] + arr[2][2];
        if (sum == 3) {
            xwin++;
        } else if (sum == -3) {
            owin++;
        }
        sum = arr[0][2] + arr[1][1] + arr[2][0];
        if (sum == 3) {
            xwin++;
        } else if (sum == -3) {
            owin++;
        }
        if (xwin >= 1 && owin >= 1)
            return false;
        if (xwin == 1 && (x == o))
            return false;
        if (owin == 1 && (x >= o))
            return false;
        return true;
    }
}