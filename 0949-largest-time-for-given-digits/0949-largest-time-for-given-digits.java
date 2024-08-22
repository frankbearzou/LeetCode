class Solution {
    public String largestTimeFromDigits(int[] arr) {
        String res = "";
        int[] map = new int[10];
        for (int i : arr)
            map[i]++;
        if (map[2] > 0) {
            if (map[3] > 0) {
                map[2]--;
                map[3]--;
                res = "23:";
            } else if (map[2] > 1) {
                map[2] -= 2;
                res = "22:";
            } else if (map[1] > 0) {
                map[2]--;
                map[1]--;
                res = "21:";
            } else if (map[0] > 0) {
                map[2]--;
                map[0]--;
                res = "20:";
            } else {
                return "";
            }
        } else if (map[1] > 0) {
            res = "1";
            map[1]--;
            for (int i = 9; i >= 0; i--) {
                if (map[i] > 0) {
                    map[i]--;
                    res += i + ":";
                    break;
                }
            }
        } else if (map[0] > 0) {
            res = "0";
            map[0]--;
            for (int i = 9; i >= 0; i--) {
                if (map[i] > 0) {
                    map[i]--;
                    res += i + ":";
                    break;
                }
            }
        } else {
            return "";
        }
        boolean h = false;
        for (int i = 5; i >= 0; i--) {
            if (map[i] > 0) {
                h = true;
                res += i;
                map[i]--;
            }
        }
        if (!h)
            return "";
        for (int i = 9; i >= 0; i--) {
            if (map[i] > 0) {
                res += i;
                map[i]--;
            }
        }
        return res;
    }
}