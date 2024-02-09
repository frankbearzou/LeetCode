class Solution {
    public String predictPartyVictory(String senate) {
        char[] arr = senate.toCharArray();
        int r = 0, d = 0;
        for (char c : arr) {
            if (c == 'R')
                r++;
            else
                d++;
        }
        while (r > 0 && d > 0) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == '0')
                    continue;
                if (arr[i] == 'R') {
                    remove(arr, i, 'D');
                    d--;
                } else if (arr[i] == 'D') {
                    remove(arr, i, 'R');
                    r--;
                }
            }
        }
        if (r > 0)
            return "Radiant";
        else
            return "Dire";
    }

    void remove(char[] arr, int index, char c) {
        for (int i = index + 1; i < arr.length; i++) {
            if (arr[i] == c) {
                arr[i] = '0';
                return;
            }
        }
        for (int i = 0; i < index; i++) {
            if (arr[i] == c) {
                arr[i] = '0';
                return;
            }
        }
    }
}