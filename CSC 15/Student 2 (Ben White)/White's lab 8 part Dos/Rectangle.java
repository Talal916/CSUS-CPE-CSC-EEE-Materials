/**
 * Rectangle class that creates rectangles with the help of Point class
 * Also contains methods for various tests.
 */
public class Rectangle {
	// Private fields
	private Point topLeft;
	private int width;
	private int height;
	
	/**
	 * This constructor creates the Rectangle object using a pair of X and Y-coordinate and width, height 
	 * @param newx the X-coordinate
	 * @param newy the X-coordinate
	 * @param width the width of the Rectangle
	 * @param height the height of the Rectangle
	 */
	public Rectangle(int newx, int newy, int width, int height) {
		this.topLeft = new Point(newx, newy);
		this.width = width;
		this.height = height;
	}
	
	/**
	 * This badass constructor creates the Rectangle object using a Point object and width, height
	 * @param topLeft
	 * @param width the width of the Rectangle
	 * @param height the height of the Rectangle
	 */
	public Rectangle(Point topLeft, int width, int height) {
		this.topLeft = new Point(topLeft.getX(), topLeft.getY());
		this.width = width;
		this.height = height;
	}
	
	//Accessors for Rectangle
	public int getHeight() {
		return height;
	}
	public int getWidth() {
		return width;
	}
	//Mutators for Rectangle
	public void setHeight(int newHeight) {
		height = newHeight;
	}
	public void setWidth(int newWidth) {
		width = newWidth;
	}
	
	//Accessors for topLeft
	public int getX() {
		return topLeft.getX();
	}
	public int getY() {
		return topLeft.getY();
	}
	//Mutators for topLeft
	public void setX(int newx) {
		topLeft.setX(newx);
	}
	public void setY(int newy) {
		topLeft.setY(newy);
	}
	
	/**
	 * This method tests to see if a point is contained in a rectangle object
	 * @param x the X-coordinate of the point
	 * @param y the Y-coordinate of the point
	 * @return if the point is in the rectangle or not
	 */
	public boolean contains(int x, int y) {
		return (this.topLeft.getX() <= x && this.topLeft.getY() <= y);
	}
	
	/**
	 * This badass method tests to see if a point is contained in a rectangle object
	 * @param point the point object to be tested
	 * @return if the point is in the rectangle or not
	 */
	public boolean contains(Point point) {
		return(this.topLeft.getX() <= point.getX() && this.topLeft.getY() <= point.getY());
	}
	
	/**
	 * This method constructs a Rectangle object that contains two rectangles 
	 * @param rect the other rectangle
	 * @return a big Rectangle object that contains the passed in two rectangles 
	 */
	public Rectangle union(Rectangle rect) {
		int unix = Math.min(this.getX(), rect.getX());		// get the X-coordinate
		int uniy = Math.min(this.getY(), rect.getY());		// get the Y-coordinate
		
		int uniwidth = Math.max(this.getX() + this.width, rect.getX() + rect.width) - unix;		//calculate width
		int uniheight = Math.max(this.getY() + this.height, rect.getY() + rect.height) - uniy;;	//calculate length
		
		Rectangle uni = new Rectangle(unix, uniy, uniwidth, uniheight);		//super-badass constructing
		
		return uni;
	}
	
	/**
	 * This method allows the printing of the objects into String form
	 * @return the formatted String 
	 */
	public String toString() {
		return String.format("Rectangle[X = %d, Y = %d, width = %d, height = %d]", getX(), getY(), width, height);
	}
}