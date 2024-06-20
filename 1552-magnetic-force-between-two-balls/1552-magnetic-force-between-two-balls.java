class Solution {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int left = 1;
        int right = position[position.length - 1] - position[0];
        int res = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canPlace(position, m, mid)) {
                res = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return res;
    }

    boolean canPlace(int[] position, int m, int force) {
        int count = 1;
        int last = position[0];
        for (int i = 1; i < position.length; i++) {
            if (position[i] - last >= force) {
                count++;
                last = position[i];
                if (count >= m)
                    return true;
            }
        }
        return false;
    }
}