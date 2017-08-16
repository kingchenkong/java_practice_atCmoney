import java.lang.*;
import java.util.*;
public class TechersDemo10_08 {
	public static void main(String[] args) {
		
		CShape[] arrShape = new CShape[4];
		arrShape[0] = new CRect(2, 3);
		arrShape[1] = new CRect(4, 5);
		arrShape[2] = new CCircle(6);
		arrShape[3] = new CCircle(7);
		
		for(int i = 0; i < arrShape.length; i++) {
			if(arrShape[i] != null) {
				System.out.printf("--- arrShape[%d] ---\n", i);
				System.out.printf("area = \t\t %10.3f\n", arrShape[i].getArea() );
				System.out.printf("perimeter = \t %10.3f\n", arrShape[i].getPerimeter() );
			}
		}
		
	}

}
class CShape {
	protected double area;
	protected double perimeter;
	
	public CShape() {
		area = 0.0;
	}
	public double getArea() {
		computeArea();	// 在父類別方法 可以省 行數
		return this.area;
	}
	public double getPerimeter() {
		computePerimeter();
		return this.perimeter;
	}
	public void computeArea() {
	}
	public void computePerimeter() {
		
	}
}
class CRect extends CShape {
	protected double length;
	protected double width;
	
	public CRect(double l, double w) {
		this.length = l;
		this.width = w;
//		computeArea();
	}

	@Override public void computeArea() {
		
		this.area = this.length * this.width;
	}
	@Override public void computePerimeter() {
		this.perimeter = (this.length + this.width) * 2;
	}
}
class CCircle extends CShape {
	protected double radius;
	
	public CCircle(double r) {
		this.radius = r;
//		computeArea();
	}
	
	@Override public void computeArea() {
	this.area = this.radius * this.radius * Math.PI;	
		
	}
	@Override public void computePerimeter() {
		this.perimeter = 2 * Math.PI * this.radius;
	}
	
}