//實作一個將 '成績輸入' 陣列的程式。
//請注意，陣列的大小一開始必須為 '2' ，當陣列儲存空間不足時，須將陣列的容量變成原先的 '兩倍' 。

import java.util.Scanner;
import java.util.Arrays;
import java.util.*;
public class prac3f {

	public static void main(String[] args) {
		//declare, initial
		Scanner scanner = new Scanner(System.in);
		//array
		int[] arrayScore = new int[2];
		Arrays.fill(arrayScore, -1);

		//var
		int inputScore = 0;

		//process control
		boolean redo = true;
		int arrayScoreIndex = 0;
		boolean reInput;
		boolean nextInput;


		//begin
		//input
		System.out.println("輸入成績 階段,需離開 請輸入 '-1' ");
		do {

			do {
				System.out.println("請輸入成績: ");
				inputScore = scanner.nextInt();
				//檢查成績
				if( (inputScore > 100) || (inputScore < -1) ) {
					System.out.println(" -- 輸入不合法!! -- ");
					reInput = true;
				} else {
					reInput = false;
				}
			} while(reInput);
			
			//store
			if(arrayScoreIndex == arrayScore.length) {
				arrayScore = Arrays.copyOf(arrayScore, arrayScore.length * 2);
				System.out.println("score.length = " + arrayScore.length);
			}
			arrayScore[arrayScoreIndex] = inputScore; 

			//while-out to print
			if(inputScore == -1) {
				nextInput = false;
			} else {
				nextInput = true;
				arrayScoreIndex += 1;
			}
		} while (nextInput);

		//print
		for(int i = 0; i < arrayScore.length; i++) {
			//只顯示非-1
			if(arrayScore[i] == -1) {
				break;
			}
			System.out.printf("score [%2d] = %3d \n", i + 1, arrayScore[i] );
		}

		//recycle
		scanner.close();

	}

}
