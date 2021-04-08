class Solution{
    public boolean isRobotBounded(String instructions){
        int x = 0, y = 0, d = 0;
        int[][] directions= new int[][]{
                new int[]{1, 0}, new int[]{0, 1}, new int[]{-1, 0}, new int[]{0, -1}
        };

        for(int time=0; time < 4; time++){
            for(char ch: instructions.toCharArray()){
                if(ch == 'L') d = (d + 3) % 4;
                else if(ch == 'R') d = (d + 1) % 4;
                else {
                    x += directions[d][0];
                    y += directions[d][1];
                }
            }

            if(x == 0 && y == 0) return true;
        }

        return false;
    }
}

