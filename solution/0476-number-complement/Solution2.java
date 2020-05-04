class Solution {
    public int findComplement(int num) {
        String bin = Integer.toBinaryString(num);
        String str = "";
        for (char c : bin.toCharArray()) {
            str += c == '1' ? '0' : '1';
        }
        return Integer.valueOf(str, 2);
    }
}
