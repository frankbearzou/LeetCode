class Solution {
    public int minimizeXor(int num1, int num2) {
        int a = bits(num1);
        int b = bits(num2);
        if (a == b) {
            return num1;
        } else if (a < b) {
            int shift = 0;
            int count = b - a;
            while (count > 0) {
                int bit = 1 << shift;
                if ((num1 & bit) == 0) {
                    num1 |= bit;
                    count--;
                }
                shift++;
            }
            return num1;
        } else {
            int shift = 0;
            int count = a - b;
            while (count > 0) {
                int bit = 1 << shift;
                if ((num1 & bit) == bit) {
                    num1 ^= bit;
                    count--;
                }
                shift++;
            }
            return num1;
        }
    }

    int bits(int num) {
        int count = 0;
        while (num > 0) {
            count += num & 1;
            num >>= 1;
        }
        return count;
    }
}