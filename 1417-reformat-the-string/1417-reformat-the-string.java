class Solution {
    public String reformat(String s) {
        List<Character> letter = new ArrayList<>();
        List<Character> digit = new ArrayList<>();
        for (char c : s.toCharArray()) {
            if (c >= '0' && c <= '9')
                digit.add(c);
            else
                letter.add(c);
        }
        if (Math.abs(letter.size() - digit.size()) > 1)
            return "";
        List<Character> big, small;
        if (letter.size() > digit.size()) {
            big = letter;
            small = digit;
        } else {
            big = digit;
            small = letter;
        }
        StringBuilder res = new StringBuilder();
        int i = 0, j = 0;
        if (big.size() != small.size()) {
            res.append(big.get(i));
            i++;
        }
        while (i < big.size() && j < small.size()) {
            if (j < small.size()) {
                res.append(small.get(j));
                j++;
            }
            if (i < big.size()) {
                res.append(big.get(i));
                i++;
            }
        }
        return res.toString();
    }
}