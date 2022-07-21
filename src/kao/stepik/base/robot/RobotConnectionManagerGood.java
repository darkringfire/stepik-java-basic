package kao.stepik.base.robot;

public class RobotConnectionManagerGood implements RobotConnectionManager {
    @Override
    public RobotConnection getConnection() {
        return new RobotConnectionOK();
    }
}
