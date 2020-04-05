import java.util.*;

class Solution {
    public String reverseWords(String s) {
        String[] split = s.split(" ");
        StringJoiner joiner = new StringJoiner(" ");
        for (int i = split.length - 1; i >=0; i--) {
            String trim = split[i].trim();
            if (!trim.isEmpty()) {
                joiner.add(trim);
            }
        }
        return joiner.toString();
    }
}
