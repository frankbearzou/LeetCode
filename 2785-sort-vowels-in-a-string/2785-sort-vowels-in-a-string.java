class Solution {
    public String sortVowels(String s) {
        List<Character> vowels = List.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
        List<Character> list = new ArrayList<>();
        StringBuilder res = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (vowels.contains(c))
                list.add(c);
        }
        Collections.sort(list);
        int index = 0;
        for (char c : s.toCharArray()) {
            if (vowels.contains(c)) {
                res.append(list.get(index));
                index++;
            } else {
                res.append(c);
            }
        }
        return res.toString();
    }
}