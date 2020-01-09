/**
 * CSC 15
 * Prof. White
 * @author Bleh
 * Program Description: This program runs several tests for objects from two classes 
 */
public class RectangleDriver {

	public static void main(String[] args) {
		runTests();
	}
	
	// Warning: massive wall of text
	public static void runTests() {
		System.out.println("Testing constructor: ");		// constructing rectangles
		System.out.println("Rectangle a1 = new Rectangle(5, 12, 4, 6);");
		Rectangle a1 = new Rectangle(5, 12, 4, 6);
		System.out.println("Rectangle a2 = new Rectangle(6, 8, 5, 7);");
		Rectangle a2 = new Rectangle(6, 8 ,5, 7);
		System.out.println("Rectangle b1 = new Rectangle(new Point(14, 9), 3, 3);");
		Rectangle b1 = new Rectangle(new Point(14, 9), 3, 3);
		System.out.println("Rectangle b2 = new Rectangle(new Point(10, 3), 5, 8);");
		Rectangle b2 = new Rectangle(new Point(10, 3), 5, 8);
		System.out.println("Rectangle c1 = new Rectangle(14, 9, 3, 3);");
		Rectangle c1 = new Rectangle(14, 9, 3, 3);
		System.out.println("c2 = new Rectangle(b1.getX(), b1.getY(), b1.getWidth(), b1.getHeight());");		//copy the b1 rectangle
		Rectangle c2 = new Rectangle(b1.getX(), b1.getY(), b1.getWidth(), b1.getHeight());
		System.out.println();
		
		System.out.println("Testing toString(): ");			// print things out using toString()
		System.out.printf("a1 = %s\n", a1);
		System.out.printf("b1 = %s\n", b1);
		System.out.printf("c1 = %s\n", c1);
		System.out.printf("c2 = %s\n", c2);
		System.out.println();
		
		System.out.println("Testing union:");			// the rectangle that contains both objects
		System.out.println("a1 union a2 = " + a1.union(a2));
		System.out.println("b1 union b2 = " + b1.union(b2));
		System.out.println("c1 union c2 = " + c1.union(c2));
		System.out.println();
		
		System.out.println("Confirming rectangles didn't change:");		// just to be sure
		System.out.printf("a1 = %s\n", a1);
		System.out.printf("b1 = %s\n", b1);
		System.out.printf("c1 = %s\n", c1);
		System.out.printf("c2 = %s\n", c2);
		System.out.println();
		
		System.out.println("Creating points: ");		// constructing points
		Point p1 = new Point(5, 11);
		System.out.println("Point p1 = new Point(5, 11);");
		Point p2 = new Point(7, 14);
		System.out.println("Point p2 = new Point(7, 14);");
		System.out.println();
		
		System.out.println("Testing contains: ");		// see if the points are in the rectangles
		System.out.println("a1.contains(p1) = " + a1.contains(p1));
		System.out.println("a1.union(a2).contains(p1) = " + a1.union(a2).contains(p1));
		System.out.println("a1.contains(p2) = " + a1.contains(p2));
		System.out.println("b1.contains(10, 10) = " + b1.contains(10, 10));
		System.out.println("b2.contains(10, 10) = " + b2.contains(10, 10));
	}
}
