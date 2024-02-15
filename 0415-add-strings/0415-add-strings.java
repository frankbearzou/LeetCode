class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder ans = new StringBuilder();
        boolean carry = false;
        int i = num1.length() - 1, j = num2.length() - 1;
        while (i >= 0 && j >= 0) {
            int a = num1.charAt(i) - '0';
            int b = num2.charAt(j) - '0';
            int sum = a + b + (carry ? 1 : 0);
            carry = sum >= 10;
            int c = sum % 10;
            ans.insert(0, c);
            i--;
            j--;
        }
        while (i >= 0) {
            int a = num1.charAt(i) - '0';
            int sum = a + (carry ? 1 : 0);
            carry = sum >= 10;
            int c = sum % 10;
            ans.insert(0, c);
            i--;
        }
        while (j >= 0) {
            int b = num2.charAt(j) - '0';
            int sum = b + (carry ? 1 : 0);
            carry = sum >= 10;
            int c = sum % 10;
            ans.insert(0, c);
            j--;
        }
        if (carry) {
            ans.insert(0, 1);
        }
        return ans.toString();
    }
}