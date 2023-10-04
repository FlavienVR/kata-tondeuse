class Tondeuse {

    private int x;
    private int y;
    private char orientation;

    public Tondeuse(int x, int y, char orientation) {
        this.x = x;
        this.y = y;
        this.orientation = orientation;
    }

    public void executeInstructions(String instructions, int maxX, int maxY) {
        for (char instruction : instructions.toCharArray()) {
            if (instruction == 'G')
                turnLeft();
            if (instruction == 'D')
                turnRight();
            if (instruction == 'A')
                moveForward(maxX, maxY);
        }
    }

    private void turnLeft() {
        switch (orientation) {
            case 'N':
                orientation = 'W';
                break;
            case 'E':
                orientation = 'N';
                break;
            case 'S':
                orientation = 'E';
                break;
            case 'W':
                orientation = 'S';
                break;
        }
    }

    private void turnRight() {
        switch (orientation) {
            case 'N':
                orientation = 'E';
                break;
            case 'E':
                orientation = 'S';
                break;
            case 'S':
                orientation = 'W';
                break;
            case 'W':
                orientation = 'N';
                break;
        }
    }

    private void moveForward(int maxX, int maxY) {
        switch (orientation) {
            case 'N':
                if (y < maxY) y++;
                break;
            case 'E':
                if (x < maxX) x++;
                break;
            case 'S':
                if (y > 0) y--;
                break;
            case 'W':
                if (x > 0) x--;
                break;
        }
    }

    public String getPosition() {
        return x + " " + y + " " + orientation;
    }
}
