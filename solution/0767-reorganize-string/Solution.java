class Solution {
    public String reorganizeString(String S) {
        int[] arr = new int[26];
        
        for (int i = 0; i < S.length(); i++)
            arr[S.charAt(i) - 'a']++;
        
        int max = 0, idx = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
                idx = i;
            }
        }
        
        if (max > (S.length() + 1) / 2)
            return "";
        
        char[] letters = new char[S.length()];
        int j = 0;
        while (arr[idx] > 0) {
            letters[j] = (char)(idx + 'a');
            j += 2;
            arr[idx]--;
        }
        
        for (int i = 0; i < arr.length; i++) {
            while (arr[i] > 0) {
                if (j >= letters.length) {
                    j = 1;
                }
                letters[j] = (char)(i + 'a');
                arr[i]--;
                j += 2;
                
            }
        }
        
        return String.valueOf(letters);
    }
}
