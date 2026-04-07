class Robot {
    private int width, height;
    private int x, y, dir;
    private int perimeter;
    private int steps;
    public Robot(int width, int height) {
        this.width = width;
        this.height = height;
        this.x = 0;
        this.y = 0;
        this.dir = 0;
        this.perimeter = 2 * (width + height) - 4;
        this.steps = 0;
    }
    public void step(int num) {
        steps = (steps + num) % perimeter;
        if (steps == 0) {
            x = 0;
            y = 0;
            dir = 3;
            return;
        }
        int s = steps;
        if (s < width) {
            x = s;
            y = 0;
            dir = 0;
        } else if (s < width + height - 1) {
            x = width - 1;
            y = s - (width - 1);
            dir = 1;
        } else if (s < 2 * width + height - 2) {
            x = width - 1 - (s - (width + height - 2));
            y = height - 1;
            dir = 2;
        } else {
            x = 0;
            y = height - 1 - (s - (2 * width + height - 3));
            dir = 3;
        }
    }
    public int[] getPos() {
        return new int[]{x, y};
    }
    public String getDir() {
        if (dir == 0) return "East";
        if (dir == 1) return "North";
        if (dir == 2) return "West";
        return "South";
    }
}