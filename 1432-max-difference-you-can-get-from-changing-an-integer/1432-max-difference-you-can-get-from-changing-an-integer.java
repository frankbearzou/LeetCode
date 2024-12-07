class Solution {
    public int maxDiff(int num) {
        String aStr = Integer.toString(num);
        char target = 0;
        for (int i = 0; i < aStr.length(); i++) {
            char c = aStr.charAt(i);
            if (target == 0 && c < '9') {
                target = c;
                break;
            }
        }
        aStr = aStr.replaceAll("" + target, "9");
        int a = Integer.parseInt(aStr);
        
        target = 0;
        String bStr = Integer.toString(num);
        for (int i = 0; i < bStr.length(); i++) {
            char c = bStr.charAt(i);
            if (i == 0 && c > '1') {
                bStr = bStr.replaceAll("" + c, "1");
                break;
            }
            if (c == '1' || c == '0')
                continue;
            bStr = bStr.replaceAll("" + c, "0");
            break;
        }
        int b = Integer.parseInt(bStr.toString());
        return a - b;
    }
}