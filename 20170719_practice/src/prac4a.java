import java.util.Scanner;

public class prac4a {

	public static void main(String[] args) {
//
//		輸入 '十個整數' 代表 成績資料，輸入的數字必須介於 '0與100' 之間，
//		如果輸入時發現數字在規定的範圍以外，則需印出錯誤訊息且不可計入總和之中，
//		累計 '十筆' 合法的資料才能 '結束輸入' 並計算這十筆資料的 '總和及平均'。
//		請繪製流程圖與撰寫演算法，並實作程式。
//		
		//Declare, Initialize
		Scanner scanner = new Scanner(System.in);
		int score = 0, total = 0;
		int count = 0; 
		
		//提示使用者輸入
		System.out.println("請輸入十個成績: ");
		
		//10次 輸入
		while(count <= 10) {
				//輸入成績
				score = scanner.nextInt();
				//隨機輸入成績
//				score = (int)(Math.random()*100+1);
				System.out.print("Score is " + score + "; ");
		
				//判斷 成績輸入 是否正確
				if( (score < 0) || (score > 100) ) {
					System.out.println("輸入值不合法, 請重新輸入成績: ");
					
				} else {
					total += score;
					System.out.println("now count:" + count +" total = " + total);
					count += 1;		
					
				}	
			}
		
		// 次數 : 成績
		System.out.println("is End, count:"+ count + "\n total score is " + total);
		
		//Average
  		System.out.printf("and Average is %.2f \n", ( (double) total / (double) (count -1) ));
  		
		//Recycle the resources - scanner
				scanner.close();		
	}
}
