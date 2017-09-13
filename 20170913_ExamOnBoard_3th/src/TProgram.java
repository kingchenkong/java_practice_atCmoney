import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TProgram {
	// Attributes
	public static final String syntaxError = "Syntax error!";
	public static final String filePath = "src//";
	private String souFileName;
	private String destFileName;
	private FileReader fr;
	private BufferedReader bfr;
	private String[] commandLine;
	private int commandLineCount;
	private int nowLineCount;

	private int reg;

	// tokens, args
	private String[] command;
	private int[] para;

	// Constructor
	public TProgram(String source, String dest) {
		// register = 0
		this.reg = 0;

		try {
			this.souFileName = source;
			this.destFileName = dest;
			this.fr = new FileReader(TProgram.filePath + this.souFileName);
			this.bfr = new BufferedReader(this.fr);
			this.commandLine = new String[5];
			this.commandLineCount = 0;

			String readStr;

			while( (readStr = bfr.readLine()) != null) {
				// resize
				if(this.commandLineCount == this.commandLine.length) {
					String[] copy = new String[this.commandLine.length * 2];
					for(int i = 0; i < this.commandLineCount; i++) 
						copy[i] = this.commandLine[i];
					this.commandLine = copy;
				}
				// 空行
				if(readStr.equals(""))
					continue;
				// load in : commandLine 
				this.commandLine[this.commandLineCount++] = readStr;
			}
			this.command = new String[this.commandLineCount];
			this.para = new int[this.commandLineCount];

			this.nowLineCount = 0;
			for(int i = 0; i < this.commandLineCount; i++) {
				// parser
				if(this.isTLangLine(this.commandLine[i]) == 0) {
					System.out.println(TProgram.syntaxError);
				}
				this.nowLineCount = i;
				this.para[i] = -1;
				int cmNum = this.parser(this.commandLine[i], this.para);
				switch(cmNum) {
				case 0:	// load
					this.command[i] = "LOAD";
					break;
				case 1:	// add
					this.command[i] = "ADD";
					break;
				case 2: // prt
					this.command[i] = "PRT";
					this.para[i] = -1;
					break;
				default:
					//					System.out.println("Error: Constructor - switch.");
					this.command[i] ="";
					this.para[i] = -1;
				}
			}
			//close
			bfr.close();
			fr.close();
			// test console
			//			for(int i = 0; i < this.command.length; i++) {
			//				System.out.println(i + " - " + this.command[i] + "," + this.para[i]);
			//			}	
			if(this.compile())
				System.out.println("done.");
			else
				System.out.println(TProgram.syntaxError);

		} catch (FileNotFoundException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
		}
	}
	// Method
	// compile
	public boolean compile() {
		// reset register
		this.reg = 0;
		try {
			// T prog.txt oo.txt
//			System.out.println(TProgram.filePath + this.destFileName);
			FileWriter fw = new FileWriter(TProgram.filePath + this.destFileName);
			BufferedWriter bfw = new BufferedWriter(fw);

			// line to line
			for(int i = 0; i < this.commandLineCount; i++) {
				if(this.command[i].equals("LOAD")) {
					if(this.para[i] == -1)
						return false;
					this.reg = this.para[i];

				}
				if(this.command[i].equals("ADD")) {
					if(this.para[i] == -1)
						return false;
					this.reg += this.para[i];
				}
				if(this.command[i].equals("PRT")) {
					if(this.para[i] != -1)
						return false;
//					System.out.println(this.reg);
					String str = String.format("%d", this.reg);
					bfw.write(str);
					bfw.newLine();
				}
				if(this.command[i].equals("")) {
					return false;
				}
			}
			// close
			bfw.flush();
			bfw.close();
			fw.close();
			return true;
		} catch (FileNotFoundException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
		}
		// if error.
		return false;
	}

	//(e)
	//	請判斷字串s是否滿足T語言的指令格式，如果有錯誤地方請回傳-1。如果指令是LOAD便回傳0，ADD則回傳1，PRT回傳2。如指令後有其他數字，便存到params之中。
	public int parser(String s, int[] params) {
		if(this.isTLangLine(s) == 1) {
			String[] split = s.split(" ");
			if(split[0].compareToIgnoreCase("load") == 0) {
				split[1] = split[1].replaceAll(";", "");
				if(split[1].equals(""))
					return -1;
				params[this.nowLineCount] = Integer.parseInt(split[1]);
				return 0;
			}
			if(split[0].compareToIgnoreCase("add") == 0) {
				split[1] = split[1].replaceAll(";", "");
				if(split[1].equals(""))
					return -1;
				params[this.nowLineCount] = Integer.parseInt(split[1]);
				return 1;
			}
			if(split[0].compareToIgnoreCase("prt;") == 0)
				return 2;
		} 
		return -1;
	}
	//(d)
	public int tokensCount(String line) {
		String[] split = line.split(" ");
		if(split[0].equals(""))
			return 0;
		if(!this.endCharIsCorrect(line))
			return 0;
		if(split.length > 2)
			return 0;
		return split.length;
	}
	//(c)
	public int isTLangLine(String line) {
		String[] split = line.split(" ");
		if(this.tokensCount(line) == 2) {
			split[1] = split[1].replaceAll(";", "");
			if(split[0].compareToIgnoreCase("load") == 0 || split[0].compareToIgnoreCase("add") == 0) {
				if(this.isPostiveIntegerString(split[1])) {
					return 1; // is T language
				}
			}
		}
		if(this.tokensCount(line) == 1) {
			split[0] = split[0].replaceAll(";", "");
			if(split[0].compareToIgnoreCase("prt") == 0) {
				return 1; // is T language
			}
		}
		return 0;
	}
	public boolean endCharIsCorrect (String line) {
		char[] arrC = line.toCharArray();
		if( (int)arrC[arrC.length-1] == 59 ) 
			return true;
		return false;
	}
	//(b)
	public boolean isPostiveIntegerString (String numStr) {
		char[] arrC = numStr.toCharArray();
		for(int i = 0; i < arrC.length; i++) {
			if( (int)arrC[i] < 48 || (int)arrC[i] > 57)
				return false;
		}
		return true;
	}
	//(a)
	public String cutBlankAndToUpperCase(String str) {
		str = str.replaceAll("\\s+", "");
		str = str.toUpperCase();
		return str;
	}
	// Getter
	public String getCommandWithLineIndex(int index) {
		return this.command[index];
	}
	public int getParameterWithLineIndex(int index) {
		return this.para[index];
	}
	public int getCommandLineCount() {
		return this.commandLineCount;
	}
	// Setter
}
