package _05_Snake;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import org.junit.experimental.theories.FromDataPoints;

public class Snake {
	public static final Color SNAKE_COLOR = Color.BLUE;
	public static final int BODY_SIZE = 50;

	private SnakeSegment head;
	private ArrayList<SnakeSegment> snake;
	Location loadingSegment;
	Location SnakeLocation;
	private Direction currentDirection;

	private boolean canMove = true;

	public Snake(Location location) {
		snake = new ArrayList<SnakeSegment>();
		head = new SnakeSegment(location, BODY_SIZE);
		snake.add(head);
		currentDirection = Direction.RIGHT;
	}

	public void feed() {
		snake.add(new SnakeSegment(snake.get(0).getLocation(), BODY_SIZE));
	}

	public Location getHeadLocation() {
		return head.getLocation();
	}

	public void update() {
		/*
		 * Use a switch statement to check on the currentDirection of the snake and
		 * calculate the head's next x and y position. Depending on the direction, the
		 * head's x or y will increase or decrease by 1.
		 */
		Location loc = null;
		int nextX;
		int nextY;
		switch (currentDirection) {
		//fix this
		case RIGHT:
			loc = new Location(head.getLocation().getX() + 1, head.getLocation().getY());
			break;
		case LEFT:
			loc = new Location(head.getLocation().getX() - 1, head.getLocation().getY());
			break;
		case UP:
			loc = new Location(head.getLocation().getX(), head.getLocation().getY() - 1);
			break;
		case DOWN:
			loc = new Location(head.getLocation().getX(), head.getLocation().getY() + 1);
			break;
		}

		/*
		 * Change the Location of each SnakeSegment in your snake ArrayList to the
		 * Location of the segment in front of it.
		 * 
		 * Use a loop starting at the end of the ArrayList and stop before the head of
		 * the snake (index 0) or you will go out of bounds.
		 */
		for (int m = snake.size() - 1; m > 0; m--) {
			loadingSegment = snake.get(m - 1).getLocation();
			snake.get(m).setLocation(loadingSegment);
		}
		head.setLocation(loc);
		/*
		 * Create a new Location object and initialize it with the values calculated in
		 * step 1. Then set the head's location equal to the new location.
		 */

		// Set the canMove member variable to true.

		canMove = true;

	}

	public void setDirection(Direction direction) {

		/*
		 * Set the currentDirection member variable to the passed in direction and
		 * canMove to false if the passed in direction is not the opposite direction and
		 * canMove is true.
		 * 
		 * Hint: Use the isOppositeDirection method to check if Direction d is opposite.
		 */

		if (!isOppositeDirection(direction) && canMove == true) {
			canMove = false;
			currentDirection = direction;
		}

	}

	private boolean isOppositeDirection(Direction direction) {

		/*
		 * Complete the method so it returns true if the passed in Direction is the
		 * opposite value of the currentDirection member variable.
		 * 
		 * Otherwise, return false. For example, if currentDirection is UP and the
		 * passed in direction is DOWN this method should return false.
		 */
		if (direction == Direction.UP && currentDirection == Direction.DOWN) {
			//System.out.println(" DO UP");
			return true;
		} else if (direction == Direction.DOWN && currentDirection == Direction.UP) {
			//System.out.println(" DO DOWN");
			return true;
		} else if (direction == Direction.RIGHT && currentDirection == Direction.LEFT) {
			//System.out.println(" DO RIGHT");
			return true;
		} else if (direction == Direction.LEFT && currentDirection == Direction.RIGHT) {
			//System.out.println(" DO LEFT");
			return true;
		}else {
			return false;
		}
	}

	public void resetLocation() {

		// Clear the snake.

		snake.clear();

		/*
		 * Create a new Location object for the head at SnakeGame.WIDTH / 2,
		 * SnakeGame.HEIGHT / 2.
		 */
		SnakeLocation = head.getLocation();
		SnakeLocation.setX(SnakeGame.WIDTH / 2);
		SnakeLocation.setX(SnakeGame.HEIGHT / 2);

		/*
		 * Set the head member variable equal to a new SnakeSegment object. Use the
		 * Location created in step 2 for the Location and the BODY_SIZE constant for
		 * the size.
		 */

		head = new SnakeSegment(SnakeLocation, BODY_SIZE);

		// Add the head to the snake.

		snake.add(head);

	}

	public boolean isOutOfBounds() {
//the bounds are not fixed
		/*
		 * Complete the method so it returns true if the head of the snake is outside of
		 * the window and false otherwise.
		 */
		if (head.getLocation().getX() > SnakeGame.WIDTH) {
			return true;
		} else if (head.getLocation().getY() > SnakeGame.HEIGHT) {
			return true;
		} else if (head.getLocation().getX() < 0) {
			return true;
		} else if (head.getLocation().getY() < 0) {
			return true;
		} else {
			return false;
		}

	}

	public boolean isHeadCollidingWithBody() {

		/*
		 * Complete the method so it returns true if the head is located in the same
		 * location as any other body segment.
		 */

		for (int i = 1; i < snake.size(); i++) {
			if (head.getLocation().getX() == snake.get(i).getLocation().getX() && head.getLocation().getY() == snake.get(i).getLocation().getY()) {
				System.out.println("head collision with body");
				return true;
			}
		}
		return false;
	}

	public boolean isLocationOnSnake(Location loc) {

		/*
		 * Complete the method so it returns true if the passed in location is located
		 * on the snake.
		 */
		for (int i = 0; i < snake.size(); i++) {
			if (loc == snake.get(i).getLocation()) {
				return true;
			}
		}
		return false;
	}

	public void draw(Graphics g) {
		for (SnakeSegment s : snake) {
			s.draw(g);
		}
	}
}
