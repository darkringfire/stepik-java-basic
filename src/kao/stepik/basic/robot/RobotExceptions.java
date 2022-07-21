package kao.stepik.basic.robot;

public class RobotExceptions {
    public static void main(String[] args) {
        RobotConnectionManager[] tests = {
                new RobotConnectionManagerNeverConnect(),
                new RobotConnectionManagerNoise(),
                new RobotConnectionManagerGood(),
                new RobotConnectionManagerNeverMove(),
                new RobotConnectionManagerWentAway(),
        };
        for (RobotConnectionManager rcm: tests) {
            System.out.println("=== Test ===");
            try {
                moveRobot(rcm, 0, 0);
            } catch (RobotConnectionException e) {
                System.out.println(e.getMessage());
            }
        }
    }


    public static void moveRobot(RobotConnectionManager robotConnectionManager, int toX, int toY) {
        int attempt = 0;
        boolean moved = false;
        while (attempt < 3) {
            attempt++;
            try (RobotConnection rc = robotConnectionManager.getConnection()) {
                rc.moveRobotTo(toX, toY);
                moved = true;
                attempt = 3;
            } catch (RobotConnectionException e) {
                System.out.println(e.getMessage());
            }
        }
        if (!moved) {
            throw new RobotConnectionException("Robot is inaccessible");
        }
    }
}
