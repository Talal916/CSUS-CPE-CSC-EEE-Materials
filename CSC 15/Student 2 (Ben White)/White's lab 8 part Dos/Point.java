/**
 * Point class that creates a point object on the Cartesian's coordinate (4th quadrant)
 * Used in Rectangle class to construct a Rectangle objects 
 */
public class Point {
	// Private fields
	private int x;
	private int y;
	
	/**
	 * This default constructors point to the origin (0, 0)
	 */
	public Point() {
		this.x = 0;
		this.y = 0;
	}
	
	/**
	 * This non-badass constructor constructs the point from X and Y coordinates
	 * @param newx X-coordinate
	 * @param newy Y-coordinate
	 */
	public Point(int newx, int newy) {
		this.x = newx;
		this.y = newy;
	}
	
	//Accessors
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	//Mutators
	public void setX(int newx) {
		x = newx;
	}
	public void setY(int newy) {
		y = newy;
	}
}