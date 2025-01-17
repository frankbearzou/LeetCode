class Solution {
    String[] list = {"00", "11", "22", "33", "44", "55", "66", "77", "88", "99", "aa", "bb", "cc", "dd", "ee", "ff"};

    public String similarRGB(String color) {
        String ans = "#";
        for (int i = 1; i < 6; i += 2) {
            String s = color.substring(i, i + 2);
            int val = Integer.parseInt(s, 16);
            int min = Integer.MAX_VALUE;
            String res = "";
            for (String li : list) {
                int diff = Math.abs(Integer.parseInt(li, 16) - val);
                if (diff < min) {
                    min = diff;
                    res = li;
                }
            }
            ans += res;
        }
        return ans;
    }
}