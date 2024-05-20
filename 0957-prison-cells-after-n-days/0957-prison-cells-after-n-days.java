class Solution {
    public int[] prisonAfterNDays(int[] cells, int n) {
        int[] arr = new int[8];
        Set<String> set = new HashSet<>();
        boolean cycle = false;
        int step = 0;
        for (int i = 0; i < n; i++) {
            arr = nextDay(cells);
            String s = Arrays.toString(arr);
            if (set.contains(s)) {
                cycle = true;
                break;
            }
            cells = arr;
            step++;
            set.add(s);
        }
        if (cycle) {
            n = n % step;
            for (int i = 0; i < n; i++) {
                arr = nextDay(cells);
                cells = arr;
            }
        }
        return cells;
    }

    int[] nextDay(int[] cells) {
        int[] arr = new int[8];
        for (int i = 1; i < 7; i++) {
            arr[i] = cells[i - 1] == cells[i + 1] ? 1 : 0;
        }
        return arr;
    }
}