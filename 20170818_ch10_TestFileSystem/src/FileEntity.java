//代表一個檔案系統中的項目，可能是目錄也可能是檔案
class FileEntity { 	
	//Attributes
	private Directory parent;	//代表上一層目錄；如果是此資料夾為根目錄，便設為NULL
	private String name;		//資料夾或檔案名稱


	// Constructor
	public FileEntity(String n) {
		this.name = n;
	}
	public FileEntity(String n, Directory p) {
		this.name = n;
		setParent(p);
	}
	// Method
	// - setter
	public boolean setParent(Directory dir) {
		this.parent = dir;
		return true; // 搬移成功
	}

	// - getter
	public Directory getParent() {
		return this.parent;
	}
	public String getName() {
		//取得項目名稱
		return this.name;
	}

	public String getPath(Directory p) {
		// 取得當下路徑
		String strPath = "";
		if( p.getName() == "root" ) {
			return String.format("\\root");
		} 
		//		return "--";
		strPath += p.getPath(p.getParent());
		strPath += "\\" + p.getName();
		return strPath;
	}
	public String getPath() {
		// 取得當下路徑
		String strPath = "\\" + this.getName();
		Directory p = this.getParent();
		while(p != null) {
			strPath = String.format("%s%s%s", "\\", p.getName(), strPath);
			p = p.getParent();
		}
		return strPath;
	}
	public boolean nameContainKeyWord(String keyword) {
		String lowKey = keyword.toLowerCase();
		String thisName = this.getName().toLowerCase();
		char[] arrChKey = lowKey.toCharArray();
		char[] arrChThis = thisName.toCharArray();
		
		for(int i = 0; i < arrChThis.length - keyword.length(); i++) {
			if(arrChThis[i] == arrChKey[0]) {
				int count = 0;
				for(int j = 0; j < arrChKey.length; j++) {
					if(arrChThis[i+j] == arrChKey[j]) {
						count += 1;
					}
				}
				if(count == keyword.length()) {
					return true;
				}
			}
		}
		return false;
	}

}