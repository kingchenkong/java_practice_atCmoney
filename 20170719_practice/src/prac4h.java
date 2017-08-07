import java.util.Scanner;
public class prac4h {

	public static void main(String[] args) {

		//Declare, Initialize
		Scanner scanner = new Scanner(System.in);
		int size = 0;

		//size >= 1
		do {
			System.out.println("請輸入層級: ");
			size = scanner.nextInt();
		} while ( size < 1 ) ;

		//Part I :
		for ( int i = 0; i < size; i++ ) {
			for ( int j = 0; j < ( size - i - 1 ); j++ ) {
				System.out.print(" ");
			}
			for ( int k = 0; k < (2 * i + 1); k++ ) {
				boolean Y = (k == 0 ) || (k == (2* i));

				if( Y ) {
					System.out.print("*");
				} else {
					System.out.print(" ");

				}
			}

			System.out.print("\n");
			
		}
		//Part II :
		for ( int i = 0; i < ( size - 1 ); i++ ) {
			for ( int j = 0; j < ( i + 1 ); j++ ) {
				System.out.print(" ");
			}
			for ( int k = 0; k < ( 2 * (size -i) - 3 ) ; k++ ) {
				boolean Y = (k == 0 ) || (k == (2 * (size -i) - 4));

				if( Y ) {
					System.out.print("*");
				} else {
					System.out.print(" ");

				}

			}

			System.out.print("\n");
			
		}

		//Recycle the resources - scanner
		scanner.close();
	}

}
