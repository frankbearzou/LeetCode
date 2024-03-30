class Solution {
    public String removeTrailingZeros(String num) {
        int r;
        for (r = num.length() - 1; r >= 0; r--) {
            if (num.charAt(r) != '0')
                break;
        }
        return num.substring(0, r + 1);
    }
}