class Solution {
    public boolean detectCapitalUse(String word) {
        if (word.length() == 1)
            return true;
        if (isCapital(word.charAt(0))) {
            if (isCapital(word.charAt(1))) {
                for (int i = 2; i < word.length(); i++)
                    if (!isCapital(word.charAt(i)))
                        return false;
                return true;
            } else {
                for (int i = 1; i < word.length(); i++)
                    if (isCapital(word.charAt(i)))
                        return false;
                return true;
            }
        } 
        for (int i = 0; i < word.length(); i++)
            if (isCapital(word.charAt(i)))
                return false;
        return true;
    }
    
    private boolean isCapital(char ch) {
        return ch >= 'A' && ch <= 'Z';
    }
}
