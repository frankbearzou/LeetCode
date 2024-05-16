class Solution {
    public String[] reorderLogFiles(String[] logs) {
        String[] res = new String[logs.length];
        int index = 0;
        List<String> letters = new ArrayList<>();
        List<String> digits = new ArrayList<>();
        for (String log : logs) {
            int i = log.indexOf(" ");
            char c = log.charAt(i + 1);
            if (c >= '0' && c <= '9')
                digits.add(log);
            else
                letters.add(log);
        }
        Collections.sort(letters, (a, b) -> {
            int i = a.indexOf(" ");
            int j = b.indexOf(" ");
            if (a.substring(i + 1).equals(b.substring(j + 1)))
                return a.compareTo(b);
            return a.substring(i + 1).compareTo(b.substring(j + 1));
        });
        for (String l : letters) {
            res[index++] = l;
        }
        for (String d : digits) {
            res[index++] = d;
        }
        return res;
    }
}