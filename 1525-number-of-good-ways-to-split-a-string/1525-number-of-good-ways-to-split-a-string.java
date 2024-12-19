class Solution {
    public int numSplits(String s) {
        int count = 0;
        for (int i = 1; i < s.length(); i++) {
            String p = s.substring(0, i);
            String q = s.substring(i);
            if (count(p) == count(q))
                count++;
        }
        return count;
    }
    
    private int count(String str) {
        int[] arr = new int[26];
        int count = 0;
        
        for (int i = 0; i < str.length(); i++) {
            int index = str.charAt(i) - 'a';
            if (arr[index] == 0)
                count++;
            arr[index]++;
        }
        
        return count;
    }
}