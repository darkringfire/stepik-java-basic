package kao.stepik.base.robot;

public class RobotConnectionManagerNoise implements RobotConnectionManager {
    static int cmCounter = 0;

    @Override
    public RobotConnection getConnection() {
        cmCounter++;
        if (cmCounter == 1) {
            return new RobotConnectionNeverMove();
        } else if (cmCounter == 2) {
            throw new RobotConnectionException("Can't get connection");
        } else if (cmCounter == 3) {
            return new RobotConnectionOK();
        }
        throw new RobotConnectionException("Can't get connection");
    }
}
