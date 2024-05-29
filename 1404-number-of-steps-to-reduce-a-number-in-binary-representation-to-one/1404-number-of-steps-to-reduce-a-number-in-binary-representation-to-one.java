class Solution {
    public int numSteps(String s) {
        int count = 0;
        while (!"1".equals(s)) {
            if (s.charAt(s.length() - 1) == '0') {
                s = s.substring(0, s.length() - 1);
            } else {
                StringBuilder sb = new StringBuilder();
                boolean hasZero = false;
                int i = s.length() - 1;
                for (; i >= 0; i--) {
                    if (s.charAt(i) == '1')
                        sb.insert(0, '0');
                    else {
                        sb.insert(0, '1');
                        hasZero = true;
                        break;
                    }
                }
                if (hasZero) {
                    while (--i >= 0) {
                        sb.insert(0, s.charAt(i));
                    }
                } else {
                    sb.insert(0, '1');
                }
                s = sb.toString();
            }
            count++;
        }
        return count;
    }
}