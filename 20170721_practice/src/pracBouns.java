
//題目
//請使用Math.random()產生隨機亂數，並嘗試撰寫程式與電腦進行「數字拳」的遊戲。
//
//規則：先決定喊拳語的玩家，再來用兩隻手出拳（石頭或布），拳語為5、10、15、20，或沒有，代表出拳的手指數目。喊拳語者如猜中正確數目，必須再喊一次，再一次猜對者就算贏。
//請實作以下副函式，並在主函式或副函式中呼叫：
//
//
//執行範例如下（粗體字表使用者輸入的部分）： 
//隨機決定先後：玩家先。
//======遊戲開始======
//出拳（左手/右手）： 5 0
//拳語：10
//電腦: 0 0 
//玩家: 5 0 10
//總數: 5
//下一回合
//
//出拳（左手/右手）： 5 0
//電腦: 5 0 10
//玩家: 0 5 
//電腦聽牌
//
//出拳（數目/拳語）：0 0
//電腦: 5 5 10
//玩家: 0 0
//總數: 10 
//電腦獲勝！
//
//請問是否繼續 (Y/N)？ N
//遊戲結束。

import java.util.Scanner;

public class pracBouns {

	public static void main(String[] args) {

		// Declare, Initial
		Scanner scanner = new Scanner(System.in);
		boolean restartGame;
		int computerWinRound = 0, playerWinRound = 0;
		int firstHand = 0;

		// Begin
		do {
			// reset win round
			computerWinRound = 0;
			playerWinRound = 0;
			// reset first hand
			firstHand = 0;

			// 開始訊息
			System.out.println(" --- 數字拳 --- ");
			// 說明遊戲
			System.out.println("當遊戲開始, 將隨機選出 先喊 '拳語' 的玩家並指示,");
			System.out.println("兩隻手出拳，拳語為5、10、15、20，或 0，代表出拳的手指數目。");
			System.out.println("		 -- Demo --		");
			System.out.println("請輸入 出拳（左手/右手）： 5 0");
			System.out.println("請輸入 拳語 ： 10");
			System.out.println("電腦: 0 0 \n" + "玩家: 5 0 10\n" + "總數: 5\n" + "  ---- 下一回合 ----");
			System.out.println("喊拳語者如猜中正確數目, 得 '一勝！！' ");
			System.out.println("再一次猜對者就算贏");

			// 決定先手
			firstHand = 0; // initial Random for : restart Game
			if (firstHand == 0) {
				firstHand = (int) (Math.random() * 2 + 1);
				if (firstHand == 1) {
					System.out.println("隨機決定先後：		玩家		先手。");

				} else if (firstHand == 2) {
					System.out.println("隨機決定先後：		電腦		先手。");

				} else {
					System.out.println(" Error --> 隨機決定");
				}
			}
			// 遊戲開始
			System.out.println("======遊戲開始======");

			do {
				// 流程 - 玩家先手
				if (firstHand == 1) {
					int playerLeftNum = -1;
					int playerRightNum = -1;
					int punchNum = -1;
					int sum = -1;
					int computerLeftNum = -1;
					int computerRightNum = -1;

					do {
						System.out.println("(玩家先手) 請輸入 出拳（ 左手 / 右手 ）： ");
						playerLeftNum = scanner.nextInt();
						playerRightNum = scanner.nextInt();

						// test
						// System.out.println("leftNum =" + playerLeftNum + ", != 0? " + (playerLeftNum
						// != 0) + ", %5 != 0? " + (playerLeftNum % 5 != 0) );
						// System.out.println("punchNum =" + playerRightNum + ", != 0? " +
						// (playerRightNum != 0) + ", %5 != 0? " + (playerRightNum % 5 != 0) );

						// 只接受 0, 5, 10,
					} while ((playerLeftNum % 5 != 0) || (playerRightNum % 5 != 0)
							|| (playerLeftNum + playerRightNum > 10) || (playerLeftNum > 5) || (playerRightNum > 5));

					// test
					System.out.println(" -- 出拳 -- 正確！！");

					do {
						System.out.println("請輸入 拳語 ： ");
						punchNum = scanner.nextInt();

						// test
						// System.out.println("punchNum =" + punchNum + ", != 0? " + (punchNum != 0) +
						// ", %5 != 0? " + (punchNum % 5 != 0) );

					} while ((punchNum % 5 != 0) || (punchNum > 20));
					// test
					System.out.println(" -- 拳語 -- 輸入正確！！");

					// 電腦隨機數字
					computerLeftNum = ((int) (Math.random() * 2)) * 5;
					computerRightNum = ((int) (Math.random() * 2)) * 5;

					// test
					System.out.println("電腦: " + computerLeftNum + " " + computerRightNum);

					sum = computerLeftNum + computerRightNum + playerLeftNum + playerRightNum;
					System.out.println("總數 = " + sum);

					// test
					// computerWinRound = 2;
					playerWinRound = 2;

					if (sum == punchNum) {
						playerWinRound += 1;
						System.out.println("你贏了一場！！");
					}
					if ((computerWinRound < 2) && (playerWinRound < 2)) {
						System.out.println("下一回合");
						firstHand = 2;// 攻守交換
					}
					if ((computerWinRound >= 2) || (playerWinRound >= 2)) {
						firstHand = 0; // 離開本局
					}
				}

				// test
				// computerWinRound = 2;
				playerWinRound = 2;

				// 流程 - 電腦先手流程
				if (firstHand == 2) {
					int playerLeftNum = -1;
					int playerRightNum = -1;
					int punchNum = -1;
					int sum = -1;
					int computerLeftNum = -1;
					int computerRightNum = -1;

					do {
						System.out.println("(電腦先手) 請輸入 出拳（ 左手 / 右手 ）： ");
						playerLeftNum = scanner.nextInt();
						playerRightNum = scanner.nextInt();

						// test
						// System.out.println("leftNum =" + playerLeftNum + ", != 0? " + (playerLeftNum
						// != 0) + ", %5 != 0? " + (playerLeftNum % 5 != 0) );
						// System.out.println("punchNum =" + playerRightNum + ", != 0? " +
						// (playerRightNum != 0) + ", %5 != 0? " + (playerRightNum % 5 != 0) );

						// 只接受 0, 5, 10
					} while ((playerLeftNum % 5 != 0) || (playerRightNum % 5 != 0)
							|| (playerLeftNum + playerRightNum > 10) || (playerLeftNum > 5) || (playerRightNum > 5));

					// test
					System.out.println(" -- 出拳 -- 正確！！");

					// 電腦隨機數字
					computerLeftNum = ((int) (Math.random() * 2)) * 5;
					computerRightNum = ((int) (Math.random() * 2)) * 5;

					// test
					// computerLeftNum = 5;
					// computerRightNum = 0;

					// test
					System.out.print("電腦: " + computerLeftNum + " " + computerRightNum);
					sum = computerLeftNum + computerRightNum + playerLeftNum + playerRightNum;

					int randomMul = 0, randomAdj = 0; // 隨機 基數
					int computerLRNum = computerLeftNum + computerRightNum; // 電腦左右手總數
					switch (computerLRNum / 5) {
					case 0:
						randomMul = 5;
						randomAdj = 0;
						break;
					case 1:
						randomMul = 4;
						randomAdj = 1;
						break;
					case 2:
						randomMul = 3;
						randomAdj = 2;
						break;
					default:
						break;

					}

					System.out.println("computerLRNum = " + computerLRNum + "randomMul = " + randomMul + "randomAdj ="
							+ randomAdj);
					punchNum = ((int) (Math.random() * randomMul) + randomAdj) * 5;
					System.out.println("    電腦猜 : " + punchNum);
					System.out.println("總數 = " + sum);

					// if - 是否結算
					if (sum == punchNum) {
						computerWinRound += 1;
						System.out.println("你輸了一局.. ");
					}
					if ((computerWinRound < 2) && (playerWinRound < 2)) {
						System.out.println("下一回合");

						firstHand = 1;// 攻守交換
					}
					if ((computerWinRound >= 2) || (playerWinRound >= 2)) {
						firstHand = 0; // 離開本局
					}

				}

				// test
				// computerWinRound = 2;
				// playerWinRound = 2;

			} while ((computerWinRound < 2) && (playerWinRound < 2));

			// 效果
			for (int i = 0; i < 3; i += 1) {
				for (int j = 0; j < 15; j += 1) {
					System.out.print("#");
				}
				System.out.print("\n");
			}
			// 誰贏??
			if (computerWinRound >= 2) {
				for (int i = 0; i < 3; i += 1) {
					for (int j = 0; j < 15; j += 1) {
						System.out.print("#");
					}
					System.out.print("\n");
				}

				System.out.println("電腦贏了！！");
			} else {

				System.out.println("恭喜你 贏了！！");
			}
			// 效果
			for (int i = 0; i < 3; i += 1) {
				for (int j = 0; j < 15; j += 1) {
					System.out.print("#");
				}
				System.out.print("\n");
			}

			// 詢問是否重新開始遊戲
			// set status
			restartGame = false;
			String yesOrNo; // 接收
			String optionYes = "Y", optionNo = "N";
			boolean reEnter = false;

			do {
				System.out.println("請問是否繼續 (Y/N)？");
				yesOrNo = scanner.next();
				System.out.printf("your input is %s \n", yesOrNo);

				if (yesOrNo.equals(optionYes)) {
					restartGame = true;
					reEnter = false;

				} else if (yesOrNo.equals(optionNo)) {
					restartGame = false;
					reEnter = false;

				} else {
					reEnter = true;
					System.out.println("輸入錯誤, 請重新輸入. -- 注意大小寫 --");

				}

			} while (reEnter);

		} while (restartGame);

		// End
		System.out.println("The game is over.");

		// Recycle
		scanner.close();

	}

}
