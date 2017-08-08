
//紙牌遊戲Blackjack
//
//Blackjack是一種撲克牌遊戲（花色為方塊（Diamond）、紅心（Heart）、黑桃（Spade）、梅花（Club）），目標是計算手中的牌值，並企圖累加至21點。
//參與的人分莊家(dealer)與玩家(player)。首先洗完牌後，莊家先由自己開始，各發給自己與玩家兩張牌。
//其中所有的花牌(Jack, King, Queen)皆可得10點；拿到Ace則可得到牌值11點或1點。
//例如，如果你得到一張Jack與Ace，則總點數即為21點，這樣就是所謂的blackjack，代表獲勝。
//
//在一開始發完兩張牌後，如果玩家的點數未超過21點，他可以向莊家拿牌(hit)，或選擇停牌(stay)停止。
//持有的牌值會繼續累加，直到得到blackjack為止；但如果總點數超過21點，就會爆牌(busted)，則表示玩家輸了遊戲。
//只要玩家停止叫牌，則回合便回到莊家。當莊家的牌總點數小於17時，他便必須持續為自己發牌。
//最後，莊家和玩家的牌值進行比較，越接近21點者獲勝。
//
//備註：
//1. 抽出的牌不能放回牌組中
//2. 玩家如果爆牌，即使莊家後來也爆牌，依舊判定莊家獲勝。
//3. 莊家和玩家的牌值如果相同，則表示打平(tie)。
//
//輸入範例如下（使用者輸入的部分以黑體標註）：
//
//Blackjack開始
//您的籌碼：1000
//
//投注：200
//洗牌完畢，開始發牌…
//莊家得2張牌
//玩家得2張牌：
//Diamond Ace, Heart 8
//Points: 19
//
//1) Hit. 2) Stay? 1
//Club 3, Diamond Ace, Heart 8
//Points: 12
//
//1) Hit. 2) Stay? 1
//Spade Ace, Club 3, Diamond Ace, Heart 8
//Points: 13
//
//1) Hit. 2) Stay? 1
//Heart 7, Spade Ace, Club 3, Diamond 1, Heart 8
//Points: 20
//
//1) Hit. 2) Stay? 2
//
//莊家回合
//莊家的牌組：
//Diamond Ace, Club 10 
//Points: 21 (Blackjack)
//莊家獲勝！
//您損失的200枚籌碼，您的籌碼剩 800 枚。
//
//是否再玩一次（1:是/2:否）？1
//
//投注：250
//洗牌完畢，開始發牌…
//莊家得2張牌
//玩家得2張牌：
//Spade King, Heart 2
//Points: 14
//
//1) Hit. 2) Stay? 1
//Diamond 5, Spade King, Heart 2
//Points: 19
//
//1) Hit. 2) Stay? 2
//
//莊家回合
//莊家的牌組：
//Club 10, Spade 6, Spade King 
//Points: 28 (Busted)
//玩家獲勝！
//您獲得的250枚籌碼，您的籌碼剩 1050 枚。
//
//是否再玩一次（1:是/2:否）？1
//
//投注：250
//洗牌完畢，開始發牌…
//莊家得2張牌
//玩家得2張牌：
//Spade Ace, Heart 10
//Points: 21 (Blackjack) 
//玩家獲勝！
//您獲得的250枚籌碼，您的籌碼剩 1300 枚。
//
//是否再玩一次（1:是/2:否）？2
//
//感謝您的遊玩，再見！
import java.util.Arrays;
import java.util.Scanner;

public class prac3kCh6BlackJack {

	// static
	public static Scanner scanner = new Scanner(System.in);
	public static int[] pokerOriginal = new int[52];
	public static int[] pokerPool = new int[52];
	// 手牌最多 不超過 9 張,
	// 2 x4 = 8
	// 3 x4 = 12 => 20點, + 一張A
	public static int[] playerInHand = new int[11];
	public static int[] dealerInHand = new int[11];
	public static int playChips = 0;
	public static int playerPoint = 0;
	public static int dealerPoint = 0;

	// - 花色, 牌面
	static String[] cardColor = { "Club", "Diamond", "Heart", "Spade" };
	static String[] cardNumber = { " A", " 2", " 3", " 4", " 5", " 6", " 7", " 8", " 9", "10", " J", " Q", " K" };

	public static void main(String[] args) {
		// declare
		int betting = 0;

		// init
		// - 一副新牌
		// - 玩家籌碼 set
		initial();

		// reStart point
		do {
			// 開始階段
			// - 手牌清空
			// - 分數重置
			stepToStart(true);
			// 洗牌
			shuffle(pokerPool);
			testPokerArray(pokerPool);

			// Black Jack
			// - 開頭
			System.out.println(" ################ ");
			System.out.println(" ## Black Jack ## ");
			System.out.println(" ################ ");
			// - print 玩家籌碼
			System.out.println("您的籌碼： " + playChips);

			// 下注
			// - 詢問投注

			do {
				System.out.print("投注 : ");
				betting = scanner.nextInt();
				if ((betting <= playChips) && (betting > 0)) {
					System.out.println("is Legal.");
					break;
				} else {
					System.out.println("is Illegal. re-input.");
				}
			} while (true);

			// 發牌
			System.out.println("發牌 =>");
			// - 發給莊家 2張牌
			toDeal(pokerPool, 0, 2);
			// - 發給玩家 2張牌
			toDeal(pokerPool, 1, 2);

			// 玩家回合
			System.out.println("---> 玩家回合 <---");
			System.out.println("玩家持有: ");
			testPokerArray(playerInHand);
			showPoint(playerInHand);
			longLine("---");

			do {
				System.out.print("1) Hit. 2) Stay? ");
				int option = scanner.nextInt();
				if (option == 1) {
					// - 發給玩家 1張牌
					toDeal(pokerPool, 1, 1);
					testPokerArray(playerInHand);
					playerPoint = showPoint(playerInHand);
					longLine("---");

					// 判斷 busted
					if (playerPoint > 21) {
						System.out.println("BOOM!!\nis Busted.");
						playerPoint = 0;
						break;
					}
				} else if (option == 2) {
					// - 玩家 停牌
					break;
				} else {
					System.out.println("--> illegal input <--");
				}
			} while (true);
			System.out.println("玩家回合 ： 結束");

			// 莊家回合
			System.out.println("---> 莊家回合 <---");
			System.out.println("莊家持有: ");
			testPokerArray(dealerInHand);
			showPoint(dealerInHand);
			longLine("---");

			do {
				int option = 1;
				if (dealerPoint >= 17) {
					option = 2;
				}
				if (option == 1) {
					// - 發給莊家 1張牌
					toDeal(pokerPool, 0, 1);
					dealerPoint = showPoint(dealerInHand);
					// 判斷 busted
					if (dealerPoint > 21) {
						System.out.println("BOOM!!\nis Busted.");
						dealerPoint = 0;
						break;
					}
				} else if (option == 2) {
					// - 莊家 停牌
					break;
				} else {
					System.out.println("--> illegal input <--");
				}

			} while (true);
			System.out.println("莊家回合 ： 結束");

			// 結算
			// 莊家的牌組：
			System.out.println("莊家牌組:");
			testPokerArray(dealerInHand);
			// 未爆牌
			if (dealerPoint != 0) {
				dealerPoint = showPoint(dealerInHand);
			}
			longLine("---");

			// test
			System.out.println("dealerPoint = " + dealerPoint);
			System.out.println("playerPoint = " + playerPoint);

			// - 決勝
			if (dealerPoint < playerPoint) {
				longLine("---");
				System.out.println("-#玩家#- 獲勝 !!");
				longLine("---");
				playChips += betting;
				System.out.println("您獲得" + betting + "枚籌碼, 您的籌碼剩" + playChips);
			} else {
				longLine("---");
				System.out.println("-#莊家#- 獲勝 !!");
				longLine("---");
				playChips -= betting;
				System.out.println("您損失" + betting + "枚籌碼, 您的籌碼剩" + playChips);
			}

			// 是否 重新開始
			// - 籌碼用完時
			if (playChips == 0) {
				System.out.println("籌碼 已用罄, 自動離場");
				// 遊戲離開
				System.exit(0);
			}
			do {
				System.out.println("是否再玩一次（1:是/2:否）？");
				int option = 0;
				option = scanner.nextInt();
				if (option == 1) {
					System.out.println("-- 遊戲即將重新開始 --");
					break;
				} else if (option == 2) {
					System.out.println("-- 遊戲結束 --");
					// 遊戲離開
					System.exit(0);
				} else {
					System.out.println("--> illegal input <--");
				}
			} while (true);

		} while (true); // 重新開始

		// 結束
	}

	// ################
	// function - 流程
	// ################

	// init
	// - 複製 新牌
	// - 玩家籌碼 set
	public static void initial() {
		// - 複製 新牌
		for (int i = 0; i < pokerOriginal.length; i++) {
			pokerOriginal[i] = i;
		}
		pokerPool = pokerOriginal.clone();
		// - 玩家籌碼 set
		do {
			System.out.print("\n 您帶了多少籌碼？");
			playChips = scanner.nextInt();
			if (playChips > 0) {
				break;
			}
		} while (true);
		return;
	}

	// 開始階段
	// boolean reMake
	// 產生牌組
	// True, 產生
	// False
	// - 手牌清空
	// - 分數重置
	public static void stepToStart(boolean reMake) {
		// 重新產生牌組
		if (reMake) {
			pokerPool = pokerOriginal.clone();
		}
		// - 手牌清空
		Arrays.fill(playerInHand, -1);
		Arrays.fill(dealerInHand, -1);
		// - 分數重置
		playerPoint = 0;
		dealerPoint = 0;
		return;
	}

	// - 洗牌
	// int[] pokerPool
	// 撲克池
	public static void shuffle(int[] pokerArray) {

		System.out.println("洗牌中...");
		// 洗牌
		for (int i = 0; i < 52; i++) {
			int index;
			index = (int) (Math.random() * 52);
			if (pokerArray[index] != -1) {
				if (pokerArray[i] != -1) {
					int temp;
					temp = pokerArray[i];
					pokerArray[i] = pokerArray[index];
					pokerArray[index] = temp;
				}
			}
		}
		// 洗牌完畢
		System.out.println("洗牌完畢,");
		return;
	}

	// - 發牌
	// int[] pokerPool, int picker, int quantity
	// 撲克池 得牌者 張數
	// 0, 莊家 dealer
	// 1, 玩家 player
	// #回傳 int
	// -1, pokerPool is Run out!!
	public static int toDeal(int[] pool, int picker, int quantity) {
		// 確認牌組 剩餘張數足夠
		if (pool.length < quantity) {
			return -1;
		}
		// 發牌
		// - 對象
		for (int i = 0; i < quantity; i++) {
			for (int j = 0; j < pool.length; j++) {
				int sendCard = 0;
				if (pool[j] != -1) {
					// 從 牌堆 拿出
					sendCard = pool[j];
					pool[j] = -1;

					System.out.print("發牌 to");
					if (picker == 1) {
						System.out.println(" 玩家...");
						for (int k = 0; k < playerInHand.length; k++) {
							if (playerInHand[k] == -1) {
								playerInHand[k] = sendCard;
								break; // 發入對的位置
							}
						}
						break; // 發完一張了
					} else {
						System.out.println(" 莊家...");
						for (int k = 0; k < dealerInHand.length; k++) {
							if (dealerInHand[k] == -1) {
								dealerInHand[k] = sendCard;
								break; // 發入對的位置
							}
						}
						break; // 發完一張了
					}
				}

			}
		}
		return 0;
	}

	// show 牌面
	public static void showColorAndNum(int cardNum) {
		System.out.printf("%8s%3s", cardColor[cardNum % 4], cardNumber[cardNum / 4]);
		return;
	}

	// show 點數
	public static int showPoint(int[] inHand) {
		int point = 0;
		boolean haveAce = false;

		for (int i = 0; i < inHand.length; i++) {
			// 非-1 才有值
			if (inHand[i] != -1) {

				// 一般情況
				if (inHand[i] / 4 > 9) {
					point += 10;
				} else {
					point += (inHand[i] / 4 + 1);
				}

				// 抽到 Ace
				if (inHand[i] / 4 == 0) {
					if (point < 10) {
						point += 10; // 額外 +10
						haveAce = true;
					}
				}
				if (haveAce && point > 21) {
					point -= 10;
					haveAce = false;
				}

			}
		}
		System.out.println(" - point = " + point);

		return point;
	}

	// - test poker array
	public static void testPokerArray(int[] array) {

		// test
		for (int i = 0; i < array.length; i++) {
			// 四項換行
			if (i % 4 == 0) {
				System.out.println("");
			}
			// 已經發走
			if (array[i] == -1) {
				System.out.printf("%8s%3s", "----", "--");
			} else {
				showColorAndNum(array[i]);
			}
		}
		System.out.println("");

		longLine("--");

		return;
	}

	// ################
	// function - 實用
	// ################
	// - 擴增陣列
	public static int[] appenIntArray(int[] array) {
		int[] arrayForCopy = new int[array.length * 2];
		Arrays.fill(arrayForCopy, -1);
		for (int i = 0; i < array.length; i++) {
			arrayForCopy[i] = array[i];
		}
		return arrayForCopy;
	}

	// - show array
	public static void showArray(int[] array) {
		System.out.print("arrray = { ");
		for (int i = 0; i < array.length; i++) {
			if (i == array.length - 1) {
				System.out.println(array[i] + " }");
			} else {
				System.out.print(array[i] + ", ");
			}
		}
		return;
	}

	// - 分隔線
	public static void longLine(String str) {
		for (int i = 0; i < 20; i++) {
			System.out.printf("%s", str);
		}
		System.out.println("");
	}

	// 1 - 循序搜尋法 - sequential search
	public static int sequential_Search(int list[], int keyValue) {
		for (int pos = 0; pos < list.length; pos++) {
			if (list[pos] == keyValue) {
				return pos; // 找到 的位置
			}
		}
		return -1; // 沒有找到
	}

	// 2 - 二分搜尋法 - binary search
	public static int binary_Search(int list[], int keyValue) {
		int left = 0, right = list.length - 1;
		int middle; // searching index, 搜尋中的索引值
		if (list[0] <= list[list.length - 1]) {
			while (left <= right) {
				middle = (left + right) / 2;
				if (keyValue == list[middle]) {
					return middle;
					// [ "0", 1, 2, 3, "4", 5, 6, 7, 8, "9"]
					// left middle right
				}
				// 沒找到,調整位置
				if (keyValue > list[middle]) {
					left = middle + 1;
					// [ "5", "6", 7, "8"]
					// left middle right
				} else {
					right = middle - 1;
					// [ "1", "2", "3", ]
					// left middle right
				}
			}
		} else {
			while (left <= right) {
				middle = (left + right) / 2;
				if (keyValue == list[middle]) {
					return middle;
				}
				// 沒找到,調整位置
				if (keyValue > list[middle]) {
					right = middle - 1;
				} else {
					left = middle + 1;
				}
			}
		}
		return -1; // 沒有找到
	}

	// 3 - 氣泡排序法 - bubble sort
	public static void bubble_Sort(int array[], boolean bigToSmall) {
		int temp = 0;
		for (int j = 0; j < array.length; j++) {
			for (int i = 0; i < array.length - j - 1; i++) {

				// big to small
				if ((array[i] > array[i + 1]) && bigToSmall) {
					temp = array[i];
					array[i] = array[i + 1];
					array[i + 1] = temp;
				}
				// small to big
				if ((array[i] < array[i + 1]) && !bigToSmall) {
					temp = array[i];
					array[i] = array[i + 1];
					array[i + 1] = temp;
				}
			}
		}
		return; // 離開
	}
	// last {
}
