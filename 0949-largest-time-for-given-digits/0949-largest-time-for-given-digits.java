class Solution {
    List<Integer> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public String largestTimeFromDigits(int[] arr) {
        backtracking(arr);
        if (res.isEmpty())
            return "";
        List<Integer> validList = new ArrayList<>();
        for (int i : res) {
            if (isValid(i)) {
                validList.add(i);
            }
        }
        if (validList.isEmpty())
            return "";
        Collections.sort(validList);
        int i = validList.getLast();

        String res = "";

        int h = i / 100;
        if (h >= 10)
            res = h + ":";
        else if (h > 0 && h < 10)
            res = "0" + h + ":";
        else if (h == 0)
            res = "00:";

        int m = i % 100;
        if (m >= 10)
            res += m;
        else if (m > 0 && m < 10)
            res += "0" + m;
        else if (m == 0)
            res += "00";

        return res;
    }

    void backtracking(int[] arr) {
        if (path.size() == 4) {
            int a = 0; 
            for (int i : path) {
                a = a * 10 + arr[i];
            }
            res.add(a);
            return;
        }
        for (int i = 0; i < 4; i++) {
            if (path.contains(i))
                continue;
            path.add(i);
            backtracking(arr);
            path.removeLast();
        }
    }

    boolean isValid(int time) {
        if (time / 100 > 23)
            return false;
        if (time % 100 > 59)
            return false;
        return true;
    }
}