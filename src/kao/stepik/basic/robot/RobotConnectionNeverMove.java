package kao.stepik.basic.robot;

public class RobotConnectionNeverMove implements RobotConnection {
    @Override
    public void moveRobotTo(int x, int y) {
        throw new RobotConnectionException("I can't move");
    }

    @Override
    public void close() {
        throw new RobotConnectionException("Cant close connection");
    }
}
