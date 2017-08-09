//請觀看以下網頁了解河內塔的玩法規則
//
//https://zh.wikipedia.org/wiki/汉诺塔
//
//共有三根柱子，編號從1號到3號，柱子1號已經排好n個盤子，盤子從上到下依照尺寸由小到大排列，編號為1, 2, ..., n，你的目標是將所有的盤子移動到3號柱子上，但是你必須遵守以下規則：
//
//每次只能從 '最上面' 移動 '一個' 盤子
//任何 '盤子' 可以從 '任何柱子' 搬到 '其他柱子' 
// '小盤子' 永遠必須放在 '大盤子之上'
//請撰寫一個遞迴函式用來描述整個河內塔的移動過程。遞迴函式的函式原型如下：
//
//public static void towersOfHanoi(int no, int from, int to, int temp);
//參數代表要 '從柱子from' 移動 '編號no' 的 '盤子' 到 '柱子to' 去，同時以柱子 'temp作為中介' 
//只要有 '移動一個盤子 '，請印出以下訊息：
// 'Move 盤子編號 from 來源柱子編號 to 來源柱子編號' 
//
//請撰寫一個主函式要求使用者輸入一個數字n代表一開始要移動的盤子總數，並呼叫towersOfHanoi來印出搬移的過程。
import java.util.*;
public class prac6008 {

	public static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
		do{
			System.out.print("\n請輸入 '柱子一號' 有多少盤子 : ");
			int plateNum = scanner.nextInt();
			System.out.print("\n請輸入要 前往的 柱子 : ");
			int option = scanner.nextInt();
			if(option == 2) {
				printStatus( plateNum, 1, option, 3);
				towersOfHanoi( plateNum, 1, option, 3);
			} else if(option == 3) {
				printStatus( plateNum, 1, option, 2);
				towersOfHanoi( plateNum, 1, option, 2);
			} else {
				// re-input
				System.out.println("  ---------------------- ");
				System.out.println("||     Error input.     ||");
				System.out.println("  ---------------------- ");		
			}
		} while(true);

	}
	// function
	public static void towersOfHanoi(int no, int from, int to, int temp) {
		// base case
		if(no == 1) {
			// 移動 n號盤子 到 to
			System.out.println("移動 '盤子" + no + "' 到 '" + to + "號柱子' " );
			return;
		} 
		if(no > 1) {	
			// 移動 n-1 堆 盤子 從 from 放到 temp 
			towersOfHanoi( no - 1, from, temp, to) ;
			// 移動 n號盤子 從 from 到 to
			System.out.println("移動 '盤子" + no + "' 到 '" + to + "號柱子' " );
			// 移動 n-1 堆 盤子從 temp 放到 to
			towersOfHanoi( no -1, temp, to, from) ;
		}
		return;
	}
	// print
	public static void printStatus(int no, int from, int to, int temp) {
		System.out.println("  ---------------------- ");
		System.out.println("||       河  內  塔      ||");
		System.out.println("  ---------------------- ");
		System.out.printf("現在有 %d個 盤子, 從 %d號 柱子, 到 %d號 柱子 => ", no, from, to);		
		System.out.println("\n -- 開始 -- ");
		return;
	}

}
