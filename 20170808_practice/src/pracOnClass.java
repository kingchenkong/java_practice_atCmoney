//實作 巴斯卡定理（C(m取n)

import java.util.*;
public class pracOnClass {

	public static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("請輸入 共有多少位置 : ");
		int m = scanner.nextInt();
		System.out.println("請輸入取多少？ ");
		int n = scanner.nextInt();
		System.out.print("共有");
		System.out.print( pascal( m, n) );
		System.out.println("種可能");
	}
	public static int pascal(int n, int k) {
		if( k <= 0) {
			return 1;
		}
		return pascal(n - 1, k - 1) * n  / k ;
	}

}
