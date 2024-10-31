class Solution {
    List<Integer> robot;
    List<Integer> factory = new ArrayList<>();
    Long[][] cache;

    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        Collections.sort(robot);
        this.robot = robot;
        for (int[] fac : factory) {
            for (int i = 0; i < fac[1]; i++) {
                this.factory.add(fac[0]);
            }
        }
        Collections.sort(this.factory);
        cache = new Long[robot.size()][this.factory.size()];
        return dfs(0, 0);
    }

    long dfs(int robotIndex, int factoryIndex) {
        if (robotIndex == robot.size())
            return 0;
        if (factoryIndex == factory.size())
            return (long)1e12;
        if (cache[robotIndex][factoryIndex] != null)
            return cache[robotIndex][factoryIndex];
        long choose = Math.abs(robot.get(robotIndex) - factory.get(factoryIndex)) + dfs(robotIndex + 1, factoryIndex + 1);
        long skip = dfs(robotIndex, factoryIndex + 1);
        return cache[robotIndex][factoryIndex] = Math.min(choose, skip);
    }
}