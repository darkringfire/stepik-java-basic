package kao.stepik.basic.robot;

public class RobotConnectionManagerGood implements RobotConnectionManager {
    @Override
    public RobotConnection getConnection() {
        return new RobotConnectionOK();
    }
}
