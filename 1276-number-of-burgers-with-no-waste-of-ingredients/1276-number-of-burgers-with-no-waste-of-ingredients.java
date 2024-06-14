class Solution {
    public List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
        for (int i = 0; i <= cheeseSlices; i++) {
            int tomato = 4 * i + 2 * (cheeseSlices - i);
            if (tomato == tomatoSlices)
                return List.of(i, cheeseSlices - i);
        }
        return List.of();
    }
}