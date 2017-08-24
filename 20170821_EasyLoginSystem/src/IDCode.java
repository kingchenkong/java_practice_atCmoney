// http://returnbool.pixnet.net/blog/post/10268673-%5B知識%5D身分證字號相關概念
public class IDCode {
	private String ID;
	public static final int[] firstLetterNo = {10, 11, 12, 13, 14, 15, 16, 17, 34, 18, 19, 20, 21, 22, 35, 23, 24, 25, 26, 27, 28, 29, 32, 30, 31, 33};
	// ----------------------------------- //   A,  B,  C,  D,  E,  F,  G,  H,  I,  J,  K,  L,  M,  N,  O,  P,  Q,  R,  S,  T,  U,  V,  W,  X,  Y,  Z
	public IDCode(String str) {
		if(IDCode.isValid(str)) {
			this.ID = str;
		} else {
			this.ID = null;
		}
	}
	// setter
	// getter
	public String getIDStr() {
		return this.ID;
	}

	public static boolean isValid(String str) {
		// 身分證字號 是否正確 
		
//		System.out.println("str => " + str);
		char[] arrC = str.toCharArray();
		int letterNo;

		// 驗證 是否為十碼 
		if(arrC.length != 10)
			return false;

		// 驗證 char 0, 第一個是大寫英文字
		if((int)arrC[0] >= 65 && (int)arrC[0] <= 90) {
			letterNo = IDCode.firstLetterNo[ (int) arrC[0] - 65 ];
//			System.out.println("是, 大寫英文字");
//			System.out.println("代表 數字 為 : " + letterNo);
		} else {
//			System.out.println("illegal.");
			return false;
		}
		// 驗證 char 1~9, 皆為數字
		int count = 0;
		for(int i = 1; i <= 9 ; i++) 
			if( (int) arrC[i] < 48 || (int) arrC[i] > 57)
				count += 1;
		if(count != 0)
			return false;
		// 驗證 第二個數字  性別碼 
		if(arrC[1] != '1' && arrC[1] != '2') 
			return false;
		// 驗證 後面
		// arrC 轉數字
		int[] arrCNum = new int[9];
		for(int i = 0; i < 9; i++)
			arrCNum[i] = (int)arrC[i+1] - 48;
//		int checkNum = arrCNum[8];
		int y = letterNo / 10 + letterNo % 10 * 9;
		int sum = 0;
		for(int i = 0; i < 8; i++) {
			sum += arrCNum[i] * (8 - i);
//			System.out.println(" sum += arrCNum[i] * (8 - i)");
//			System.out.println(sum + " += " + arrCNum[i] + " * " + (8 - i));
		}
		sum += y;
		int mod10 = sum % 10;
//		System.out.println("sum + y = " + sum);
//		System.out.println("sum % 10 = " + mod10);
		if(10 - mod10 != arrCNum[8])
			return false;
		return true;
	}

}
