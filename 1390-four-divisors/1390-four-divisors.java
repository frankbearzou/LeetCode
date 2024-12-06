class Solution {
    Map<Integer, Integer> map = new HashMap<>();

    public int sumFourDivisors(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += getSum(num);
        }
        return sum;
    }

    int getSum(int num) {
        if (map.containsKey(num))
            return map.get(num);
        int count = 2;
        int[] arr = new int[3];
        for (int i = 2; i <= num / 2; i++) {
            if (num % i == 0) {
                arr[count - 2] = i;
                count++;
            }
            if (count > 4) {
                count = 0;
                break;
            }
        }
        if (count == 4) {
            map.put(num, 1 + arr[0] + arr[1] + num);
        } else {
            map.put(num, 0);
        }
        return map.get(num);
    }
}