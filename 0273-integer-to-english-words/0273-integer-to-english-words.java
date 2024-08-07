class Solution {
    String[] LESS_THAN_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", 
        "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    String[] TENS = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    String[] HUNDREDS = {"", "Thousand", "Million", "Billion"};

    public String numberToWords(int num) {
        String res = "";
        if (num == 0)
            return "Zero";
        int i = 0;
        while (num > 0) {
            int cur = num % 1000;
            res = helper(num % 1000) + HUNDREDS[i] + " " + res;
            num /= 1000;
            i++;
        }
        return res.trim();
    }

    String helper(int num) {
        if (num == 0)
            return "";
        if (num < 20) {
            return LESS_THAN_20[num] + " ";
        } else if (num < 100) {
            return TENS[num / 10] + " " + helper(num % 10);
        } else {
            return LESS_THAN_20[num / 100] + " Hundred " + helper(num % 100);
        }
    }
}