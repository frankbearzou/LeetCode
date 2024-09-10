class Solution {
    public String strWithout3a3b(int a, int b) {
        StringBuilder res = new StringBuilder();
        while (a > 0 || b > 0) {
            boolean writeA = false;
            int len = res.length();
            if (len >= 2 && res.charAt(len - 1) == res.charAt(len - 2)) {
                if (res.charAt(len - 1) == 'b') {
                    writeA = true;
                }
            } else {
                if (a >= b)
                    writeA = true;
            }
            if (writeA) {
                res.append('a');
                a--;
            } else {
                res.append('b');
                b--;
            }
        }

        return res.toString();
    }
}