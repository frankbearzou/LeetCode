class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        List<Robot> list = new ArrayList<>();
        int n = positions.length;
        for (int i = 0; i < n; i++) {
            list.add(new Robot(positions[i], healths[i], directions.charAt(i), i));
        }
        Collections.sort(list, (a, b) -> a.position - b.position);
        List<Robot> stack = new ArrayList<>();
        for (Robot robot : list) {
            if (stack.isEmpty() || robot.direction == 'R') {
                stack.add(robot);
                continue;
            }
            boolean gone = false;
            while (!stack.isEmpty() && stack.getLast().direction == 'R' && robot.direction == 'L' && stack.getLast().health <= robot.health) {
                if (stack.getLast().health == robot.health) {
                    stack.removeLast();
                    gone = true;
                    break;
                }
                stack.removeLast();
                robot.health--;
            }
            if (gone)
                continue;
            if (!stack.isEmpty() && stack.getLast().direction == 'R' && stack.getLast().health > robot.health) {
                stack.getLast().health--;
                continue;
            }
            stack.add(robot);
        }
        Collections.sort(stack, (a, b) -> a.no - b.no);
        List<Integer> res = new ArrayList<>();
        for (Robot robot : stack) {
            res.add(robot.health);
        }
        return res;
    }
}

class Robot {
    int position;
    int health;
    char direction;
    int no;
    Robot(int position, int health, char direction, int no) {
        this.position = position;
        this.health = health;
        this.direction = direction;
        this.no = no;
    }
}