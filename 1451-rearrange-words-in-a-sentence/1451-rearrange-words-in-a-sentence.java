class Solution {
    public String arrangeWords(String text) {
        Map<Integer, List<String>> map = new TreeMap<>();
        String[] split = text.split(" ");
        for (int i = 0; i < split.length; i++) {
            if (i == 0) {
                split[0] = split[0].toLowerCase();
            }
            map.putIfAbsent(split[i].length(), new ArrayList());
            map.get(split[i].length()).add(split[i]);
        }
        StringBuilder res = new StringBuilder();
        boolean isFirst = true;
        for (List<String> values : map.values()) {
            for (String v : values) {
                if (isFirst) {
                    res.append(Character.toUpperCase(v.charAt(0)));
                    if (v.length() > 1) {
                        res.append(v.substring(1));
                    }
                    res.append(" ");
                    isFirst = false;
                } else {
                    res.append(v).append(" ");
                }
            }
        }
        return res.toString().trim();
    }
}