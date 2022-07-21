package kao.stepik.basic.robot;

public class RobotMover {

	public static void main(String[] args) {
		moveRobot(new Robot(Direction.LEFT, 0, 0), 1, 1);

	}
	
	public static void moveRobot(Robot robot, int toX, int toY) {
	    if (toX > robot.getX()) {
	    	if (robot.getDirection() == Direction.UP) {
	    		robot.turnRight();
	    	} else if (robot.getDirection() == Direction.LEFT) {
				robot.turnLeft();
			}
	    	if (robot.getDirection() == Direction.DOWN) {
	    		robot.turnLeft();
	    	}
	    } else if (toX < robot.getX()) {
	    	if (robot.getDirection() == Direction.UP) {
	    		robot.turnLeft();
	    	} else if (robot.getDirection() == Direction.RIGHT) {
				robot.turnRight();
			}
	    	if (robot.getDirection() == Direction.DOWN) {
	    		robot.turnRight();
	    	}
		}
	    while (robot.getX() != toX) {
			robot.stepForward();
		}
	    if (toY > robot.getY()) {
	    	while (robot.getDirection() != Direction.UP) {
				robot.turnRight();
			}
	    } else if (toY < robot.getY()) {
			while (robot.getDirection() != Direction.DOWN) {
				robot.turnRight();
			}
		}
	    while (robot.getY() != toY) {
			robot.stepForward();
		}
	    
	}


}

class Robot {
	private Direction direction;
	private int x;
	private int y;
	
	public Robot(Direction direction, int x, int y) {
		this.direction = direction;
		this.x = x;
		this.y = y;
	}
	
	public Direction getDirection() {
		return direction;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void turnLeft() {
		if (direction == Direction.UP) {
			direction = Direction.LEFT;
		} else if (direction == Direction.LEFT) {
			direction = Direction.DOWN;
		} else if (direction == Direction.DOWN) {
			direction = Direction.RIGHT;
		} else {
			direction = Direction.UP;
		}
		System.out.println("Turn left - " + direction.name());
	}

	public void turnRight() {
		if (direction == Direction.UP) {
			direction = Direction.RIGHT;
		} else if (direction == Direction.RIGHT) {
			direction = Direction.DOWN;
		} else if (direction == Direction.DOWN) {
			direction = Direction.LEFT;
		} else {
			direction = Direction.UP;
		}
		System.out.println("Turn right - " + direction.name());
	}

	public void stepForward() {
		if (direction == Direction.UP) {
			y++;
		} else if (direction == Direction.RIGHT) {
			x++;
		} else if (direction == Direction.DOWN) {
			y--;
		} else {
			x--;
		}
		System.out.println(x + "," + y);
	}
}

enum Direction {
	UP, 
	DOWN, 
	LEFT, 
	RIGHT,
}
