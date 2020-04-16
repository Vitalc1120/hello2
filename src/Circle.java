
public class Circle {
	public double radius;
	public double PI = 3.14;
	public Circle() {
		
	}
	public Circle(double radius) {
		this.radius = radius;
	}
	
	public double getArea() {		
		return radius * radius * PI;
	}
	
	public double getGirth() {
		return 2 * radius * PI;
	}
}
