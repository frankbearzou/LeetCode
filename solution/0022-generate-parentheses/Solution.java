class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        generate(new char[n * 2], 0, ans);
        return ans;
    }

    private void generate(char[] arr, int pos, List<String> ans) {
        if (pos == arr.length) {
            if (valid(arr))
                ans.add(new String(arr));
            return;
        }
        arr[pos] = '(';
        generate(arr, pos + 1, ans);
        arr[pos] = ')';
        generate(arr, pos + 1, ans);
    }

    private boolean valid(char[] arr) {
        int balance = 0;
        for (char ch : arr) {
            if (ch == '(')
                balance--;
            else
                balance++;
            if (balance > 0)
                return false;
        }
        return balance == 0;
    }
}
