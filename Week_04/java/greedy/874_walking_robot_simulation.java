class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {

        int maxDistance = 0;
        int[][] xy = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int direction = 0;
        int x = 0, y = 0;
        Set<String> obstacleSet = new HashSet<>();

        for(int[] obstacle : obstacles) {
            obstacleSet.add(obstacle[0] + "," + obstacle[1]);
        }

        for(int command : commands) {
            if(command == -1) {
                direction = (direction + 1) % 4;
            } else if( command == -2) {
                direction = (direction + 3) % 4;
            } else {
                for(int i=0; i< command; i++) {
                    int newX =  x + xy[direction][0];
                    int newY =  y + xy[direction][1];

                    if(obstacleSet.contains(newX + "," + newY)){
                        break;
                    } else {
                        x = newX;
                        y = newY;
                        maxDistance = Math.max(maxDistance, x*x + y*y);
                    }
                }
            }
        }
        return maxDistance;
    }

}
