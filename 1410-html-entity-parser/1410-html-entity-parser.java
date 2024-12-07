class Solution {
    public String entityParser(String text) {
        int n = text.length();
        StringBuilder str = new StringBuilder();
        Map<String, String> map = new HashMap<>();
        map.put("&quot;", "\"");
        map.put("&apos;", "'");
        map.put("&amp;", "&");
        map.put("&gt;", ">");
        map.put("&lt;", "<");
        map.put("&frasl;", "/");
        int i = 0;
        while (i < n) {
            char c = text.charAt(i);
            if (c == '&') {
                int j = i + 1;
                while (j < n && text.charAt(j) != ';')
                    j++;
                if (j == n) {
                    str.append(text.substring(i));
                    break;
                } else {
                    String s = text.substring(i, j + 1);
                    String val = map.get(s);
                    if (val == null) {
                        str.append(s);
                    } else {
                        str.append(val);
                    }
                    i = j + 1;
                }
            } else {
                str.append(c);
                i++;
            }
        }
        return str.toString();
    }
}