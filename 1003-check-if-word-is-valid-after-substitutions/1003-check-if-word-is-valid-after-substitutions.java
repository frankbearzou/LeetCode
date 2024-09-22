class Solution {
    public boolean isValid(String s) {
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'c') {
                if (list.size() >= 2 && list.get(list.size() - 1) == 'b' && list.get(list.size() - 2) == 'a') {
                    list.removeLast();
                    list.removeLast();
                } else
                    list.addLast(s.charAt(i));
            } else
                list.addLast(s.charAt(i));
        }
        return list.isEmpty();
    }
}