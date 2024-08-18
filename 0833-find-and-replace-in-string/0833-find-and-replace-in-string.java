class Solution {
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        int n = indices.length;
        Pair[] pair = new Pair[n];
        for (int i = 0; i < n; i++) {
            pair[i] = new Pair(indices[i], sources[i], targets[i]);
        }
        Arrays.sort(pair, (a, b) -> a.index - b.index);
        StringBuilder res = new StringBuilder();
        int index = 0;
        int i = 0;
        while (i < s.length() && index < n) {
            if (i == pair[index].index) {
                if (i + pair[index].source.length() <= s.length() && s.substring(i, i + pair[index].source.length()).equals(pair[index].source)) {
                    res.append(pair[index].target);
                    i += pair[index].source.length();
                    index++;
                } else {
                    res.append(s.charAt(i));
                    i++;
                    index++;
                }
            }  else {
                res.append(s.charAt(i));
                i++;
            }
        }
        if (i < s.length()) {
            res.append(s.substring(i));
        }
        return res.toString();
    }
}

class Pair {
    int index;
    String source;
    String target;
    Pair(int index, String source, String target) {
        this.index = index;
        this.source = source;
        this.target = target;
    }
}