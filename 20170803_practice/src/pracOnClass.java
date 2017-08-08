import java.util.Scanner;

public class pracOnClass {

	private static final int i = 0;
	public static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		// char c = 'a';
		// System.out.println(c);
		// longLine("---");
		// char[] arrayC = { 'a', 'b', 'c', 'd', 'e'};
		//
		// System.out.println(arrayC);
		// longLine("---");
		// for(int i = 0; i < arrayC.length; i++) {
		// System.out.println(arrayC[i]);
		// }
		// longLine("---");
		// int ASCIICode = 65;
		// char ASCII2Char = (char) ASCIICode;
		// System.out.println("ASCIICode = " + ASCIICode + " | ASCII2Code = " +
		// ASCII2Char);
		//
		// char lowerCaseA = 'a';
		// int char2ASCIICode = (int) lowerCaseA;
		// System.out.println("lowerCaseA = " + lowerCaseA + " | char2ASCIICode = " +
		// char2ASCIICode);
		// longLine("---");
		// System.out.println(" Num ");
		// int inputNum = scanner.nextInt();
		// System.out.println(" Char ");
		// char inputChar = scanner.next().charAt(0);
		// System.out.println("Num = " + inputNum + " | inputChar = " + inputChar);
		// longLine("---");
		longLine("###");
		System.out.println("\t\t7.2");
		longLine("###");
		// ------------------------------------------------------
		// 7.2
		// ------------------------------------------------------
		// ex7.2.1
		String text711 = "hello";
		System.out.println("字串內容： " + text711);
		System.out.println("字串長度： " + text711.length());
		System.out.println("等於 hello? " + text711.equals("hello"));
		System.out.println("轉為大寫： " + text711.toUpperCase());
		System.out.println("轉為小寫： " + text711.toLowerCase());
		longLine("---");
		// ex7.2.2
		String text722 = "One's left brain has nothing right.\n" + "One's right brain has nothing left.\n";
		System.out.println("text is => " + text722);
		for (int i = 0; i < text722.length(); i++)
			System.out.print(text722.charAt(i));
		System.out.println("");
		System.out.println("first 'left' position => " + text722.indexOf("left"));
		System.out.println("last 'left' position => " + text722.lastIndexOf("left"));
		char[] arrChar = text722.toCharArray();
		for (int i = 0; i < arrChar.length; i++)
			System.out.print(arrChar[i] + "");
		longLine("---");
		// ex 7.2.3
		char[] nameKCK = { 'K', 'i', 'n', 'g', 'c', 'h', 'e', 'n', 'k', 'o', 'n', 'g' };
		String strNameKCK = new String(nameKCK);
		System.out.println("strNameKCK => " + strNameKCK);
		longLine("###");
		String[] fileNames = { "caterpillar.jp", "cater.gif", "bushjpg", "wuwu.gif.jpg", "clockman.jpgif", "怕.jpg" };
		System.out.print("過濾 .jpg檔案 : ");
		for (int i = 0; i < fileNames.length; i++) {
			if (fileNames[i].endsWith(".jpg")) {
				System.out.print(fileNames[i] + " ");
			}
		}
		System.out.println("");
		longLine("###");
		System.out.println("\t\t7.3");
		longLine("###");
		// ------------------------------------------------------
		// 7.3
		// ------------------------------------------------------
		// ex7.3.1
		String strA = "Imagination is more important than knowledge.";
		String strB = "He who has Hope has everything.";
		String strC = "台上一分鐘，台下十年功";

		System.out.println(strA);
		System.out.println(strA.length());
		System.out.println(strB);
		System.out.println(strB.length());
		System.out.println(strC);
		System.out.println(strC.length());
		longLine("---");
		// ex7.3.2
		// String.concat( String )
		System.out.println(strA.concat(strB));
		System.out.println(strA + strB);
		System.out.println(strB);
		longLine("---");
		// ex7.3.3
		// String.format(String1, String, String);
		// String.format(locale, format, args)
		// String.format(format, args);
		String strAA = "%s is more important than %s.";
		String strBB = "He who has Hope has everything."; // 沒有輸入的%
		String strCC = "台上 %d 分鐘，台下 %d 年功。";
		// System.out.println(String.format(strAA, "Imagination", "knowledge"));
		// System.out.println(String.format(strBB, "everything")); // 沒有 %s, 沒有東西出來
		// System.out.println(String.format(strCC, 1, 10));
		// System.out.println(String.format( Locale.TRADITIONAL_CHINESE, strCC, 2, 2));
		longLine("---");
		// ex7.3.4
		// String[] split(String regex)
		// String[] split(String regex, int limit)

		String[] arrStringA = strA.split(" ");
		// 指定的字串regex 拿來分段 並且該字元不會計入
		String[] arrStringB = strB.split(" ", 2);
		// 最多分 2 段
		String[] arrStringC = strC.split("，");
		for (String str : arrStringA) {
			System.out.println(str);
		}
		System.out.println("\t\t###");
		for (String str : arrStringB) {
			System.out.println(str);
		}
		System.out.println("\t\t###");
		for (String str : arrStringC) {
			System.out.println(str);
		}
		System.out.println("\t\t###");
		longLine("---");
		// ex7.3.5
		// String subString(int beginIndex, int endIndex);
		// String subString(int beginIndex);
		System.out.println(strA.substring(0, 15));
		System.out.println(strB.substring(20));
		System.out.println(strC.substring(3, 6));
		System.out.println(strAA.substring(2));
		System.out.println(strCC.substring(10));

		longLine("---");
		// ex7.3.16
		System.out.println(strA.compareTo(strB));

	}

	// function
	// - 分隔線
	public static void longLine(String str) {
		for (int i = 0; i < 20; i++) {
			System.out.printf("%s", str);
		}
		System.out.println("");
	}

}
