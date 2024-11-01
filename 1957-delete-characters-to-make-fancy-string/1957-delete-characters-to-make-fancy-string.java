class Solution {
    public String makeFancyString(String s) {
        StringBuilder str = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (str.length() >= 2 && str.charAt(str.length() - 2) == c && str.charAt(str.length() - 1) == c)
                continue;
            str.append(c);
        }
        return str.toString();
    }
}