package kao.stepik.basic.robot;

public class RobotConnectionManagerNeverMove implements RobotConnectionManager {
    @Override
    public RobotConnection getConnection() {
        return new RobotConnectionNeverMove();
    }
}
