import java.util.Scanner;
import java.util.Random;

public class practiceOnClass {

	public static void main(String[] args) {
		//on class practice
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();	// No resource leak
		
		System.out.println("random.nextInt(100) = " + (random.nextInt(100)+1));
		//這邊要+1是因為原本範圍為0~99 有100個變數
        //+1之後變成1~100
		
		//---test
		System.out.println("random.nextInt(1) = " + random.nextDouble());

		
        System.out.print("(int) Math.random()*100+1 = " + (int)(Math.random()*100+1) + " \n");  
        //不需要import
      	//Math 類別在 java.lang.Math
        	//Math.random()*41+1得到的是一個1~42的double值(含有小數)
        
        //---test
        System.out.print("no(int) Math.random()*1+1 = " + (Math.random()*1) + " \n");  


        // Demo Random
//
//		輸入 '十個整數' 代表 成績資料，輸入的數字必須介於 '0與100' 之間，
//		如果輸入時發現數字在規定的範圍以外，則需印出錯誤訊息且不可計入總和之中，
//		累計 '十筆' 合法的資料才能 '結束輸入' 並計算這十筆資料的 '總和及平均'。
//		請繪製流程圖與撰寫演算法，並實作程式。
//		
		//Declare, Initialize
//		Scanner scanner = new Scanner(System.in); //already declare.
        int score = 0, total = 0;
		int count = 0; 
		boolean redo;
		
		//提示使用者輸入
		System.out.println("請輸入十個成績: ");
		
		//10次 輸入
		while(count <= 10) {
			
			redo = true;	//enable while
			while(redo) {
				//輸入成績
//				score = scanner.nextInt();
				//隨機輸入成績
				score = (int)(Math.random()*100+1);
				
				// 顯示 輸入的成績
				System.out.print("Score is " + score + "; ");
		
				//判斷 成績輸入 是否正確
				if( (score < 0) || (score > 100) ) {
					System.out.println("輸入值不合法, 請重新輸入成績: ");
					redo = true;
				} else {
				redo = false;
				}
			}
		
		total += score;
		System.out.println("now count:" + count +" total = " + total);
		
		count += 1;	
		}
		
		// 次數 : 成績
		System.out.println("is End, count:"+ count + "\n total score is " + total);
		
		//Average
  		System.out.printf("and Average is %.2f \n", ( (double) total / (double) (count -1) ));
  		
  		//結果相同 
//  		System.out.printf("and Average is %.2f \n", ( (double) total /  (count -1) ));
//  		System.out.printf("and Average is %.2f \n", (  total / (double) (count -1) ));
  		
  		//Error!! 會沒有 小數部分, cause 先運算 完 才轉型
//  		System.out.printf("and Average is %.2f \n", (double) ( total / (count -1) ));
  		
		//Recycle the resources - scanner
				scanner.close();
	}
}
