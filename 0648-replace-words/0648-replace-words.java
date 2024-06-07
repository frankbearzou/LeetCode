class Solution {
    private Node root = new Node();
    public String replaceWords(List<String> dictionary, String sentence) {
        for (String dic : dictionary) {
            Node cur = root;
            for (char c : dic.toCharArray()) {
                cur.map.putIfAbsent(c, new Node());
                cur = cur.map.get(c);
            }
            cur.end = true;
        }
        List<String> list = new ArrayList<>();
        String[] split = sentence.split(" ");
        for (String s : split) {
            Node cur = root;
            String str = "";
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (!cur.map.containsKey(c))
                    break;
                str += c;
                cur = cur.map.get(c);
                if (cur.end)
                    break;
            }
            if (cur.end) {
                list.add(str);
            } else {
                list.add(s);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (String s : list) {
            sb.append(s).append(" ");
        }
        return sb.toString().trim();
    }
}

class Node {
    Map<Character, Node> map = new HashMap<>();
    boolean end;
}