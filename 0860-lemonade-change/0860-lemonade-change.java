class Solution {
    public boolean lemonadeChange(int[] bills) {
        int[] map = new int[3];
        for (int bill : bills) {
            if (bill == 5) {
                map[0]++;
            } else if (bill == 10) {
                if (map[0] <= 0) {
                    return false;
                } else {
                    map[0]--;
                    map[1]++;
                }
            } else if (bill == 20) {
                if (map[1] > 0) {
                    map[1]--;
                    if (map[0] > 0) {
                        map[0]--;
                    } else {
                        return false;
                    }
                } else {
                    if (map[0] < 3) {
                        return false;
                    }
                    map[0] -= 3;
                }
            }
        }
        return true;
    }
}