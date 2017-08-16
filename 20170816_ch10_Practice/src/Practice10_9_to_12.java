import java.util.*;
import java.lang.*;
public class Practice10_9_to_12 {

	public static void main(String[] args) {

		CShapeAt12[] arrShape = new CShapeAt12[5];
		arrShape[0] = new CRectAt12(2, 3);
		arrShape[1] = new CRectAt12(4, 5);
		arrShape[2] = new CCircleAt12(6);
		arrShape[3] = new CCircleAt12(7);
		arrShape[4] = arrShape[0];

		for(int i = 0; i < arrShape.length; i++) {
			if(arrShape[i] != null) {
				System.out.printf("--- arrShape[%d] ---\n", i);
				System.out.println("---------------------------------");
				// .equals
				int count = 0;
				for(int j = 0; j < arrShape.length - 1; j++) {
					if(i != j) {
						if(arrShape[i].equals(arrShape[j])) {
							System.out.println("| is equal => arrShape[" + j + "]");
							count++;
						}
					}
					
				}
				if(count == 0) {
					System.out.println("| No equal thing in arrShape.");
				}
				// .getClass
				System.out.println("| is belong to '" + arrShape[i].getClass() + "'");
				// - [ @Override ] -> .toString 
				System.out.println("| .toString : '" + arrShape[i].toString() + "'");
				System.out.println("---------------------------------");
			}
		}


	}

}
// class
class CShapeAt12 {
	protected double area;
	protected double perimeter;

	public CShapeAt12() {
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
class CRectAt12 extends CShapeAt12 {
	protected double length;
	protected double width;

	public CRectAt12(double l, double w) {
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
	@Override public String toString() {
		return "我是 方 形!";
	}
}
class CCircleAt12 extends CShapeAt12 {
	protected double radius;

	public CCircleAt12(double r) {
		this.radius = r;
		//		computeArea();
	}

	@Override public void computeArea() {
		this.area = this.radius * this.radius * Math.PI;	

	}
	@Override public void computePerimeter() {
		this.perimeter = 2 * Math.PI * this.radius;
	}
	@Override public String toString() {
		return "我是 圓 形!";
	}
}
