import java.util.Scanner;

public class Practice2a {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
	    double db1, db2, db3 = 0.0;
	      
	    System.out.print("Plz input two double float:");
	    db1 = scanner.nextDouble();
	    db2 = scanner.nextDouble();
	      
	    db3 = db1 + db2;
	    System.out.printf("Number1 + Number2 = %.2f\n", db3);
	    db3 = db1 - db2;
	    System.out.printf("Number1 - Number2 = %.2f\n", db3);
	    db3 = db1 * db2;
	    System.out.printf("Number1 * Number2 = %.2f\n", db3);
	    db3 = db1 / db2;
	    System.out.printf("Number1 / Number2 = %.2f\n" ,db3);
	}

}
