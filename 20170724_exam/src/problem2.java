//題目二（70%）：
//請撰寫一個程式用以模擬五月天演唱會的訂票系統；
//假設舉辦地點於小巨蛋，現場共有 '10000個座位'。演唱會共 '舉辦1場'。
//座位劃分為 'VIP區'  、 	'搖滾區'  與 		'一般區' ，
//座位個數為 '2000個' 、 	'3000個'  與 	'5000個' ，
//票價分別為 '3000元' 、 	'2000元' 以及 	'1000元' ， 一次購買 '三張以上有85折' 優惠。
//執行範例如下（粗體字表使用者輸入的部分）：
//
//歡迎進入五月天「諾亞方舟」演唱會的訂票系統！
//VIP區座位（$3000）：2000個
//搖滾區座位（$2000）：3000個
//一般區座位（$1000）：5000個
//
//購票 1)是 2)否? 1
//開始購票！
//選擇座位：1)VIP區 2)搖滾區 3)一般區 4)取消: 4
//取消購票！
//
//歡迎進入五月天「諾亞方舟」演唱會的訂票系統！
//VIP區座位（$3000）：2000個
//搖滾區座位（$2000）：3000個
//一般區座位（$1000）：5000個
//
//購票 1)是 2)否? 1
//開始購票！
//選擇座位：1)VIP區 2)搖滾區 3)一般區 4)取消: 2
//搖滾區，請選擇張數(輸入-1回上一步)：-1
//選擇座位：1)VIP區 2)搖滾區 3)一般區 4)取消: 3
//一般區，請選擇張數(輸入-1回上一步)：5005
//座位不足! 
//
//歡迎進入五月天「諾亞方舟」演唱會的訂票系統！
//VIP區座位（$3000）：2000個
//搖滾區座位（$2000）：3000個
//一般區座位（$1000）：5000個
//
//購票 1)是 2)否? 1
//開始購票！
//選擇座位：1)VIP區 2)搖滾區 3)一般區 4)取消: 2
//搖滾區，請選擇張數(輸入-1回上一步)：3
//訂購 搖滾區 座位共 3 張，票價5100。
//
//請投入現金： 1) 50元 2) 100元 3) 500元4) 1000元 5)取消: 4
//請投入現金： 1) 50元 2) 100元 3) 500元4) 1000元 5)取消: 4
//請投入現金： 1) 50元 2) 100元 3) 500元4) 1000元 5)取消: 4
//請投入現金： 1) 50元 2) 100元 3) 500元4) 1000元 5)取消: 4
//請投入現金： 1) 50元 2) 100元 3) 500元4) 1000元 5)取消: 4
//請投入現金： 1) 50元 2) 100元 3) 500元4) 1000元 5)取消: 4
//收您6000元
//找您 900 元
//謝謝！
//
//---------------------------------------------------------------------------------
//歡迎進入五月天「諾亞方舟」演唱會的訂票系統！
//VIP區座位（$3000）：2000個
//搖滾區座位（$2000）：3000個
//一般區座位（$1000）：4000個
//
//購票(1=yes/2=no)? 2
//感謝您的使用，再見！

import java.util.Scanner;
public class problem2 {

	public static void main(String[] args) {
		//Declare, Initial
		Scanner scanner = new Scanner(System.in);
		boolean redo = true;
		boolean reEnter = false;
		boolean discount = false; //85折優惠, 一次買三張以上
		int step = 0; 
		// 0 => 開始購票
		// 1 =>	選擇座位
		// 2 => 選擇張數
		// 3 => 請投入現金
		// 4 => 找錢
		int buyTicket = 0;
		int chooseSit = 0;
		int ticketNum = 0;
		int ticketPrice = 0;
		int ticketNumVip = 2000;
		int ticketNumRock = 3000;
		int ticketNumNormal = 5000;
		int optionCash = 0;
		int alreadyPutIn = 0;

		//Begin
		do {
			//##############################
			//step = 0
			//是否購票
			//##############################
			do {
				// re-circle setting
				redo = true;
				reEnter = false;
				discount = false; 


				if(step == 0) {
					//開始訊息
					System.out.print("歡迎進入五月天「諾亞方舟」演唱會的訂票系統！\n" + 
							"VIP區座位（$3000）：" + ticketNumVip + "個\n" + 
							"搖滾區座位（$2000）：" + ticketNumRock + "個\n" + 
							"一般區座位（$1000）：" + ticketNumNormal + "個\n\n");
					System.out.print("購票 1)是 2)否? ");
					buyTicket = scanner.nextInt();
					if(buyTicket == 2) {
						//						System.out.println("取消購票！");
						redo = false;
						//exit!!
					} 
					if(buyTicket == 1){
						System.out.println("開始購票！");
						step = 1;
						//進入 '選擇座位'
					} 
					// > 2 or < 1 , 重新輸入
					if( (buyTicket > 2) || (buyTicket < 1) ) {
						reEnter = true;
						System.out.println("錯誤選項, 請重新輸入");
					} else {
						reEnter = false;
					}

				}
			} while( reEnter );
			//##############################
			//step = 1
			//選擇座位, 有取消
			//##############################
			if(step == 1) {
				do {
					System.out.print("選擇座位：1)VIP區 2)搖滾區 3)一般區 4)取消: ");
					chooseSit = scanner.nextInt();

					if(chooseSit == 1) {
						System.out.print("\nVIP區，");
						step = 2;
						//進入 '選擇張數'
					}
					if(chooseSit == 2) {
						System.out.print("\n搖滾區，");
						step = 2;
						//進入 '選擇張數'
					}
					if(chooseSit == 3) {
						System.out.print("\n一般區，");
						step = 2;
						//進入 '選擇張數'
					}
					if(chooseSit == 4) {
						System.out.println("取消購票！");
						step = 0;
						//重新購票
					}
					// > 4 or < 1 , 重新輸入
					if( (chooseSit > 4) || (chooseSit < 1) ) {
						reEnter = true;
						System.out.println("錯誤選項, 請重新輸入");
					} else {
						reEnter = false;
					}

				} while( reEnter );

			}
			//##############################
			//step = 2
			//選擇張數, 有取消, 有回上一步
			//##############################
			if(step == 2) {
				do {
					System.out.print("請選擇張數(輸入-1回上一步)： ");
					ticketNum = scanner.nextInt();
					if(ticketNum == -1) {
						step = 1;
						//回上一步
					}
					if(ticketNum > 0) {

						//三張以上85折
						discount = (ticketNum > 2);
						//test
						//						System.out.println("discount is " + discount);

						if( (chooseSit == 1) && (ticketNum <= ticketNumVip) ) {
							System.out.print("訂購 VIP區 座位共" + ticketNum + " 張，票價");
							ticketPrice = ticketNum * 3000;
							step = 3;
							//進入 '投入現金'
						} else if( (chooseSit == 2) && (ticketNum <= ticketNumRock) ) {
							System.out.print("訂購 搖滾區 座位共" + ticketNum + " 張，票價");
							ticketPrice = ticketNum * 2000;
							step = 3;
							//進入 '投入現金'
						} else if( (chooseSit == 3) && (ticketNum <= ticketNumNormal) ) {
							System.out.print("訂購 一般區 座位共" + ticketNum + " 張，票價");
							ticketPrice = ticketNum * 1000;
							step = 3;
							//進入 '投入現金'
						} else {
							System.out.println("座位不足!");
							step = 0;
							//重新購票
						}
						if( discount ) {
							ticketPrice *= 0.85;
						}
						if(step == 3) {
							System.out.println(ticketPrice +"。");
						}
					}
					// < 1, 重新輸入
					if( (ticketNum != -1) && (ticketNum  < 1) ) {
						reEnter = true;
						System.out.println("錯誤選項, 請重新輸入");
					} else {
						reEnter = false;
					}

				} while( reEnter );

			}
			//step = 3
			//投入現金
			if(step == 3) {
				//reset
				alreadyPutIn = 0;

				do {
					System.out.print("請投入現金： 1) 50元 2) 100元 3) 500元4) 1000元 5)取消: ");
					optionCash = scanner.nextInt();

					// >5, < 1, 重新輸入
					if( (optionCash > 5) || ( optionCash < 1) ) {
						System.out.println("錯誤選項, 請重新輸入");
						reEnter = true;
					} else {
						reEnter = false;
					}

					if(optionCash == 5) {
						System.out.println("取消購票！");
						System.out.println("退還您 " + alreadyPutIn +"元");
						step = 0;
						//重新購票
					} else {
						if(optionCash == 1) {
							alreadyPutIn += 50;
						}
						if(optionCash == 2) {
							alreadyPutIn += 100;
						}
						if(optionCash == 3) {
							alreadyPutIn += 500;
						}
						if(optionCash == 4) {
							alreadyPutIn += 1000;
						}
						if(alreadyPutIn >= ticketPrice) {
							System.out.println("收您 " + alreadyPutIn +"元");
							System.out.println("找您 " + (alreadyPutIn - ticketPrice) +"元");
							System.out.println("謝謝！\n" + 
									"\n" + 
									"---------------------------------------------------------------------------------");
							//減票數
							if(chooseSit == 1) {
								ticketNumVip -= ticketNum;
							}
							if(chooseSit == 2) {
								ticketNumRock -= ticketNum;

							}
							if(chooseSit == 3) {
								ticketNumNormal -= ticketNum;

							}
							

							reEnter = false;
							step = 0;
							//下一次購買
						} else {
							reEnter = true;
						}

					}

				} while(reEnter);
			}


		} while(redo);	
		//離開售票
		System.out.println("感謝您的使用，再見！");

		//Recycle
		scanner.close();
	}

}
