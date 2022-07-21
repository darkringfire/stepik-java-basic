package kao.stepik.base.robot;

public class RobotConnectionManagerNeverConnect implements RobotConnectionManager {
    static int cmCounter = 0;

    @Override
    public RobotConnection getConnection() {
        throw new RobotConnectionException("Can't get connection");
    }
}
