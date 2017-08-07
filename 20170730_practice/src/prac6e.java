//請撰寫一個程式，設計一個自動櫃員機（ATM）提領現金的流程。
//程式執行之初，先輸入初始狀態，包括顧客戶頭內可用餘額、ATM中可提領的金額，手續費的費率，以及儲蓄利率。
//之後，接下來才進入ATM的作業。
//進入作業時，顯示主選單請使用者輸入選項。使用者可選擇存錢、領錢或離開三種選項。
//請注意，帳戶存款並不會增加ATM的現金金額。不論領錢或存錢，操作成功後皆必須會自動扣除手續費（交易金額乘以手續費費率），並列印出報表。
//先判斷交易金額，使其不得超過兩萬元。領錢的過程中，先判斷ATM是否有足夠可提領之餘額，再判斷帳戶餘額（提領的錢加手續費）是否充足，否則必須顯示錯誤訊息，並回到主選單。
//每回合作業中首先依儲蓄利率計算儲蓄所得，並浮動調整手續費與儲蓄利率，以隨機方式決定漲跌與漲跌幅，請注意漲跌幅不超過10%，
//請使用副函式為你的程式適度地作模組化。程式執行範例如下（使用者輸入部分以黑字標註）：
//
//Available balance :10000
//Loading rate (%):0.7
//Interest rate (%): 0.1
//Cash available in ATM: 3000
//----------------------------------------------------------------------------------------------
//
//Welcome. Please enter your option.
//A) Withdrawal. B) Deposit. C) Quit: A
//Amount of withdrawal: 200000
//Amount of transaction exceeds $20000 limit.
//Transaction cancelled.
//
//A) Withdrawal. B) Deposit. C) Quit: A
//Amount of withdrawal: 2000
//Withdraw 2000 dollars from your account. Sure (y/n)? y
//$2000 withdrawn. 
//Deposit           Withdrawal         Loading Fee       Balance
//----------------------------------------------------------------------------------------------
// 10010                 2000                 14          7996
//
//Loading rate (%): 0.721 (+3%)
//Interest rate (%): 0.098 (-2%)
//
//A) Withdrawal. B) Deposit. C) Quit: A
//Amount of withdrawal: 8000
//Cash insufficient.
//Transaction cancelled.
//
//A) Withdrawal. B) Deposit. C) Quit: A
//Amount of withdrawal: 1000
//Withdraw 1000 dollars from your account. Sure (y/n)? y
//$1000 withdrawn. 
//Deposit           Withdrawal         Loading Fee       Balance
//----------------------------------------------------------------------------------------------
// 8003                 1000                   7          6996
//
//Loading rate (%): 0.742 (+3%)
//Interest rate (%): 0.1 (+3%)
//
//A) Withdrawal. B) Deposit. C) Quit: C
//Program quits
import java.util.*;
public class prac6e {
	//全域使用
	public static Scanner scanner = new Scanner(System.in);
	public static double[] arrayInit = new double[4];
	//	arrayInit[0], 帳戶 可用餘額
	//	arrayInit[1], 手續費率 (%)
	//	arrayInit[2], 利率 (%)
	//	arrayInit[3], ATM 機內可用現金

	//main
	public static void main(String[] args) {

		//declare
		//var - process control
		int mainOption = -1;
		String inputMainOption = "";
		boolean reEnter = false;

		//Begin
		initSetting();
		System.out.println("-- 歡迎使用 --" + "\n" + "-->黑心銀行<-- " + "\n" + "::您就是我們的ＡＴＭ::" + "\n");

		//服務選擇
		do {
			System.out.print("請指定 需要的服務 ");
			do {
				System.out.println("A) 提款. B) 存款. C) 離開. : ");
				inputMainOption = scanner.next();
				reEnter = !checkOptionString(inputMainOption);
			} while(reEnter);
			//option change 
			mainOption = changeOptionPara(inputMainOption);
			switch(mainOption) {
			//block - 提款
			case 1:
				//輸入 提款金額
				reEnter = false;
				int withdrawnAmount = 0;
				System.out.print("\n" + "請輸入 提款金額 : ");
				withdrawnAmount = scanner.nextInt();
				//檢查
				//金額 < 20k, > 20k print error
				//金額 > ATM available, print error
				if(!checkWithdrawnAmount(withdrawnAmount)) {
					break;
				}
				System.out.print("\n是否提款 y/n? ");
				String strWA = scanner.next();
				if( strWA.equals("y") ) {
					showAccountInfo(true, withdrawnAmount);
				} else if( strWA.equals("n") ){
					//n => 回主選單
					System.out.println("-->取消提款<--");
				}
				break;

				//block - 存款
			case 2:
				//輸入 存款金額
				System.out.print("\n" + "請輸入 存款金額 : ");
				reEnter = false;
				int desposit = 0;
				desposit = scanner.nextInt();
				//				if(!checkWithdrawnAmount(desposit)) {
				//					break;
				//				}
				System.out.print("\n是否存款 y/n? ");
				String strDe = scanner.next();
				if( strDe.equals("y") ) {
					showAccountInfo(false, desposit);
				} else if( strDe.equals("n") ){
					//n => 回主選單
					System.out.println("-->取消提款<--");
				}
				break;

				//block - quit
			default:
				System.out.println(" -- 感謝您的使用 -- ");
				System.exit(0);
			}
		} while(true);
	}

	//##########
	// function
	//##########

	//initial setting 
	public static void initSetting() {
		System.out.print("\t" + "=== setting Account ===");
		System.out.print("\n" + "帳戶 可用餘額 : ");
		arrayInit[0] = scanner.nextDouble();
		System.out.print("\n" + "手續費率 (%): ");
		arrayInit[1] = scanner.nextDouble() / 100;
		System.out.print("\n" + "利率 (%): ");
		arrayInit[2] = scanner.nextDouble() / 100;

		System.out.print("\n\t" + "=== setting ATM ===");
		System.out.print("\n" + "ATM 機內可用現金: ");
		arrayInit[3] = scanner.nextDouble();
		System.out.println("----------------------------------------------------------------------------------------------");
		//test
		//		System.out.printf("%7.0f, %10.7f, %10.5f, %7.0f\n", arrayInit[0], arrayInit[1], arrayInit[2], arrayInit[3]);
	}

	// mainOption - check string
	public static boolean checkOptionString(String strNeedCheck) {
//		System.out.println("strNeedCheck = " + strNeedCheck);
		if( strNeedCheck.equals("A") || strNeedCheck.equals("B") || strNeedCheck.equals("C") ) {
			return true;
		} else {
			System.out.println(" -->Error<-- ");
			System.out.println("Plz re-Enter");
			return false;
		}
	}

	// mainOption - change Option parameter
	public static int changeOptionPara(String str) {
		if(str.equals("A") ) {
			return 1;
		} else if(str.equals("B")) {
			return 2;
		} else if(str.equals("C")) {
			return 3;
		} else {
			System.out.println(" -->Error<-- ");
		}
		return 0;
	}

	//withdrawn - check amount
	public static boolean checkWithdrawnAmount(int wa) {
		if(wa > 20000) {
			System.out.println("單次最高交易金額為 20,000 元");
			return false;
		} else if(wa > arrayInit[0]){
			System.out.printf("帳戶 餘額不足, 餘額剩餘: %7.0f" + "\n", arrayInit[0]);
			return false;
		} else if(wa > arrayInit[3]) {
			System.out.printf("ATM 機內餘額不足, 餘額剩餘: %7.0f" + "\n", arrayInit[3]);
			return false;
		} else {
			//			System.out.println("is OK.");
			return true;
		}
	}

	//show Account info
	public static void showAccountInfo(boolean withdrawnOrDeposit, int amount){ 
		//withdrawnOrDeposit
		//true -- Withdrawn
		//false -- Deposit
		//y => 扣除手續費 再 乘 利息
		int feeIncrease = ( (int)(Math.random() * 20) - 10 );
		int interestIncrease = ( (int)(Math.random() * 20) - 10 );

		System.out.print("Deposit" + "\t\t");
		if(withdrawnOrDeposit) {
			System.out.println("Withdrawal" + "\t\t" + "Loading Fee" + "\t\t" + "Balance");
		} else {
			System.out.println("Deposit" + "\t\t" + "Loading Fee" + "\t\t" + "Balance");
		}
		System.out.println("----------------------------------------------------------------------------------------------");

		//Deposit
		arrayInit[0] += (arrayInit[0] * arrayInit[2]);
		int deposit = (int)arrayInit[0];

		//Withdrawal = amount
		//Loading Fee
		int loadingFee = (int)(amount * arrayInit[1]);

		//Balance
		if(withdrawnOrDeposit) {
			arrayInit[0] = arrayInit[0] - loadingFee - amount;
		} else {
			arrayInit[0] = arrayInit[0] - loadingFee + amount;
		}
		System.out.printf("%7d \t\t %5d \t\t %3d \t\t\t %6.0f\n", deposit, amount, loadingFee, arrayInit[0]);

		//調整 arrayInit
		arrayInit[1] = (arrayInit[1] * (1 + (double)feeIncrease / 100)) ;
		arrayInit[2] = (arrayInit[2] * (1 + (double)interestIncrease / 100));
		arrayInit[3] -= amount; 

		if(feeIncrease >= 0) {
			System.out.print("Loading rate (%");
			System.out.printf("): %.3f ( +%1d", (arrayInit[1] * 100), feeIncrease);
			System.out.println("%)");
		} else {
			System.out.print("Loading rate (%");
			System.out.printf("): %.3f ( %1d", (arrayInit[1] * 100), feeIncrease);
			System.out.println("%)");		}
		if(interestIncrease >= 0) {
			System.out.print("Interest rate (%");
			System.out.printf("): %.3f ( +%1d", (arrayInit[2] * 100), interestIncrease);
			System.out.println("%)");
		} else {
			System.out.print("Interest rate (%");
			System.out.printf("): %.3f ( %1d", (arrayInit[2] * 100), interestIncrease);
			System.out.println("%)");
		}
		//test
		//		System.out.printf("%7.0f, %10.7f, %10.5f, %7.0f\n", arrayInit[0], arrayInit[1], arrayInit[2], arrayInit[3]);
	}
}