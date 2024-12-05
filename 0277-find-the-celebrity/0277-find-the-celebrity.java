/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
        List<List<Integer>> adj = new ArrayList<>();
        int[] inDegree = new int[n];
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j)
                    continue;
                if (knows(i, j)) {
                    adj.get(i).add(j);
                    inDegree[j]++;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == n - 1 && adj.get(i).size() == 0)
                return i;
        }
        return -1;
    }
}