import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Menu {
	// Scanner 
	public Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		// load in  map : Map.txt
		String filePath = "src//Map.txt";
//		System.out.println("filePath: " + filePath);
		MazeMap mMap = new MazeMap(filePath);
		//		mMap.printMap();
		String[] arrPath = new String[mMap.getMapCount()];
		// for map 0 ~< mapCount
		for(int i = 0; i < mMap.getMapCount(); i++) {
			// - get path
			// - sub function return string=> path
			String path = getMazePath(mMap, i);
			arrPath[i] = path;
		} // end for
		// - write in file : Path.txt
		try {
			FileWriter fw = new FileWriter("src//path.txt");
			BufferedWriter bfw = new BufferedWriter(fw);
			bfw.write("Maze file: " + filePath);
			bfw.newLine();
			for(int i = 0; i < arrPath.length; i++) {
				bfw.write("Maze No." + i + ":");
				bfw.newLine();
				bfw.write(arrPath[i]);
				bfw.newLine();
			}
			// close
			bfw.close();
			fw.close();
		} catch (IOException e){
			System.out.println(e);
		}
	}
	public static void test() {		
		// class test
		Test.testCStack();
		Test.testMazeMap();
		if(Test.testIsMazeCanExpot()) {
			System.out.println("path is found!!");
		} else {
			System.out.println("No path to Export.");
		}
	}
	public static String getMazePath(MazeMap map, int no) {
		int[][] nowMap = map.getOneMap(no);
//		MazeMap.printNowMap(nowMap);
		// - set mark
		int[][] mark = new int[nowMap.length][nowMap[0].length];
		// - entrance row&column
		int[] enRC = map.getEntrance(no);
		// - export row&column
		int[] exRC = map.getExport(no);
		// - now position
		int[] nowPos = {enRC[0], enRC[1]};
		// - now direction
		int[] nowDir = new int[2];
		// - next direction
		int[] nextDir = Move.DIRECTION[0];
		// stack
		CStack[] stack = new CStack[3];
		stack[0] = new CStack(); // row
		stack[1] = new CStack(); // column
		stack[2] = new CStack(); // direction
		// initial indexDir
		int indexDir = 0;
		// start maze
		do {
			//			indexDir = 0;
			// set now Position to mark
			mark[nowPos[0]][nowPos[1]] = 1;
			nowDir[0] = nextDir[0];
			nowDir[1] = nextDir[1];
			nextDir = Move.DIRECTION[indexDir];
			// try 8 direction
			while(indexDir < 8) {
				nextDir = Move.DIRECTION[indexDir];
				nowDir[0] = nextDir[0];
				nowDir[1] = nextDir[1];
				int newRow = nowPos[0] + nowDir[0];
				int newColumn = nowPos[1] + nowDir[1];
				if(nowMap[newRow][newColumn] == 0 && mark[newRow][newColumn] == 0) {
					if(stack[0].isFull()) 
						stack[0].resizeStack();
					if(stack[1].isFull()) 
						stack[1].resizeStack();
					if(stack[2].isFull()) 
						stack[2].resizeStack();
					// push stack
					stack[0].push(nowPos[0]);
					stack[1].push(nowPos[1]);
					stack[2].push(indexDir);
					// get new position
					nowPos[0] = newRow;
					nowPos[1] = newColumn;
					break;
				}
				++indexDir;
			}
			// the path is found!!
			if(nowPos[0] == exRC[0] && nowPos[1] == exRC[1]) {
				//				System.out.println();
				break;	// break and return true;
			}
			// no path
			if(indexDir == 8) {
				// pop
				nowPos[0] = stack[0].pop();
				nowPos[1] = stack[1].pop();
				indexDir = stack[2].pop();
				if(stack[0].isEmpty() && stack[1].isEmpty() && stack[2].isEmpty()) {
					return "No path to Export.\n";
				}
			} 
			else {
				indexDir = 0;
			}
			// now position
			//			System.out.print(" -> (" + nowPos[0] + ", " + nowPos[1] + ")");
		} while(!(stack[0].isEmpty() && stack[1].isEmpty() && stack[2].isEmpty()));

		// getPath and output
		String path = "";
		int l = stack[0].getTopPos();
		int[] arr1 = new int[l];
		int[] arr2 = new int[l];
		for(int i = 0; i < l; i++) {
			arr1[i] = stack[0].pop();
			arr2[i] = stack[1].pop();
		}
		path += String.format("Entrance: ( %2d, %2d)\n", enRC[0], enRC[1]);
		for(int i = l - 1; i >= 0; i--) {
			//			System.out.print(" -> (" + arr1[i] + ", " + arr2[i] + ")");
			if(i > 3 && i % 4 == 0)
				path += "\n";
			path += String.format(" -> ( %2d, %2d)", arr1[i], arr2[i]);
		}
		path += String.format(" -> \nExPort: ( %2d, %2d)\n", exRC[0], exRC[1]);
		return path;
	}
}
