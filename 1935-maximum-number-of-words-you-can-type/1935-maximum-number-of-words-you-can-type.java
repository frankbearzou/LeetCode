class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        int res = 0;
        Set<Character> set = new HashSet<>();
        for (char c : brokenLetters.toCharArray())
            set.add(c);
        String[] split = text.split(" ");
        for (String str : split) {
            boolean ok = true;
            for (char c : str.toCharArray()) {
                if (set.contains(c)) {
                    ok = false;
                    continue;
                }
            }
            if (ok)
                res++;
        }
        return res;
    }
}