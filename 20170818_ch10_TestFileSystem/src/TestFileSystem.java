//簡易版的檔案管理系統
//
//請撰寫一個簡易版的檔案管理系統，用以協助使用者管理檔案與資料夾名稱；並提供以下的文字指令，用來進行檔案或資料夾的建立與檢視：
//ls：檢視所在目錄底下的所有檔名與目錄夾名稱。
//cd <資料夾名稱>：進入某一個資料夾當中。
//cd.. ：回上一層目錄。
//touch <檔名>：建立一個空檔案(註：並非真的建立檔案，僅僅是新增檔名而已)
//mkdir <資料夾名稱>：建立一個新的資料夾。
//search <關鍵字>：根據關鍵字搜尋目錄夾與其子目錄夾中所有包含該關鍵字的檔案與資料夾（大小寫不分	）
//
//執行範例如下（使用者輸入部分以黑體字標註）： 
//\root>ls
//Total: 0 files, 0 directories
//
//\root> touch aa
//\root>touch bbb
//\root>mkdir d1
//\root>mkdir d2
//\root>ls
//[d2]
//[d1]
//aa
//bbb 
//Total: 2 files, 2 directories
//
//\root>cd d1
//\root\d1>mkdir d3
//\root\d1>mkdir d4
//\root\d1>ls
//[d4]
//[d3]
//Total: 0 files, 2 directories
//
//\root\d1>cd..
//\root >search d
//\root\d2
//\root\d1
//\root\d1\d4
//\root\d1\d3
//
//\root >
import java.util.*;
public class TestFileSystem {

	// static
	static Scanner sc = new Scanner(System.in);

	// Directory
	static Directory posDir;	// 現在位置
	static Directory root = new Directory("root");
	static Directory user = new Directory("user", root);
	static Directory myDocuments = new Directory("myDocuments", user);


	// File
	static File fileAtRoot = new File("fileAtRoot.file",root);
	static File fileAtUser = new File("fileAtUser.file",user);
	static File fileAtMyDocuments001 = new File("fileAtMyDocuments001.file",myDocuments);
	static File fileAtMyDocuments002 = new File("fileAtMyDocuments002.file",myDocuments);

	public static void main(String[] args) {

		//test
		test();

		//main
		mainOperation();

	}
	static void mainOperation() {
		// initial
		init();

		do {
			String optionStr = sc.nextLine();
			//ls：檢視所在目錄底下的所有檔名與目錄夾名稱。
			if(optionStr.equals("ls")) {
				if(posDir.getItemCount() != 0) {
					for(int i = 0; i < posDir.getItemCount(); i++)
						System.out.println(posDir.getDirList()[i].getName());
				} else {
					System.out.println("此目錄 是空的");
				}
			} else if(optionStr.equals("exit")) {
				System.out.println("Exit program...");
				return ;
			} else if(optionStr.equals("help")){
				help();
			} else {
				// 處理字串
				String[] strSplit = optionStr.split(" ", 2);
				//test
				//				for(int i = 0; i < strSplit.length; i++)
				//					System.out.println(strSplit[i]);

				if(strSplit.length > 1 && !strSplit[1].equals("")) {
					if(strSplit[0].equals("cd")) {				//cd <資料夾名稱>：進入某一個資料夾當中。
						dirExistAndCd(strSplit[1], true);

					} else if(strSplit[0].equals("touch")) {		//touch <檔名>：建立一個空檔案(註：並非真的建立檔案，僅僅是新增檔名而已)
						if(nameIsDuplicated(strSplit[1] + ".file"))
							System.out.println("檔名重複, 此檔案已存在");
						else
							new File(strSplit[1] + ".file", posDir); 

					} else if(strSplit[0].equals("mkdir")) {		//mkdir <資料夾名稱>：建立一個新的資料夾。
						if(nameIsDuplicated(strSplit[1]))
							System.out.println("檔名重複, 此檔案已存在");
						else
							new Directory(strSplit[1], posDir); 

					} else if(strSplit[0].equals("search")) {	//search <關鍵字>：根據關鍵字搜尋目錄夾與其子目錄夾中所有包含該關鍵字的檔案與資料夾（大小寫不分	）
						// dev this...
						//
						
						
						
					} else {
						System.out.println("查無此指令.");
					}
				} else if(strSplit[0].equals("cd..")) {		//cd.. ：回上一層目錄。
					if(posDir == root) {
						System.out.println("已在 根目錄.");
					} else {
						posDir = posDir.getParent();
					}
				} else {
					System.out.println("指令格式 錯誤.");
				}
			}

			System.out.print(posDir.getPath() + ">");
		} while(true);

	}
	static void init() {
		// 進入 檔案管理系統
		System.out.println("---檔案管理系統---");
		posDir = root;
		System.out.print(posDir.getPath() + ">");

		return ;
	}
	static void help() {
		// 說明
		System.out.println("ls：  檢視所在目錄底下的所有檔名與目錄夾名稱。");
		System.out.println("cd <資料夾名稱>：進入某一個資料夾當中。");
		System.out.println("cd.. ：回上一層目錄。");
		System.out.println("touch <檔名>：建立一個空檔案(註：並非真的建立檔案，僅僅是新增檔名而已)");
		System.out.println("mkdir <資料夾名稱>：建立一個新的資料夾。");
		System.out.println("search <關鍵字>：根據關鍵字搜尋目錄夾與其子目錄夾中所有包含該關鍵字的檔案與資料夾（大小寫不分）");
		return;
	}
	static boolean dirExistAndCd(String dirStr, boolean andCdDir) {
		for(int i = 0; i < posDir.getItemCount(); i++) {
			if( dirStr.equals( posDir.getDirList()[i].getName() ) ) {
				if(andCdDir) {
					posDir = (Directory)posDir.getDirList()[i];
				}
				return true;
			}
		}
		System.out.println("目前目錄下 不存在 此目錄.");
		return false;
	}
	static boolean nameIsDuplicated(String name) {
		for(int i = 0; i < posDir.getItemCount(); i++) 
			if( name.equals( posDir.getDirList()[i].getName() ) ) 
				return true;
		return false;
	}

	static void test() {

		//		// Directory
		//		Directory root = new Directory("root");
		//		Directory user = new Directory("user", root);
		//		Directory myDocuments = new Directory("myDocuments", user);
		//
		//		// File
		//		File fileAtRoot = new File("fileAtRoot.file",root);
		//		File fileAtUser = new File("fileAtUser.file",user);
		//		File fileAtMyDocuments001 = new File("fileAtMyDocuments001.file",myDocuments);
		//		File fileAtMyDocuments002 = new File("fileAtMyDocuments002.file",myDocuments);
		//
		//		// fileAtRoot
		//		System.out.println(" ---" + fileAtRoot.getName() + "---");
		//		System.out.println(" parent.name: -" + fileAtRoot.getParent().getName());
		//		System.out.println("Path: " + fileAtRoot.getPath(fileAtRoot.getParent()) + "\\" + fileAtRoot.getName());
		//
		//		// fileAtUser
		//		System.out.println(" ---" + fileAtUser.getName() + "---");		
		//		System.out.println(" parent.name: -" + fileAtUser.getParent().getName());
		//		System.out.println("Path: " + fileAtUser.getPath(fileAtUser.getParent()) + "\\" + fileAtUser.getName());
		//		//		
		//		// fileAtMyDocuments001
		//		System.out.println(" ---" + fileAtMyDocuments001.getName() + "---");
		//		System.out.println("Path: " + fileAtMyDocuments001.getPath(fileAtMyDocuments001.getParent()) + "\\" + fileAtMyDocuments001.getName());

		// fileAtMyDocuments002
		System.out.println(" ---" + fileAtMyDocuments002.getName() + "---");
		System.out.println("Path: " + fileAtMyDocuments002.getPath());
		System.out.println(" ---" + myDocuments.getName() + "---");
		System.out.println("Path: " + myDocuments.getPath());
		System.out.println("-----------------------------------");
		FileEntity[] ls = root.getDirList();
		for(int i = 0; i < ls.length; i++) 
			if(ls[i] != null)
				System.out.println(ls[i].getName());
			else 
				break;

		System.out.println("-----------------------------------");
		System.out.println("-dir user isTerminal? => " + user.isTerminal());
		System.out.println("-dir myDocunents isTerminal? => " + myDocuments.isTerminal());
		System.out.println("-----------------------------------");
		Directory dirOp2324256 = new Directory("dirOp2324256", user);
		File opfiles100023445 = new File("opfiles100023445.file",root);
		System.out.println(dirOp2324256.nameContainKeyWord("dIrop"));
		System.out.println(opfiles100023445.nameContainKeyWord("pfiles10002344"));
		System.out.println("-----------------------------------");

		String[] arrStr = root.search("opb");

		System.out.println("--------------search 'opb' : ");
		if(arrStr[0] != null) {
			for(int i = 0; i < arrStr.length; i++) {
				if(arrStr[i] != null) {
					System.out.println(arrStr[i]);
				}
			}
		} else {
			System.out.println("無 符合 之 項目");
		}




	}

}
