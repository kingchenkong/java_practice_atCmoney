
//題目
//請撰寫一個程式用以模擬高鐵網路訂票系統；假設當日班次 "北上與南下各2班（共四班" ，每班共 "5個座位" 。
//搭乘 "一段" （如台北至台中）票價為 "536" ，搭乘 "兩段" （如台北到高雄）票價為 "927" 。
//程式執行範例如下所示，使用者輸入部分以黑字標註。
//請寫註解，並注意程式碼排版。
//如你覺得流程複雜或困難，請嘗試使用流程圖或演算法來幫助你思考問題的解決方法。
//
//難度一：
//
//販賣機會一直要求使用者輸入現金直到總金額大於總票價；
//如果使用者在輸入現金時按取消，會程式將退回已輸入的金額，並重新詢問是否要繼續購票。
//難度二：
//
//1元硬幣個數：30
//5元硬幣個數：30
//10元硬幣個數：30
//---------------------------------------------------------------------------------
//購票 1)是 2)否? 1
//開始購票！
//選擇起站：1)台北 2)台中 3)高雄 4)取消: 4
//取消購票！
//
//購票 1)是 2)否? 1
//開始購票！
//選擇起站：1)台北 2)台中 3)高雄 4)取消: 2
//選擇訖站：1)台北 2)台中 3)高雄 4)回上一步 5)取消: 4
//選擇起站：1)台北 2)台中 3)高雄 4)取消: 1
//選擇訖站：1)台北 2)台中 3)高雄 4)回上一步 5)取消: 3
//選擇張數：1) 1 張 2) 2 張 2) 3 張 4)回上一步 5)取消: 2
//
//搭乘 台北到高雄列車，座位共 2 張，票價 1854 元。
//請投入現金： 1) 50元 2) 100元 3) 500元4) 1000元 5)取消: 3
//請投入現金： 1) 50元 2) 100元 3) 500元4) 1000元 5)取消: 3
//請投入現金： 1) 50元 2) 100元 3) 500元4) 1000元 5)取消: 4
//收您2000元
//找您 146 元 
//(退回10元硬幣14個，5元硬幣1個，1元硬幣1個)
//
//---------------------------------------------------------------------------------
//購票(1=yes/2=no)? 
//
//找錢時會以面額大的硬幣來找開，除非該面額沒有剩餘的硬幣為止。
//如沒有硬幣現金可找，請印出「現金不足，無法找零，請恰櫃臺人員」的訊息，並將程式自動終止。

import java.util.Scanner;

public class prac4f {

	public static void main(String[] args) {
		// Declare, Initialize
		Scanner scanner = new Scanner(System.in);
		// 狀態機 - 現在選擇的階段
		boolean buyTicketNowSelect = true, ticketAllAlready = false;
		boolean startStationNowSelect = false, stopStationNowSelect = false, ticketNumNowSelect = false;
		// 儲存選項
		int buyTicket = 0, startStation = 0, stopStation = 0, ticketNum = 0;
		// 站台距離
		int stationDistance = 0;
		// 機內零錢
		int coin1 = 0, coin5 = 0, coin10 = 0; // 零錢
		// 未使用
		// int coin50 = 0; //零錢
		// int cash100 = 0, cash500 = 0, cash1000 = 0; //鈔票

		// 補給零錢
		System.out.println("請輸入零錢總數:");
		System.out.print("1 元硬幣: ");
		coin1 = scanner.nextInt();
		System.out.print("5 元硬幣: ");
		coin5 = scanner.nextInt();
		System.out.print("10 元硬幣: ");
		coin10 = scanner.nextInt();
		// test
		// System.out.printf("機內零錢 剩餘 - 10元 : %d 個, 5元: %d 個, 1元: %d 個\n", coin10,
		// coin5, coin1);

		// Begin
		while (buyTicketNowSelect == true) {

			buyTicket = 0;
			while ((buyTicket < 1) || (buyTicket > 2)) {

				// if - 是否購票
				System.out.println("購票 1)是 2)否");
				buyTicket = scanner.nextInt();

				// if - 防呆
				if ((buyTicket < 1) || (buyTicket > 2)) {
					System.out.println("輸入錯誤 請重新選擇！");
				}
			}
			// if - 取消購票
			if (buyTicket == 2) {
				System.out.println("取消購票 !！");

				// set select status
				buyTicket = 0;
				buyTicketNowSelect = true;
				startStationNowSelect = false;
				stopStationNowSelect = false;
				ticketNumNowSelect = false;
				ticketAllAlready = true;

			} else {
				// set select status
				buyTicketNowSelect = false;
				startStationNowSelect = true;
				stopStationNowSelect = false;
				ticketNumNowSelect = false;
				ticketAllAlready = false;

			}
			// while out - buyTicket is ok
			// set select status

			// }

			// //set select status
			// startStationNowSelect = true;
			// stopStationNowSelect = false;
			// ticketNumNowSelect = false;

			// 開始購票
			while (ticketAllAlready == false) {
				System.out.println("開始購票！");

				// if - 選擇起站
				if (startStationNowSelect == true) {
					// while - 防呆
					startStation = 0;
					while ((startStation < 1) || (startStation > 4)) {
						// 選擇起站
						System.out.print("\n選擇 '起站'： 1)台北 2)台中 3)高雄 4)取消: ");
						startStation = scanner.nextInt();

						// if - 防呆
						if ((startStation < 1) || (startStation > 4)) {
							System.out.println("輸入錯誤 請重新選擇！");
						}

						// if - 選擇站名
						if ((startStation > 0) && (startStation < 4)) {
							// set select status
							startStationNowSelect = false;
							stopStationNowSelect = true;
							ticketNumNowSelect = false;
						}

					}
					// while out - startStation is ok
					// if - 4) 取消
					if (startStation == 4) {
						System.out.println("取消購票！");
						// set select status
						buyTicket = 0;
						buyTicketNowSelect = true;
						startStationNowSelect = false;
						stopStationNowSelect = false;
						ticketNumNowSelect = false;
						ticketAllAlready = true;
					}
				}

				// if - 選擇訖站
				if (stopStationNowSelect == true) {

					// while - 防呆
					stopStation = 0;
					while ((stopStation < 1) || (stopStation > 5)) {

						System.out.print("\n選擇訖站：1)台北 2)台中 3)高雄 4)回上一步 5)取消: ");
						stopStation = scanner.nextInt();

						// if - 5) 取消
						// if(stopStation == 5) {
						// System.out.println("取消購票！");
						// System.exit(0); //Exit program
						// }

						// if - 4) 回上一步
						if (stopStation == 4) {
							System.out.println("回上一步！");

							// set select status
							startStationNowSelect = true;
							stopStationNowSelect = false;
							ticketNumNowSelect = false;
						}

						// if - 防呆
						if ((stopStation < 1) || (stopStation > 5) || (stopStation == startStation)) {
							System.out.println("輸入錯誤 請重新選擇！");
						}

						// if - 選擇站名
						if ((stopStation > 0) && (stopStation < 4) && (stopStation != startStation)) {
							// set select status
							startStationNowSelect = false;
							stopStationNowSelect = false;
							ticketNumNowSelect = true;
						}

					}
					// while out - stopStation is ok
					// if - 5) 取消
					if (stopStation == 5) {
						System.out.println("取消購票！");
						// set select status
						buyTicket = 0;
						buyTicketNowSelect = true;
						startStationNowSelect = false;
						stopStationNowSelect = false;
						ticketNumNowSelect = false;
						ticketAllAlready = true;
					}
				}

				// if - 選擇張數
				if (ticketNumNowSelect == true) {

					// while - 防呆
					ticketNum = 0;
					while ((ticketNum < 1) || (ticketNum > 5)) {
						System.out.print("\n選擇張數：1) 1 張 2) 2 張 3) 3 張 4)回上一步 5)取消: ");
						ticketNum = scanner.nextInt();

						// //if - 5) 取消
						// if(ticketNum == 5) {
						// System.out.println("取消購票！");
						// System.exit(0); //Exit program
						// }

						// if - 4) 回上一步
						if (ticketNum == 4) {
							System.out.println("回上一步！");

							// set select status
							startStationNowSelect = false;
							stopStationNowSelect = true;
							ticketNumNowSelect = false;
						}

						// if - 防呆
						if ((ticketNum < 1) || (ticketNum > 5)) {
							System.out.println("輸入錯誤 請重新選擇！");
						}

						// if - 選擇張數
						if ((ticketNum > 0) && (ticketNum < 4)) {
							// set select status
							startStationNowSelect = false;
							stopStationNowSelect = false;
							ticketNumNowSelect = false;
							// ticket info is ok
							ticketAllAlready = true;
						}
					}
					// while out - ticketNum is ok
					// if - 5) 取消
					if (ticketNum == 5) {
						System.out.println("取消購票！");
						// set select status
						buyTicket = 0;
						buyTicketNowSelect = true;
						startStationNowSelect = false;
						stopStationNowSelect = false;
						ticketNumNowSelect = false;
						ticketAllAlready = true;

					}
				}
			}
			// while out - 票務選擇結束

			// 顯示票價
			if ((ticketAllAlready == true) && !(buyTicketNowSelect == true)) {
				System.out.println("顯示票價資訊.");

				// 列印 票根資訊
				System.out.print("搭乘 ");
				// switch - print 起站
				switch (startStation) {
				case 1:
					System.out.print("台北到");
					break;

				case 2:
					System.out.print("台中到");
					break;

				case 3:
					System.out.print("高雄到");
					break;
				default:
					System.out.print("--非預期結果--");
				}

				// switch - print 訖站
				switch (stopStation) {
				case 1:
					System.out.print("台北列車，");
					break;

				case 2:
					System.out.print("台中列車，");
					break;

				case 3:
					System.out.print("高雄列車，");
					break;
				default:
					System.out.print("--非預期結果--");
				}

				stationDistance = startStation - stopStation;
				int ticketPriceforOne = 0;
				// if - 確認 單張票價
				if ((stationDistance == 1) || (stationDistance == -1)) {
					ticketPriceforOne = 536;
				}

				if ((stationDistance == 2) || (stationDistance == -2)) {
					ticketPriceforOne = 927;
				}

				if (stationDistance == 0) {
					ticketPriceforOne = 0;
					System.out.println("--非預期結果--");

				}

				System.out.printf("座位共 %d 張，票價 %d 元。\n", ticketNum, ticketPriceforOne * ticketNum);

				// 準備付錢
				int needToPay = ticketPriceforOne * ticketNum;

				// set while 條件 - alreadyPay initial
				int alreadyPay = 0;
				while (alreadyPay < needToPay) {

					// set while 條件 - selectToPay initial
					int selectToPay = 0;
					while ((selectToPay < 1) || (selectToPay > 4)) {
						System.out.println("請投入現金： 1) 50元 2) 100元 3) 500元4) 1000元 5)取消");
						selectToPay = scanner.nextInt();

						// if - 5) 取消
						if (selectToPay == 5) {
							System.out.println("取消購票！ 退回您 " + alreadyPay + " 元");
							alreadyPay = 0;
							break;
						}

						// switch - 單次投入金額
						switch (selectToPay) {
						case 1:
							alreadyPay += 50;
							break;

						case 2:
							alreadyPay += 100;
							break;

						case 3:
							alreadyPay += 500;
							break;
						case 4:
							alreadyPay += 1000;
							break;
						default:
							System.out.println("--非預期結果--");
						}

					}
					// if - 5) 取消
					if (selectToPay == 5) {
						// System.out.println("取消購票！ 退回您 "+ alreadyPay + " 元");
						// alreadyPay = 0;
						buyTicketNowSelect = true;
						break;
					}
					// while out - selectToPay is identify
					System.out.println("Now Already Pay: " + alreadyPay + " 元");

				}
				// while out - 投入金額 足夠 alreadyPay >= needToPay
				if (alreadyPay >= needToPay) {
					// 找錢
					int giveCharge = (alreadyPay - needToPay);

					// 需找零錢
					int needCoin10 = 0, needCoin5 = 0, needCoin1 = 0;
					System.out.println("找您" + giveCharge + " 元");
					// 10元
					needCoin10 = giveCharge / 10;
					if (needCoin10 > coin10) {
						needCoin10 = coin10;
					}
					giveCharge -= needCoin10 * 10;
					// 5元
					needCoin5 = giveCharge / 5;
					if (needCoin5 > coin5) {
						needCoin5 = coin5;
					}
					giveCharge -= needCoin5 * 5;
					// 1元
					needCoin1 = giveCharge;

					// 零錢是否足夠
					boolean changeEnough = ((coin10 >= needCoin10) && (coin5 >= needCoin5) && (coin1 >= needCoin1));
					if (changeEnough) {
						System.out.printf("退還 - 10元 : %d 個, 5元: %d 個, 1元: %d 個\n", needCoin10, needCoin5, needCoin1);

						// End - 結束購票
						System.out.println("-- 感謝購買 --");
						buyTicketNowSelect = true;

						coin10 -= needCoin10;
						coin5 -= needCoin5;
						coin1 -= needCoin1;

						// coin50 = 0; //零錢
						// cash100 = 0, cash500 = 0, cash1000 = 0; //鈔票

					} else {
						System.out.println("機台內現金不足, 無法找零, 請洽工作人員\n" + "  -- 故障中 --  \n" + " -  請稍後再試  - \n");

					}

					// test
					System.out.printf("機內零錢 剩餘 - 10元 : %d 個, 5元: %d 個, 1元: %d 個\n", coin10, coin5, coin1);
					// 結束本次購買
				}
			}
		}
		// while out - ### Never ###

		// Recycle the resources - scanner
		scanner.close();
	}
}
