/*
 * @lc app=leetcode id=2069 lang=java
 *
 * [2069] Walking Robot Simulation II
 */

// @lc code=start
class Robot {
    int steps = 0;
    int width, height;
    int perimeter;
    String[] dir = {"East", "North", "West", "South" };
    boolean hasMoved = false;

    public Robot(int width, int height) {
        this.width = width;
        this.height = height;
        perimeter = 2 * (height + width - 2);
    }
    
    public void step(int num) {
        if (perimeter == 0) return;
        
        hasMoved = true; 

        steps = (steps + num) % perimeter;
    }
    
    public int[] getPos() {
        if (perimeter == 0) return new int[] {0, 0};
        int temp = steps;

        if (temp < width - 1) return new int[] {temp, 0};

        temp -= (width - 1);
        if (temp < height - 1) return new int[] {width - 1, temp};

        temp -= (height - 1);
        if (temp < width - 1) return new int[] {width - 1 - temp, height - 1};

        temp -= (width - 1);
        return new int[] {0, height - 1 - temp};
    }
    
    public String getDir() {
        if (steps == 0) {
            if (hasMoved) return dir[3];
            else return dir[0];
        }
        
        if (perimeter == 0) return dir[0];
        int temp = steps;

        if (temp < width) return dir[0];

        temp -= (width - 1);
        if (temp < height) return dir[1];

        temp -= (height - 1);
        if (temp < width) return dir[2];

        return dir[3];
    }
}

/**
 * Your Robot object will be instantiated and called as such:
 * Robot obj = new Robot(width, height);
 * obj.step(num);
 * int[] param_2 = obj.getPos();
 * String param_3 = obj.getDir();
 */
// @lc code=end

