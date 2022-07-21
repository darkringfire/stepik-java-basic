package kao.stepik.base.robot;

public class RobotConnectionManagerNeverMove implements RobotConnectionManager {
    @Override
    public RobotConnection getConnection() {
        return new RobotConnectionNeverMove();
    }
}
