class Solution {
    public int findComplement(int num) {
        StringBuilder sb = new StringBuilder();
        String s = Integer.toBinaryString(num);
        for (char c : s.toCharArray())
            sb.append(c == '1' ? '0' : '1');
        return Integer.valueOf(sb.toString(), 2);
    }
}
