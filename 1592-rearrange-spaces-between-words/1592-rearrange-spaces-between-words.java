class Solution {
    public String reorderSpaces(String text) {
        int spaces = 0, remainder = 0;
        List<String> list = new ArrayList<>();
        StringBuilder str = new StringBuilder();
        for (char c : text.toCharArray()) {
            if (c == ' ') {
                spaces++;
                if (str.length() > 0) {
                    list.add(str.toString());
                    str = new StringBuilder();
                }
            } else {
                str.append(c);
            }
        }
        if (str.length() > 0) {
            list.add(str.toString());
        }
        int space = list.size() == 1 ? spaces : spaces / (list.size() - 1);
        remainder = list.size() == 1 ? spaces : spaces % (list.size() - 1);
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            res.append(list.get(i));
            if (i != list.size() - 1) {
                for (int j = 0; j < space; j++) {
                    res.append(' ');
                }
            }
        }
        for (int i = 0; i < remainder; i++) {
            res.append(' ');
        }
        return res.toString();
    }
}