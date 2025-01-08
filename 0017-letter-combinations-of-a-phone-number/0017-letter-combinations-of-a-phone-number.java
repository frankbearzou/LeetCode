class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits == null || digits.length() == 0)
            return ans;
        String str = "";
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        backtracking(digits, 0, map, str, ans);
        return ans;
    }
    
    void backtracking(String digits, int start, Map<Character, String> map, String str, List<String> ans) {
        if (str.length() == digits.length()) {
            ans.add(str);
            return;
        }
        for (int i = start; i < digits.length(); i++) {
            char digit = digits.charAt(i);
            String cur = map.get(digit);
            for (char c : cur.toCharArray()) {
                backtracking(digits, i + 1, map, str + c, ans);
            }
        }
    }
}