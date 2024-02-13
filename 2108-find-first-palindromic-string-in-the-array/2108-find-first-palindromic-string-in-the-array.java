class Solution {
    public String firstPalindrome(String[] words) {
        for (String word : words) {
            if (isPalindrome(word))
                return word;
        }
        return "";
    }

    boolean isPalindrome(String word) {
        char[] arr = word.toCharArray();
        int l = 0, r = arr.length - 1;
        while (l < r) {
            if (arr[l] != arr[r])
                return false;
            l++;
            r--;
        }
        return true;
    }
}