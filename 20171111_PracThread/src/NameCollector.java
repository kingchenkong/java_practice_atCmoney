import java.util.ArrayList;

public class NameCollector implements CallBackInterface{

	private ArrayList<String> nameList;

	public NameCollector() {
		// 初始化於建構子中實作
		nameList = new ArrayList<String>(); 
	}

	@Override
	public void sendMessage(String str) { 
		// 實作介面方法
		nameList.add(str);
	}

	@Override
	public String toString() { 
		// 利用覆寫toString方法來做該類別的輸出
		String str = "";
		for(int i = 0; i < nameList.size(); i++){
			str += nameList.get(i)+"\n";
		}
		return str;
	}
}