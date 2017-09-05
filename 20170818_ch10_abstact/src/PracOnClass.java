
import java.lang.*;
import java.util.*;
public class PracOnClass {

	public static void main(String[] args) {

		//		CShape obj =	new CShape(); // 錯誤，抽象類別不能產生物件實體
		CRect sh1 = new CRect(5.0,15.0);
		CCircle sh2 = new CCircle(3.0);
		
		CShape arrShape[] = new CShape[4]; // 抽象型態的變數陣列
		arrShape[0] = new CRect(10.0,20.0); // 變數參考子類別物件實體 
		arrShape[1] = new CRect(5.0,15.0);
		arrShape[2] = new  CCircle(3.0);
		arrShape[3] = new  CCircle(6.0);
		
		for(int i = 0; i < arrShape.length; i++) {
			arrShape[i].computeArea();
			arrShape[i].computePerimeter();
		}
		
		System.out.println("###------Original------###");
		CShape.show(arrShape);
		System.out.println("###------sort By Area------###");
		CShape.sortByArea(arrShape);
		CShape.show(arrShape);
		System.out.println("###------sort By Perimeter------###");
		CShape.sortByPerimeter(arrShape);
		CShape.show(arrShape);
		

	}

}
abstract class CShape {
	protected double area;
	protected double perimeter;

	public static void show(CShape[] arrSh) {
		for(int i = 0; i < arrSh.length; i++) {
			System.out.println("----- " + arrSh.getClass().getSimpleName() + " [" + i + "] -----");
			System.out.printf("class : %s \n -Area : %.2f\n -Perimeter : %.2f\n", arrSh[i].getClass().getName(), arrSh[i].area, arrSh[i].perimeter);
		}
	}
	public static void sortByArea(CShape[] arrSh) {
		for(int i = 0; i < arrSh.length - 1; i++) {
			for(int j = 0; j < arrSh.length - i - 1; j++) {
				if(arrSh[j].area > arrSh[j+1].area) {
					CShape temp = arrSh[j+1];
					arrSh[j+1] = arrSh[j];
					arrSh[j] = temp;
				}
			}
		}	
	}
	public static void sortByPerimeter(CShape[] arrSh) {
		for(int i = 0; i < arrSh.length - 1; i++) {
			for(int j = 0; j < arrSh.length - i - 1; j++) {
				if(arrSh[j].perimeter > arrSh[j+1].perimeter) {
					CShape temp = arrSh[j+1];
					arrSh[j+1] = arrSh[j];
					arrSh[j] = temp;
				}
			}
		}	
	}
	public abstract void computeArea();
	public abstract double getArea();
	public abstract void computePerimeter();
	public abstract double getPerimeter();
}
class CRect extends CShape{
	protected double length;
	protected double width;

	public CRect(double l, double w) {
		this.length = l;
		this.width = w;
	}
	public  void show() {
		System.out.printf("CRect :\n -length: %.3f\n -width : %.3f\n -Area : %.3f\n -Perimeter : %.3f\n", this.length, this.width, this.area, this.perimeter);
	}
	public void computeArea() {
		this.area = this.length * this.width;
	}
	public double getArea() {
		return this.area;		
	}
	public void computePerimeter() {
		this.perimeter = (this.length + this.width) * 2;
	}
	public double getPerimeter() {
		return this.perimeter;	
	}
}
class CCircle extends CShape{
	protected double radius;

	public CCircle(double r) {
		this.radius = r;
	}
	public void show() {
		System.out.printf("CRect :\n -radius: %.3f\n -Area : %.3f\n -Perimeter : %.3f\n", this.radius, this.area, this.perimeter);
	}
	public void computeArea() {
		this.area = this.radius * this.radius * Math.PI;
	}
	public double getArea() {
		return this.area;		
	}
	public void computePerimeter() {
		this.perimeter = 2 * this.radius * Math.PI;
	}
	public double getPerimeter() {
		return this.perimeter;	
	}
}