package kao.stepik.base.robot;

public class RobotConnectionOkNoClose implements RobotConnection {
    @Override
    public void moveRobotTo(int x, int y) {
        System.out.println("Im here, but Im tired");
    }

    @Override
    public void close() {
        throw new RobotConnectionException("Robot went away");
    }
}
