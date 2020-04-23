class Solution {
    public boolean wordPattern(String pattern, String str) {
        String[] split = str.split(" ");
        if (pattern.length() != split.length)
            return false;

        HashMap<Character, String> PatStr = new HashMap<>();
        HashMap<String, Character> StrPat = new HashMap<>();

        for (int i = 0; i < split.length; i++) {
            if (PatStr.containsKey(pattern.charAt(i))) {
                if (!PatStr.get(pattern.charAt(i)).equals(split[i])) {
                    return false;
                }
            } else if (StrPat.containsKey(split[i])) {
                if (StrPat.get(split[i]) != pattern.charAt(i)) {
                    return false;
                }
            } else {
                PatStr.put(pattern.charAt(i), split[i]);
                StrPat.put(split[i], pattern.charAt(i));
            }
        }

        return true;
    }
}
