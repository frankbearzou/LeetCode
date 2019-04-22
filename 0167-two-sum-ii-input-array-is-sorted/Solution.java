class Solution {
    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>(numbers.length * 2);
        
        for (int i = 0; i < numbers.length; i++) {
            int compliment = target - numbers[i];
            if (map.containsKey(compliment)) {
                return new int[] {map.get(compliment), i + 1};
            } else {
                map.put(numbers[i], i + 1);
            }
        }
        
        return new int[] {0, 0};
    }
}
