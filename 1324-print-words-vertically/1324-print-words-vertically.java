class Solution {
    public List<String> printVertically(String s) {
        List<String> list = new ArrayList<>();
        String[] split = s.split(" ");
        int max = 0;
        for (String ss : split) {
            max = Math.max(max, ss.length());
        }
        for (int i = 0; i < max; i++) {
            StringBuilder sb = new StringBuilder();
            for (String ss : split) {
                if (i < ss.length()) {
                    sb.append(ss.charAt(i));
                } else {
                    sb.append(" ");
                }
            }
            while (sb.charAt(sb.length() - 1) == ' ') {
                sb.deleteCharAt(sb.length() - 1);
            }
            list.add(sb.toString());
        }
        return list;
    }
}