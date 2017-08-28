
public class CFaculty extends CUnit{
	//	行政人員（Faculty）：包括姓名、職稱（position）
	//	protected String name;			//單位名稱
	//	protected CUnit parent; 			//所屬單位
	protected String position;
	

	public CFaculty(String n, CUnit p, String pos) {
		this.name = n;
		this.parent = p;
		this.position = pos;
	}
	
	public CUnit getParent() {
		return this.parent;
	}
	
	@Override public void output() {
		System.out.printf("%s %s\n", this.name, this.position);
	}

}
