class Solution {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        int root = findRoot(n, leftChild, rightChild);
        if (root == -1)
            return false;
        Queue<Integer> queue = new ArrayDeque<>();
        Set<Integer> visited = new HashSet<>();
        queue.add(root);
        visited.add(root);
        while (!queue.isEmpty()) {
            int node = queue.remove();
            int l = leftChild[node];
            int r = rightChild[node];
            if (l != -1) {
                if (visited.contains(l))
                    return false;
                queue.add(l);
                visited.add(l);
            }
            if (r != -1) {
                if (visited.contains(r))
                    return false;
                queue.add(r);
                visited.add(r);
            }
        }
        return visited.size() == n;
    }

    int findRoot(int n, int[] leftChild, int[] rightChild) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < leftChild.length; i++) {
            set.add(leftChild[i]);
            set.add(rightChild[i]);
        }
        for (int i = 0; i < n; i++) {
            if (!set.contains(i))
                return i;
        }
        return -1;
    }
}