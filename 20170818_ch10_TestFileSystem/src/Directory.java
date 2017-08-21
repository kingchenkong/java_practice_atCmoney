//代表一個資料夾當中的所有資訊
public class Directory extends FileEntity {	
	// Attributes
	private FileEntity[] dirList;		//此資料夾中所包含的目錄(用Linked List表示)
	private int itemCount;			//包含的項目個數

	// Constructor
	public Directory(String n) {
		super(n);
		this.setAttributes(new FileEntity[20], 0);
	}
	public Directory(String n, Directory p) {
		super(n, p);
		this.setAttributes(new FileEntity[20], 0);
		p.dirList[p.itemCount] = this;
		p.itemCount += 1;
	}
	// Method
	// - setter
	public boolean setAttributes(FileEntity[] dirList, int itemCount) {
		if(dirList != null)
			this.dirList = dirList;
		this.itemCount = itemCount;
		return true; //設定 成功
	}

	// - getter
	FileEntity[] getDirList() {
		return this.dirList;		
	}
	int getItemCount() {
		return this.itemCount;
	}

	public String[] search(String keyword) {
		//務必實作，以關鍵字搜尋檔名（可用遞迴）
		String[] arrStr = new String[50];
		String[] arrNameAndPath = new String[50];
		int arrCount = 0;

		if(this.isTerminal()) {
			for(int i = 0; i < this.itemCount; i++) {
				if(this.dirList[i].nameContainKeyWord(keyword)) {
					arrStr[arrCount] = this.dirList[i].getName();
					arrNameAndPath[arrCount] = this.dirList[i].getPath();
					arrCount += 1;
				}
			}
//			return arrStr;
			return arrNameAndPath;
		} 
		
		for(int i = 0; i < this.itemCount; i++) {
			if(this.dirList[i].getClass().getSimpleName().equals("Directory")) {
				Directory dir = (Directory) this.dirList[i];
				String[] result= dir.search(keyword);
				for(int j = 0; j < result.length; j++) {
					if(result[j] != null) {
					arrStr[arrCount] = result[j];
					arrNameAndPath[arrCount] = result[j];
					arrCount += 1;
					}
				}
			}
			if(this.dirList[i].nameContainKeyWord(keyword)) {
				arrStr[arrCount] = this.dirList[i].getName();
				arrNameAndPath[arrCount] = this.dirList[i].getPath();
				arrCount += 1;
			}
		}
//		return arrStr;
		return arrNameAndPath;
	}
	public boolean isTerminal() {
		int dirCount = 0;
		if(this.getPath() == null) 
			return false;
		
//		System.out.println("now in " + this.getName());
		for(int i = 0; i < this.itemCount; i++) {
			if(this.dirList[i].getClass().getSimpleName().equals("Directory")) {
//				System.out.println(this.dirList[i].getName() + " is Directory");
				dirCount += 1;
			}
		}
		return dirCount == 0;
	}
	// Override
	//	@Override
	//	public String toString() {
	//		
	//		return "--";
	//	}
}