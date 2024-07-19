class Solution {
    public String reformatNumber(String number) {
        StringBuilder str = new StringBuilder();
        for (char c : number.toCharArray()) {
            if (c >= '0' && c <= '9') {
                str.append(c);
            }
        }
        StringBuilder res = new StringBuilder();
        number = str.toString();
        int n = number.length();
        int i = 0;
        while (i < n) {
            if (i + 4 >= n) {
                if (n - i == 4) {
                    res.append(number.substring(i, i + 2)).append('-').append(number.substring(i + 2));
                } else {
                    res.append(number.substring(i));
                }
                break;
            } else {
                res.append(number.substring(i, i + 3)).append('-');
                i += 3;
            }
        }
        return res.toString();
    }
}