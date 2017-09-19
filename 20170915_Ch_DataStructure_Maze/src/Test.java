
public class Test {
	public Test() {

	}
	public static boolean testIsMazeCanExpot() {
		// setting
		String filePath = "src//Map.txt";
		System.out.println("filePath: " + filePath);
		MazeMap mMap = new MazeMap(filePath);
		mMap.printMap();
		// - choose map
		int op = 2;
		int[][] nowMap = mMap.getOneMap(op);
		MazeMap.printNowMap(nowMap);
		// - set mark
		int[][] mark = new int[nowMap.length][nowMap[0].length];
		// - entrance row&column
		int[] enRC = mMap.getEntrance(op);
		// - export row&column
		int[] exRC = mMap.getExport(op);
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
				System.out.println();
				break;	// break and return true;
			}
			// no path
			if(indexDir == 8) {
				// pop
				nowPos[0] = stack[0].pop();
				nowPos[1] = stack[1].pop();
				indexDir = stack[2].pop();
				if(stack[0].isEmpty() && stack[1].isEmpty() && stack[2].isEmpty()) {
					return false;
				}
			} 
			else {
				indexDir = 0;
			}
			// now position
			System.out.print(" -> (" + nowPos[0] + ", " + nowPos[1] + ")");
		} while(!(stack[0].isEmpty() && stack[1].isEmpty() && stack[2].isEmpty()));
		
		// getPath and output
		int l = stack[0].getTopPos();
		int[] arr1 = new int[l];
		int[] arr2 = new int[l];
		for(int i = 0; i < l; i++) {
			arr1[i] = stack[0].pop();
			arr2[i] = stack[1].pop();
		}
		for(int i = l - 1; i >= 0; i--) {
			System.out.print(" -> (" + arr1[i] + ", " + arr2[i] + ")");
		}
			
		
		return true;
	}
	public static void testMazeMap() {
		String filePath = "src//Map.txt";
		System.out.println("filePath: " + filePath);
		MazeMap mMap = new MazeMap(filePath);
		mMap.printMap();
	}
	public static void testCStack() {
		CStack stack = new CStack();
		CStack.printStackStatus(stack, true);
		// push
		for(int i = 0; i < 12; i++) {
			// message - status
			System.out.println("---------------i = " + i + "---------------");
			// - push
			int pushFlag = stack.push(i);
			if(pushFlag == 1)
				System.out.println("push " + i + " : Success.");
			if(pushFlag == -1)
				System.out.println("push " + i + " : fail.");
			CStack.printStackStatus(stack, false);
			System.out.println("------------------------------------");
		}
		// pop
		for(int i = 0; i < 12; i++) {
			// message - status
			System.out.println("---------------i = " + i + "------------------");
			// - pop
			int popFlag = stack.pop();
			if(popFlag != -1)
				System.out.println("pop " + i + " : Success. popFlag = " + popFlag);
			if(popFlag == -1)
				System.out.println("pop " + i + " : fail.");
			CStack.printStackStatus(stack, false);
			System.out.println("------------------------------------");
		}
		// test resize
		for(int i = 0; i < 12; i++) {
			int pushFlag = stack.push(i);
			if(stack.isFull()) {
				// message - status
				System.out.println("---------------i = " + i + "---------------");
				// - push
				stack.resizeStack();
				if(pushFlag == 1)
					System.out.println("push " + i + " : Success.");
				if(pushFlag == -1)
					System.out.println("push " + i + " : fail.");
				CStack.printStackStatus(stack, false);
				System.out.println("------------------------------------");
			}
		}
		CStack.printStackStatus(stack, false);
		System.out.println("---element---");
		CStack.printStackElement(stack);
		CStack.printStackStatus(stack, false);

	}
}
