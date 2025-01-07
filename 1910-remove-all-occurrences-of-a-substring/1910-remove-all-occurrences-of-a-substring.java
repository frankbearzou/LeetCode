class Solution {
    public String removeOccurrences(String s, String part) {
        int index = -1;
        while ((index = s.indexOf(part)) != -1) {
            String first = s.substring(0, index);
            int j = index + part.length();
            if (j < s.length()) {
                s = first + s.substring(j);
            } else {
                s = first;
            }
        }
        return s;
    }
}