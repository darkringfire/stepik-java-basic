package kao.stepik.base.robot;

public class RobotConnectionManagerWentAway implements RobotConnectionManager {
    @Override
    public RobotConnection getConnection() {
        return new RobotConnectionOkNoClose();
    }
}
