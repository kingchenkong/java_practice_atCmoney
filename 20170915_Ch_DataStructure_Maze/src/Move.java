
public class Move {
	public static final int[][] DIRECTION = {Direction.N, Direction.NE, Direction.E, Direction.SE, Direction.S, Direction.SW, Direction.W, Direction.NW};
	public Move() {
		
	}
	static class Direction {
		// 順時針
		public static final int[] N =  {-1,  0};
		public static final int[] NE = {-1,  1};
		public static final int[] E  = { 0,  1};
		public static final int[] SE = { 1,  1};
		public static final int[] S  = { 1,  0};
		public static final int[] SW = { 1, -1};
		public static final int[] W  = { 0, -1};
		public static final int[] NW = {-1, -1};
	}
}
