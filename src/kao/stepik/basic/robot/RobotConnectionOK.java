package kao.stepik.basic.robot;

public class RobotConnectionOK implements RobotConnection {
    @Override
    public void moveRobotTo(int x, int y) {
        System.out.println("Im here!");
    }

    @Override
    public void close() {
        System.out.println("Connection closed");
    }
}
