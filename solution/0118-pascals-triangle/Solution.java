class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        
        for (int i = 0; i < numRows; i++) {
            Integer[] row = new Integer[i + 1];
            row[0] = 1;
            row[row.length - 1] = 1;
            for (int j = 1; j < row.length - 1; j++) {
                row[j] = result.get(i - 1).get(j - 1) + result.get(i - 1).get(j);
            }
            result.add(Arrays.asList(row));
        }
        
        return result;
    }
}
