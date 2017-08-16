import java.lang.*;
import java.util.*;
public class TechersDemo10_07 {

	public static void main(String[] args) {

		Animal[] arrAni = new Animal[5];
		arrAni[0] = new Dog();
		arrAni[1] = new Bird();
		arrAni[2] = new Bird();
		arrAni[3] = new Dog();

		for(int i = 0; i < arrAni.length; i++) {
			if(arrAni[i] == null) {
				System.out.println("the Cage is Empty.");
			} else {
				try {
					arrAni[i].drink();
					arrAni[i].speak();
					//arrAni[i].run(); // 無法使用子類別新增的函式
					//arrAni[i].fly();
					if(arrAni[i].getClass() == Dog.class) {
						System.out.println("arrAni[" + i + "]=========> Dog.");
					}
					if(arrAni[i].getClass() == Bird.class) {
						System.out.println("arrAni[" + i + "]=========> Bird.");
					}
					
				} catch(Exception e) {
					System.out.println("arrAni[" + i + "] no this Method.");
				}
			}
		}
	}

}
class Animal {
	protected String Blood ;

	public Animal() {
		this.Blood = "red";
	}
	public void drink() {
		System.out.println("drink water.");
	}
	public void speak() {
	}

}
class Dog extends Animal{

	@Override public void speak() {
		System.out.println("speak: woof!!");
	}
	public void run() {
		System.out.println("runnig~~~~~~");
	}

}
class Bird extends Animal{

	@Override public void speak() {
		System.out.println("speak: chu!!");
	}
	public void fly() {
		System.out.println("fly~~~~");
	}
}