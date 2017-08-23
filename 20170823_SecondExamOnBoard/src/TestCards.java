//2017/08/23 第二次評測上機考
//上機考注意事項：
//上機考時間從下午13:30至16:30為止。
//上機考為open book；可攜帶紙本並參考電腦中的投影片，13:30至13:40間可下載相關參考資料，爾後請關閉瀏覽器與其他具通訊功能之應用程式，並將手機等通訊設備自行收入包包中；如經監考人員發現成績以0分計算。
//如非監考人員協助複製檔案之用，否則禁止攜帶隨身碟；違者成績以0分計算。
//考試中禁止交談與討論；上廁所請先舉手請示監考人員。
//考試完畢請先舉手告知監考人員，確認檔案無誤後便可開啟網頁登入教學平台上傳程式碼。
//每位同學最多可向助教求助三次；對題目有問題者，請在題目解說時盡量向監考人員發問。
//上機考只要是以程式能執行的基礎上進行部分給分，因此請維持程式可正常編譯執行，並盡力完成，逐步撰寫每一項功能。
//
//請設計一個卡牌遊戲「剪刀石頭布」。規則如下：一副牌組共有30張，每一張牌都有分配一個花色和生命點數，花色分為剪刀、石頭、布三種，點數1到10。換言之，同一種花色會有十張牌，從1點到10點。比賽的時候先將牌組洗牌，洗完後，每一回合發給電腦與玩家各五張手牌，玩家可以在亮牌前調動卡片順序。調整完後雙方在同時亮牌，根據手牌的順序逐一比對花色，再由花色決定勝負，勝方牌可得負方牌的生命點數。例如，電腦亮出的手牌假設為（剪刀10、石頭7、布1、剪刀3、布5），而玩家的手牌假設為（剪刀1、布2、石頭3、剪刀2、石頭6），則該回合勝負情形如下：
//
//
//此回合電腦累積9點，玩家累積7點。
//
//共進行三個回合，最後電腦與玩家以累積的生命點數判定輸贏。
//
//請設計一個名為Card的類別代表一張牌的資料，請實作當中的成員變數與方法。
//請設計一個名為Cards的類別代表牌組；參考範例如下：
//class Cards{
//	//宣告Card陣列以及相關屬性、方法與建構子，使其得以實現下列方法
//	void newCards(){} //產生一副新牌
//	public void shuffle(); //進行洗牌
//	public Card deal(); //抽出一張牌
//};
//建立一TestCards之類別，來測試並完成這個遊戲，執行範例如下：
//開始遊戲 (y/n)? y
//開始洗牌…
//進行第1回合:
//電腦得5張手牌，玩家得5張手牌。
//你的牌為：
//剪刀 1, 布 2, 石頭 3, 剪刀 2, 石頭 6
//
//你的選擇? 1)調整手牌順序, 2)亮牌: 1
//輸入你要交換的兩張牌（牌的編號為0到4）: 1 4
//你的牌為：
//剪刀 1, 石頭 6, 石頭 3, 剪刀 2, 布 2
//
//你的選擇? 1)調整手牌順序, 2)亮牌: 2
//電腦	   玩家
//剪刀10	-> 剪刀 1	平手
//石頭 7	-> 石頭 6	平手
//布   1	-> 石頭 3	電腦勝，得3點
//剪刀 3	-> 剪刀 2	平手
//布   5	-> 布   2	平手
//
//電腦得到3點，你得到0點
//
//進行第2回合:
//…
//電腦得到10點，你得到12點
//
//進行第3回合:
//…
//電腦得到23點，你得到24點
//
//你獲勝了！
//
//再玩一次(y/n)?
//
//如果使用者選擇再玩一次，則雙方所得的生命點數要歸零。如果不要再玩，則直接結束程式。
//
//你可以修改題目所提供的參考範例或自訂類別與其中的成員，你的程式必須遵循以下原則：
//你的專案必須至少要有兩個以上的類別
//你所定義的類別必須要被宣告成物件使用
//你的設計必須符合物件導向設計的封裝性
//遊戲過程如果發生錯誤情況，請驗證判斷。
//請將不同的類別放入不同的檔案，繳交考試結果時，請將專案中所有的程式檔放到一個目錄夾中壓縮起來上傳
import java.lang.*;
import java.util.*;
public class TestCards {

	// static
	public static Scanner sc = new Scanner(System.in);
	public static Cards cardLot = new Cards();
	public static Card[] comSet = new Card[5];
	public static Card[] plSet = new Card[5];
	public static int comP = 0;
	public static int plP = 0;

	public static void main(String[] args) {

		//		test();
		mainCoide();

	}
	// function
	public static void mainCoide() {
		// 第一次開始遊戲
		startGame(true);
		do {
			//開始洗牌…
			initPointAndCardLotPlay();
			//進行第 _ 回合:
			for(int round = 0; round < 3; round ++) {
				System.out.println("#########################");
				System.out.println("進行第" + round + "回合: ");
				System.out.println("#########################");
				newRoundDeal();
				// 告知玩家 本次 手牌
				showSet(plSet);
				// 調整順序？
				changeIndex();
				// 亮牌 比較
				fightCard();
			}
			// 三局打完, 比較點數
			System.out.println("三局打完, 比較點數");
			System.out.printf("累計點數 com %2dp, pl %2dp\n", comP, plP);
			int wl = comP - plP;
			if(wl == 0) {
				System.out.println("平手");
			}
			if(wl > 0) {
				System.out.println("電腦勝！！");
			}
			if(wl < 0) {
				System.out.println("玩家勝！！");
			}
			// 再玩一次？
			startGame(false);
		} while(true);
	}
	public static void startGame(boolean first) {
		do {
			if(first)
				System.out.print("\n 開始遊戲？ ");
			else
				System.out.print("\n 在玩一次？ ");

			String yn = sc.next();
			if(yn.charAt(0) == 'y') {
				return ;
			} else if(yn.charAt(0) == 'n') {
				System.out.println("Bye.");
				System.exit(0);
			} else {
				System.out.println("Input Error.");
			}
		} while(true);
	}
	public static void initPointAndCardLotPlay() {
		comP = 0;
		plP = 0;		
		System.out.println("開始洗牌...");
		cardLot.newCards();
		cardLot.shuffle();
		return;
	}
	public static void newRoundDeal() {	
		// deal to computer
		for(int i = 0; i < 5; i++) 
			comSet[i] = cardLot.deal();
		// deal to player
		for(int i = 0; i < 5; i++) 
			plSet[i] = cardLot.deal();
	}
	public static void changeIndex() {
		do {
			System.out.println("你的選擇? 1)調整手牌順序, 2)亮牌: ");
			int option = sc.nextInt();
			switch(option) {
			case 2:
				return;
			case 1:
				System.out.println("輸入你要交換的兩張牌（牌的編號為0到4）:");
				int s = sc.nextInt();
				int d = sc.nextInt();
				if(s >= 0 && s <= 4) {
					if(d >= 0 && d <= 4) {
						Card tempC = plSet[s];
						plSet[s] = plSet[d];
						plSet[d] = tempC;		
						System.out.println("你的牌為：");
						showSet(plSet);
						break;
					}
				}
				// no break, let it default
			default:
				System.out.println("Input Error.");
			}		
		} while(true);
	}
	public static void showSet(Card[] set) {
		for(int i = 0; i < 5; i++) {
			set[i].outputCardData();	
			System.out.print(", ");
		}
		System.out.println("");
		return ;
	}
	public static void fightCard() {
		//電腦	   玩家
		System.out.println("---------------------------------------");
		System.out.println("  電腦      玩家\t勝負");
		System.out.println("---------------------------------------");
		//剪刀10	-> 剪刀 1	平手
		//石頭 7	-> 石頭 6	平手
		//布   1	-> 石頭 3	電腦勝，得3點
		//剪刀 3	-> 剪刀 2	平手
		//布   5	-> 布   2	平手
		int comRoundPoint = 0;
		int plRoundPoint = 0;
		for(int i = 0; i < 5; i++) {
			comSet[i].outputCardData();
			System.out.print(" -> ");
			plSet[i].outputCardData();
			System.out.print("\t");
			switch(comSet[i].getColorNum()) {
			case 0:	// 電腦 剪刀
				if(plSet[i].getColorNum() == 0) {	// 
					System.out.println("平手");
				} 
				if(plSet[i].getColorNum() == 1) {
					int getP = comSet[i].getPointNum();
					System.out.println("玩家勝, 得" + getP + "點");
					plP += getP;
					plRoundPoint += getP;

				}
				if(plSet[i].getColorNum() == 2) {
					int getP = plSet[i].getPointNum();
					System.out.println("電腦勝, 得" + getP + "點");
					comP += getP;
					comRoundPoint += getP;
				}
				break;
			case 1: // 電腦 石頭
				if(plSet[i].getColorNum() == 0) {	// 
					int getP = plSet[i].getPointNum();
					System.out.println("電腦勝, 得" + getP + "點");
					comP += getP;
					comRoundPoint += getP;
				} 
				if(plSet[i].getColorNum() == 1) {
					System.out.println("平手");
				}
				if(plSet[i].getColorNum() == 2) {
					int getP = comSet[i].getPointNum();
					System.out.println("玩家勝, 得" + getP + "點");
					plP += getP;
					plRoundPoint += getP;
				}
				break;
			case 2: // 電腦 布
				if(plSet[i].getColorNum() == 0) {	// 
					int getP = comSet[i].getPointNum();
					System.out.println("玩家勝, 得" + getP + "點");
					plP += getP;
					plRoundPoint += getP;
				} 
				if(plSet[i].getColorNum() == 1) {
					int getP = plSet[i].getPointNum();
					System.out.println("電腦勝, 得" + getP + "點");
					comP += getP;
					comRoundPoint += getP;
				}
				if(plSet[i].getColorNum() == 2) {
					System.out.println("平手");
				}
				break;
			default:
				System.out.println("comSet[" + i + "] colorNum Error.");
			}

		}
		System.out.printf("本回合 點數 電腦得 %2dp, 玩家得 %2dp\n", comRoundPoint, plRoundPoint);
		return ;
	}


	public static void test() {

		// test Card
		for(int i = 0; i < 30; i++) {
			Card testC = new Card(i);
			//			System.out.printf("getter: c%2d, p%2d\n", testC.getColorNum(), testC.getPointNum());
			testC.outputCardData();
			System.out.println("");
		}
		System.out.println("----------------------------------------------------------------------------------------");
		// test Cards
		Cards testCs = new Cards();
		testCs.shuffle();
		for(int i = 0; i < 40; i++) {
			Card tc2 = testCs.deal();
			if(tc2 != null) {
				System.out.print( i + 1 );
				tc2.outputCardData();
				System.out.println();
			} else {
				System.out.println("發完了 !!");
				break;
			}

		}
		System.out.println("----------------------------------------------------------------------------------------");




		return ;
	}
	// last {
}
