class Solution {
    public String fractionAddition(String expression) {
        int num = 0;
        int den = 1;
        int i = 0;
        while (i < expression.length()) {
            boolean neg = false;
            if (expression.charAt(i) == '+' || expression.charAt(i) == '-') {
                if (expression.charAt(i) == '-')
                    neg = true;
                i++;
            }
            // numerator
            int curNum = 0;
            while (Character.isDigit(expression.charAt(i))) {
                int d = expression.charAt(i) - '0';
                curNum = curNum * 10 + d;
                i++;
            }
            if (neg)
                curNum *= -1;
            // skip devide
            i++;
            // denominator
            int curDen = 0;
            while (i < expression.length() && Character.isDigit(expression.charAt(i))) {
                int d = expression.charAt(i) - '0';
                curDen = curDen * 10 + d;
                i++;
            }
            num = num * curDen + curNum * den;
            den = den * curDen;
        }
        int g = Math.abs(gcd(num, den));
        return (num / g) + "/" + (den / g);
    }

    int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }
}