class Solution {
    public String maskPII(String s) {
        if (s.contains("@")) {
            s = s.toLowerCase();
            int index = s.indexOf("@");
            return s.charAt(0) + "*****" + s.substring(index - 1) ;
        } else {
            String res = "";
            int count = 0;
            for (char c : s.toCharArray()) {
                if (c >= '0' && c <= '9')
                    count++;
            }
            if (count > 10) {
                res = "+";
                for (int i = 10; i < count; i++) {
                    res += "*";
                }
                res += "-";
            }
            res += "***-***-";
            int i = s.length() - 1;
            int cnt = 4;
            StringBuilder last = new StringBuilder();
            while (cnt > 0) {
                if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                    last.append(s.charAt(i));
                    cnt--;
                }
                i--;
            }
            return res + last.reverse().toString();
        }
    }
}