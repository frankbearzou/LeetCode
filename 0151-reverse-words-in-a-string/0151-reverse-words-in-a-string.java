class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        String[] split = s.trim().split(" ");
        for (int i = split.length - 1; i >= 0; i--) {
            if (split[i].length() == 0)
                continue;
            sb.append(split[i]).append(" ");
        }
        return sb.toString().trim();
    }
}